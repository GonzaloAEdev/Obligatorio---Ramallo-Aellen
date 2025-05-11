package SistemaAutogestion;

import Nodos.NodoSala;
import Listas.ListaSala;
import Listas.ListaCliente;
import Listas.ListaEvento;
import Interfaces.IObligatorio;
import java.time.LocalDate;

public class Sistema implements IObligatorio {
    
    ListaSala ls;
    ListaCliente lc;
    ListaEvento le;

    @Override
    // 1.1
    public Retorno crearSistemaDeGestion() {     
         ls= new ListaSala();
         lc= new ListaCliente();
        return Retorno.ok("Sistema creado con exito");
    }

    // 1.2
    @Override
    public Retorno registrarSala(String nombre, int capacidad) {
        if(ls.buscarelementoPorNom(nombre)){
            return Retorno.error1(); // Ya existe sala con este nombre
        }else if(capacidad <= 0){
            return Retorno.error2(); // La capacidad es <= 0
        }else{
            ls.agregarOrd(nombre, capacidad);    
            return Retorno.ok();
        }     
    }

    // 1.3    
    @Override
    public Retorno eliminarSala(String nombre) {
        if(!ls.buscarelementoPorNom(nombre)){
            return Retorno.error1(); // No existe sala con este nombre
        }else{
            ls.borrarElemento(nombre);
            return Retorno.ok("Si pudo eliminar la sala");
        }
    }

    // 1.4
    @Override
public Retorno registrarEvento(String codigo, String descripcion, int aforoNecesario, LocalDate fecha) {
    // Validaciones básicas
    if (codigo == null || codigo.isEmpty()) {
        return Retorno.error1();
    }
    if (aforoNecesario <= 0) {
        return Retorno.error2();
    }

    // Verificar si ya existe el evento
    NodoSala actual = ls.getPrimero();
    while (actual != null) {
        if (actual.getLevento().buscarelemento(codigo)) {
            return Retorno.error1();
        }
        actual = actual.getSiguiente();
    }

    // Buscar sala disponible
    NodoSala salaDisponible = ls.encontrarSalaDisponible(aforoNecesario, fecha);
    if (salaDisponible == null) {
        return Retorno.error3();
    }

    // Registrar evento
    salaDisponible.getLevento().agregarOrd(codigo, descripcion, aforoNecesario, fecha, salaDisponible);
    return Retorno.ok("Evento registrado en sala: " + salaDisponible.getNombre());
}

    // 1.5
    @Override
    public Retorno registrarCliente(String cedula, String nombre) {
        // Validación de parámetros
        if (cedula == null || cedula.isEmpty()) {
            return Retorno.error1();
        }
        
        if (cedula.length() < 8) {
            return Retorno.error2();
        }
        
        if (nombre == null || nombre.isEmpty()) {
            return Retorno.error3();
        }
        
        // Verificar si el cliente ya existe
        if (lc.buscarelemento(cedula, nombre)) {
            return Retorno.error4(); 
        }
        
        // Registrar el nuevo cliente
        lc.agregarOrd(cedula, nombre);
        return Retorno.ok("Cliente registrado exitosamente");
    }

    @Override
    public Retorno listarSalas() {
        ls.mostrar();
        return Retorno.ok();
    }

    @Override
    public Retorno listarEventos() {
        ls.mostrarEventos();
        return Retorno.ok();
    }

    @Override
    public Retorno listarClientes() {
        lc.mostrar();
        return Retorno.ok();
    }

@Override
    public Retorno esSalaOptima(String[][] vistaSala) {
        // Validar que la matriz no sea nula o vacía
    if (vistaSala == null || vistaSala.length == 0 || vistaSala[0].length == 0) {
        return Retorno.error1();
    }
    
    int columnasCumplen = 0;
    int numColumnas = vistaSala[0].length;
    
    // Recorrer cada columna (excepto los bordes que son "#")
    for (int col = 1; col < numColumnas - 1; col++) {
        int asientosOcupadosConsecutivos = 0;
        int maxOcupadosConsecutivos = 0;
        int asientosLibres = 0;
        
        // Recorrer cada fila de la columna actual
        for (String[] vistaSala1 : vistaSala) {
            String asiento = vistaSala1[col];
            // Contar asientos libres y ocupados consecutivos
            if (asiento.equals("O")) {
                asientosOcupadosConsecutivos++;
                if (asientosOcupadosConsecutivos > maxOcupadosConsecutivos) {
                    maxOcupadosConsecutivos = asientosOcupadosConsecutivos;
                }
            } else if (asiento.equals("X")) {
                asientosLibres++;
                asientosOcupadosConsecutivos = 0; // Reiniciar conteo consecutivo
            }
            // Ignorar los bordes ("#")
        }
        
        // Verificar si la columna cumple con la condición de optimalidad
        if (maxOcupadosConsecutivos > asientosLibres) {
            columnasCumplen++;
            
            // Si ya tenemos 2 columnas que cumplen, podemos terminar
            if (columnasCumplen >= 2) {
                return Retorno.ok("Es óptimo");
            }
        }
    }
    
    // Si no se encontraron al menos 2 columnas que cumplan
    return Retorno.error1();
    }

}
