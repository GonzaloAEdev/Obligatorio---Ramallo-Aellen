package Interfaces;

import Nodos.NodoCliente;

public interface IListaCliente {
    public boolean esVacia();
    public void agregarInicio(String cedula,String nombre);
    public void agregarFinal(String cedula,String nombre);
    public void agregarOrd(String cedula,String nombre);
    public void borrarInicio();
    public void borrarFin();
    public void borrarElemento(String cedula, String nombre);
    public boolean buscarelemento(String cedula, String nombre);
    public NodoCliente obtenerElemento(String cedula, String nombre);
    public void vaciar();
    public void mostrar();
    public int cantElementos();
    public void mostrarREC();   // mostrar recursivo    
}
