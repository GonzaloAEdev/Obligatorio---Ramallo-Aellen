package SistemaAutogestion;

import Interfaces.IObligatorio;
import java.time.LocalDate;

public class Obligatorio {
  
    public static void main(String[] args) {             
        Prueba p = new Prueba();
        Sistema s = new Sistema();
        juegoPruebas(p, s);    
    }


public static void juegoPruebas(Prueba p, IObligatorio s) {
        Prueba.tituloPrueba("PRUEBA COMPLETA DEL SISTEMA");
//      puntos a testear  1.1, 1.2, 1.3, 1.4, 1.5, 2.1, 2.2, 2.3, 2.4.

        // 1.1 - Crear sistema
        p.ver(s.crearSistemaDeGestion().resultado, Retorno.Resultado.OK, "Sistema inicializado correctamente");

        // 1.2 - Registrar salas
        p.ver(s.registrarSala("Sala A", 45).resultado, Retorno.Resultado.OK, "Registrar sala A");
        p.ver(s.registrarSala("Sala A", 30).resultado, Retorno.Resultado.ERROR_1, "Ya existe una sala con ese nombre");
        p.ver(s.registrarSala("Sala X", -5).resultado, Retorno.Resultado.ERROR_2, "Capacidad negativa");
        
            
        p.ver(s.registrarSala("Sala C", 40).resultado, Retorno.Resultado.OK, "Registrar sala C");
        p.ver(s.registrarSala("Sala D", 60).resultado, Retorno.Resultado.OK, "Registrar Sala D");
        p.ver(s.registrarSala("Sala E", 70).resultado, Retorno.Resultado.OK, "Registrar Sala E");
        p.ver(s.registrarSala("Sala C", 60).resultado, Retorno.Resultado.ERROR_1, "Ya existe una sala con ese nombre (Sala C)");

        // 1.3 - Eliminar sala
        p.ver(s.eliminarSala("Sala X").resultado, Retorno.Resultado.ERROR_1, "No existe una sala con ese nombre (Sala X)");
        p.ver(s.eliminarSala("Sala D").resultado, Retorno.Resultado.OK, "Sala D eliminada");

        // 1.4 - Registrar eventos
        LocalDate fecha = LocalDate.of(2025, 6, 10);
        
        p.ver(s.registrarEvento("BBCITA1","Orquesta Nacional", 50, LocalDate.of(2025,8,12)).resultado, Retorno.Resultado.OK, "Evento Orquesta Nacional registrado");
        p.ver(s.registrarEvento("3ICKKCK","Orquesta Juvenil", 60, fecha).resultado, Retorno.Resultado.OK, "Evento Orquesta Juvenil registrado");
        p.ver(s.registrarEvento("123ABCD","Concierto Duki", 45, LocalDate.of(2025,6,2)).resultado, Retorno.Resultado.OK, "Evento Duki registrado");
        
        
        p.ver(s.registrarEvento("123ABCD","El cisne azul", 30, LocalDate.of(2025,8,23)).resultado, Retorno.Resultado.ERROR_1, "Ya existe un evento con ese codigo");
        p.ver(s.registrarEvento("ABC2322","Ruben Rada", 0, LocalDate.of(2025,11,11)).resultado, Retorno.Resultado.ERROR_2, "El aforo debe ser mayor a 0");
        p.ver(s.registrarEvento("XMELRA2","El hombre de nieve", 60, fecha).resultado, Retorno.Resultado.ERROR_3, "Ya existe un evento para esa fecha");
        p.ver(s.registrarEvento("XLR8B10","Concierto Duki", 100, LocalDate.of(2025,6,2)).resultado, Retorno.Resultado.ERROR_3, "No se encontro una sala para ese aforo en ese dia");
        
        // 1.5 - Registrar clientes
        p.ver(s.registrarCliente("4305", "Mathias").resultado, Retorno.Resultado.ERROR_2, "Cedula invalida (Debe tener al menos 8 numeros)");

        p.ver(s.registrarCliente("4305673-1", "Mathias").resultado, Retorno.Resultado.OK, "Cliente creado con exito");
        p.ver(s.registrarCliente("4305673-1", "Mathias").resultado, Retorno.Resultado.ERROR_4, "Cliente ya existe");
        p.ver(s.registrarCliente("4305673-1", "").resultado, Retorno.Resultado.ERROR_3, "Nombre vacio"); 

        
        // 2.1 - Listar Salas
        p.ver(s.listarSalas().resultado, Retorno.Resultado.OK, "Listar salas registrados");
        
        // 2.2 - Listar Eventos
        p.ver(s.listarEventos().resultado, Retorno.Resultado.OK, "Listar eventos registrados");
        
        // 2.3 - Listar Clientes
        p.ver(s.listarClientes().resultado, Retorno.Resultado.OK, "Listar clientes registrados");
        
        // 2.4 - Sala optima
        String[][] vistaOptima = {
            {"#", "#", "#", "#", "#"},
            {"#", "O", "O", "X", "#"},
            {"#", "O", "O", "X", "#"},
            {"#", "O", "O", "X", "#"},
            {"#", "#", "#", "#", "#"}
        };
        p.ver(s.esSalaOptima(vistaOptima).resultado, Retorno.Resultado.OK, "Evaluar sala optima (esperado: Es optimo)");

        String[][] vistaNoOptima = {
            {"#", "#", "#", "#"},
            {"#", "O", "X", "#"},
            {"#", "O", "X", "#"},
            {"#", "X", "X", "#"},
            {"#", "#", "#", "#"}
        };
        p.ver(s.esSalaOptima(vistaNoOptima).resultado, Retorno.Resultado.ERROR_1, "Evaluar sala no optima (esperado: No es optimo)");

        Prueba.finPrueba("FIN PRUEBA COMPLETA");
        
        p.imprimirResultadosPrueba();  
    }    
}
