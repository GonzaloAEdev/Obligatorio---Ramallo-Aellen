package obligatorio.parte1;

import obligatorio.parte1.Interfaces.IObligatorio;
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
        p.ver(s.registrarSala("Sala Verde", 45).resultado, Retorno.Resultado.OK, "Registrar sala Verde");
        p.ver(s.registrarSala("Sala Verde", 30).resultado, Retorno.Resultado.ERROR_1, "Sala ya existente");
        p.ver(s.registrarSala("Sala Roja", -5).resultado, Retorno.Resultado.ERROR_2, "Capacidad negativa");
        
            
        p.ver(s.registrarSala("Sala Naranja", 40).resultado, Retorno.Resultado.OK, "Registrar sala Naranja");
        p.ver(s.registrarSala("Sala Blanca", 60).resultado, Retorno.Resultado.OK, "Registrar Sala Blanca");
        p.ver(s.registrarSala("Sala Negra", 70).resultado, Retorno.Resultado.OK, "Registrar Sala Negra");
        p.ver(s.registrarSala("Sala Gris", 40).resultado, Retorno.Resultado.OK, "Registrar Sala Gris");

        // Mostrar salas
        p.ver(s.listarSalas().resultado, Retorno.Resultado.OK, "Listar salas luego de registros");

        // 1.3 - Eliminar sala
        p.ver(s.eliminarSala("Sala Roja").resultado, Retorno.Resultado.ERROR_1, "Eliminar sala no registrada");
        p.ver(s.eliminarSala("Sala Verde").resultado, Retorno.Resultado.OK, "Eliminar sala Verde");

        // Mostrar salas despues de eliminar
        p.ver(s.listarSalas().resultado, Retorno.Resultado.OK, "Listar salas luego de eliminaciones");

        // 1.4 - Registrar eventos
        p.ver(s.registrarSala("Sala Azul", 50).resultado, Retorno.Resultado.OK, "Registrar sala Azul");
        
        LocalDate fecha = LocalDate.of(2025, 6, 10);
        
        
        p.ver(s.registrarEvento("EV108", "Evento A", 30, fecha).resultado, Retorno.Resultado.OK, "Registrar evento valido");
        p.ver(s.registrarEvento("EV108", "Evento A", 30, fecha).resultado, Retorno.Resultado.ERROR_1, "Ya existe evento con ese codigo (EV108) Registrar evento valido");
        p.ver(s.registrarEvento("EV108", "Evento A", 30, fecha).resultado, Retorno.Resultado.ERROR_1, "Ya existe evento con ese codigo (EV108) Registrar evento valido");
        p.ver(s.registrarEvento("EV108", "Evento B", 25, fecha).resultado, Retorno.Resultado.ERROR_3, "Codigo duplicado");
        p.ver(s.registrarEvento("EV102", "Evento C", -1, fecha).resultado, Retorno.Resultado.ERROR_2, "Aforo negativo");

        p.ver(s.registrarEvento("EV108", "Evento A", 3000, fecha).resultado, Retorno.Resultado.ERROR_5, "No hay sala para ese aforo");

        
        // Mostrar eventos
        p.ver(s.listarEventos().resultado, Retorno.Resultado.OK, "Listar eventos registrados");

        // 1.5 - Registrar clientes
        p.ver(s.registrarCliente("1234", "Cliente X").resultado, Retorno.Resultado.ERROR_1, "Cedula invalida (corta)");
        
        p.ver(s.registrarCliente("12345678", "Carlos").resultado, Retorno.Resultado.OK, "Cliente valido");
        p.ver(s.registrarCliente("12345678", "Carlos").resultado, Retorno.Resultado.ERROR_2, "Cliente ya existe");
       // p.ver(s.registrarCliente("12345678", "").resultado, Retorno.Resultado.ERROR_3, "Nombre vacio");      
        // Mostrar clientes
        p.ver(s.listarClientes().resultado, Retorno.Resultado.OK, "Listar clientes registrados");

        // 2.4 - Evaluar sala optima - matriz optima
        String[][] vistaOptima = {
            {"#", "#", "#", "#", "#"},
            {"#", "O", "O", "X", "#"},
            {"#", "O", "O", "X", "#"},
            {"#", "O", "O", "X", "#"},
            {"#", "#", "#", "#", "#"}
        };
        p.ver(s.esSalaOptima(vistaOptima).resultado, Retorno.Resultado.OK, "Evaluar sala optima (esperado: Es optimo)");

        // 2.4 - Evaluar sala optima - matriz no optima
        String[][] vistaNoOptima = {
            {"#", "#", "#", "#"},
            {"#", "O", "X", "#"},
            {"#", "O", "X", "#"},
            {"#", "X", "X", "#"},
            {"#", "#", "#", "#"}
        };
        p.ver(s.esSalaOptima(vistaNoOptima).resultado, Retorno.Resultado.OK, "Evaluar sala no optima (esperado: No es optimo)");

        Prueba.finPrueba("FIN PRUEBA COMPLETA");
        
        p.imprimirResultadosPrueba();  
    }    
}
