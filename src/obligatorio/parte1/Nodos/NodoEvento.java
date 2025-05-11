package obligatorio.parte1.Nodos;

import obligatorio.parte1.Listas.ListaEntrada;

public class NodoEvento {
    int nro;
    String nombre;
    int aforo;
    public NodoEvento siguiente;
    ListaEntrada lentrada;
    
// constructor
    public NodoEvento(int nro, String nombre,int aforo) {
        this.nro = nro;
        this.nombre = nombre;
        this.aforo=aforo;
        this.siguiente = null;
        this.lentrada=new ListaEntrada(aforo);
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

    public NodoEvento getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoEvento siguiente) {
        this.siguiente = siguiente;
    }

    public int getAforo() {
        return aforo;
    }

    public void setAforo(int aforo) {
        this.aforo = aforo;
    }

    public ListaEntrada getLentrada() {
        return lentrada;
    }

    public void setLentrada(ListaEntrada lentrada) {
        this.lentrada = lentrada;
    }

}
