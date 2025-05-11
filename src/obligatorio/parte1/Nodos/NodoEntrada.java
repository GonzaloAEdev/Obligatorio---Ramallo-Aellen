// Este Nodo es por el momento para que los eventos tengan una Lista de Entradas

package obligatorio.parte1.Nodos;

public class NodoEntrada {
    public int nro; // sin public no anda 
    public String nombre; // sin public no anda 
    public NodoEntrada siguiente;   // sin public no anda 
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
