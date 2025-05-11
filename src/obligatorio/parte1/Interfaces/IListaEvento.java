package obligatorio.parte1.Interfaces;

import obligatorio.parte1.Nodos.NodoEvento;

public interface IListaEvento {
    public boolean esVacia();
    public void agregarInicio(int nro, String nombre,int aforo);
    public void agregarFinal(int nro, String nombre,int aforo);
    public void agregarOrd(int nro, String nombre,int aforo);
    public void borrarInicio();
    public void borrarFin();
    public void borrarElemento(int nro, String nombre);
    public boolean buscarelemento(int nro, String nombre);
    public NodoEvento obtenerElemento(int nro, String nombre);
    public void vaciar();
    public void mostrar();
    public int cantElementos();
    public void mostrarREC();   // mostrar recursivo    
}
