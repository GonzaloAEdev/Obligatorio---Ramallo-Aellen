// Este Interfaces es por el momento para que los eventos tengan una Lista de Entradas
package Interfaces;

import Nodos.NodoEntrada;

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
