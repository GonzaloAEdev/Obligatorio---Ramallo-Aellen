
// Este Nodo es por el momento para que los eventos tengan una Lista de Entradas

package Nodos;

public class NodoEntrada { 
    int nro; // sin public no anda 
    String nombre; // sin public no anda 
    NodoEntrada siguiente;   // sin public no anda 
    
// constructor
    public NodoEntrada(int nro, String nombre) {
        this.nro = nro;
        this.nombre = nombre;
        this.siguiente = null;
    }

// set y get

    public int getNro() {
        return nro;
    }

    public void setNro(int nro) {
        this.nro = nro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public NodoEntrada getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoEntrada siguiente) {
        this.siguiente = siguiente;
    }

}
