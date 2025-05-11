package obligatorio.parte1.Interfaces;

import java.time.LocalDate;
import obligatorio.parte1.Retorno;

public interface IObligatorio {

    /*
    **************** REGISTROS y ELIMINACIÓN PARTE 1 **************************************
     */
    
    public Retorno crearSistemaDeGestion();

    public Retorno registrarSala(String nombre, int capacidad);

    public Retorno eliminarSala(String nombre);

    public Retorno registrarEvento(String codigo, String descripcion, int aforoNecesario,
            LocalDate fecha);

    public Retorno registrarCliente(String cedula, String nombre);
  
    /*
    **************** REPORTES Y CONSULTAS  PARTE 1 **************************************
     */
    
    public Retorno listarSalas();
    
   public Retorno listarEventos();

   public Retorno listarClientes();
   
   public Retorno esSalaOptima(String vistaSala[][]);
    
}
