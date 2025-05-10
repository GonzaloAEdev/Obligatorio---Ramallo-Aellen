
package obligatorio.parte1.Nodos;

public class NodoEntrada {
    public int nro;
    public String nombre;
    public NodoEntrada siguiente; 
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
