package obligatorio.parte1.Interfaces;

import obligatorio.parte1.Nodos.NodoEvento;

public interface IListaEvento {
    public boolean esVacia();
    public void agregarInicio(String codigo, String descripcion,int aforo);
    public void agregarFinal(String codigo, String descripcion,int aforo);
    public void agregarOrd(String codigo, String descripcion,int aforo);
    public void borrarInicio();
    public void borrarFin();
    public void borrarElemento(String codigo, String nombre);
    public boolean buscarelemento(String codigo, String nombre);
    public NodoEvento obtenerElemento(String codigo, String nombre);
    public void vaciar();
    public void mostrar();
    public int cantElementos();
    public void mostrarREC();   // mostrar recursivo    
}
