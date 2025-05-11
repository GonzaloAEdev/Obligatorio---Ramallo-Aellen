package Interfaces;

import java.time.LocalDate;
import Nodos.NodoEvento;
import Nodos.NodoSala;

public interface IListaEvento {
    public boolean esVacia();
    public void agregarInicio(String codigo, String descripcion,int aforo, LocalDate fecha, NodoSala salaAsignada);
    public void agregarFinal(String codigo, String descripcion,int aforo, LocalDate fecha, NodoSala salaAsignada);
    public void agregarOrd(String codigo, String descripcion,int aforo, LocalDate fecha, NodoSala salaAsignada);
    public void borrarInicio();
    public void borrarFin();
    public void borrarElemento(String codigo);
    public boolean buscarelemento(String codigo);
    public NodoEvento obtenerElemento(String codigo);
    public void vaciar();
    public void mostrar();
    public int cantElementos();
    public void mostrarREC();   // mostrar recursivo    
}
