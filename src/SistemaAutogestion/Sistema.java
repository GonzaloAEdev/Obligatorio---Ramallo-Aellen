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
            return new Retorno(Retorno.Resultado.ERROR_1); // Ya existe sala con este nombre
        }else if(capacidad <= 0){
            return new Retorno(Retorno.Resultado.ERROR_2); // La capacidad es <= 0
        }else{
            ls.agregarOrd(nombre, capacidad);    
            return Retorno.ok();
        }     
    }

    // 1.3    
    @Override
    public Retorno eliminarSala(String nombre) {
        if(ls.buscarelementoPorNom(nombre)){
            return new Retorno(Retorno.Resultado.ERROR_1); // Ya existe sala con este nombre
        }else{
            ls.borrarElemento(nombre);
            return Retorno.ok("Si pudo eliminar la sala");
        }
    }

    // 1.4
    @Override
    public Retorno registrarEvento(String codigo, String descripcion, int aforoNecesario, LocalDate fecha) {
        NodoSala nsdisponible= ls.encontrarSalaDisponible(aforoNecesario, fecha, codigo);
        if(ls.getPrimero().getLevento().buscarelemento(codigo)){
            return new Retorno(Retorno.Resultado.ERROR_1); // ya existe un evento con este codigo
        }else if(aforoNecesario <= 0){
            return new Retorno(Retorno.Resultado.ERROR_2); // Aforo es necesario
        }else if (nsdisponible ==null){
            return new Retorno(Retorno.Resultado.ERROR_3); // No hay salas disponibles para esta fecha con aforo suficiente
        }else{
            System.out.println("Encontre una sala " + nsdisponible.getNombre()+" capacidad "
                    + nsdisponible.getCapacidad()+ " Para el aforo " +aforoNecesario+" Para la fecha "+fecha);
            nsdisponible.getLevento().agregarOrd(codigo,descripcion,aforoNecesario,fecha,nsdisponible);
            return Retorno.ok();
        }

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
