package Interfaces;

import Nodos.NodoSala;

public interface IListaSala {
    public boolean esVacia();
    public void agregarInicio(String nombre,int capacidad);
    public void agregarFinal(String nombre,int capacidad);
    public void agregarOrd(String nombre,int capacidad);
    public void borrarInicio();
    public void borrarFin();
    public void borrarElemento(String nombre);
    public boolean buscarelemento(String nombre);
    public NodoSala obtenerElemento(String nombre);
    public void vaciar();
    public void mostrar();
    public int cantElementos();
    public void mostrarREC();   // mostrar recursivo    
}
