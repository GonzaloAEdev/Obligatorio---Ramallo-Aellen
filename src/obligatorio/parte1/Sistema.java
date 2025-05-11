package obligatorio.parte1;

import obligatorio.parte1.Nodos.NodoSala;
import obligatorio.parte1.Listas.ListaSala;
import obligatorio.parte1.Listas.ListaCliente;
import obligatorio.parte1.Listas.ListaEvento;
import obligatorio.parte1.Interfaces.IObligatorio;
import java.time.LocalDate;

public class Sistema implements IObligatorio {
    
    ListaSala ls;
    ListaCliente lc;
    ListaEvento le;
    
    @Override
    public Retorno crearSistemaDeGestion() {     
         ls= new ListaSala();
         lc= new ListaCliente();
        
        return Retorno.ok();
    }

    @Override
    public Retorno registrarSala(String nombre, int capacidad) {
        ls.agregarOrd(0, nombre, capacidad);
        return Retorno.noImplementada();
    }

    @Override
    public Retorno eliminarSala(String nombre) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno registrarEvento(String codigo, String descripcion, int aforoNecesario, LocalDate fecha) {
        NodoSala nsdisponible= ls.obtenerElementoSegunAforo(aforoNecesario);
        
        if (nsdisponible!=null){
            System.out.println("Encontre una sala " + nsdisponible.getNombre()+" capacidad "+ nsdisponible.getCapacidad()+ " Para el aforo " +aforoNecesario);
            nsdisponible.getLevento().agregarOrd(Integer.parseInt(codigo), descripcion, aforoNecesario);
       
        
        
        }else{
            System.out.println("No hay Sala para ese aforo "+ aforoNecesario);
        }
        
        return Retorno.noImplementada();
    }

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
        le.mostrar();
        return Retorno.ok();
    }

    @Override
    public Retorno listarClientes() {
        lc.mostrar();
        return Retorno.ok();
    }

    @Override
    public Retorno esSalaOptima(String[][] vistaSala) {
        return Retorno.noImplementada();
    }

}
