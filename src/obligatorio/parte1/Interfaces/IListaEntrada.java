package obligatorio.parte1.Interfaces;

import obligatorio.parte1.Nodos.NodoEntrada;

public interface IListaEntrada {
    public boolean esLLena();
    public boolean esVacia();
    public void agregarInicio(int nro, String nombre);
    public void agregarFinal(int nro, String nombre);
    public void agregarOrd(int nro, String nombre);
    public void borrarInicio();
    public void borrarFin();
    public void borrarElemento(int nro, String nombre);
    public boolean buscarelemento(int nro, String nombre);
    public NodoEntrada obtenerElemento(int nro, String nombre);
    public void vaciar();
    public void mostrar();
    public int cantElementos();
    public void mostrarREC();   // mostrar recursivo    
}
