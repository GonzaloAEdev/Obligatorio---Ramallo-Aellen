package obligatorio.parte1.Nodos;

import obligatorio.parte1.Listas.ListaEvento;

public class NodoSala {
    int nro;
    String nombre;
    NodoSala siguiente; 
    int capacidad;
    ListaEvento levento;
    
// constructor
    
    public NodoSala(int nro, String nombre,int capacidad) {
        this.nro = nro;
        this.nombre = nombre;
        this.capacidad=capacidad;
        this.siguiente = null;
        this.levento=new ListaEvento();
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

    public NodoSala getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoSala siguiente) {
        this.siguiente = siguiente;
    }

    public ListaEvento getLevento() {
        return levento;
    }

    public void setLevento(ListaEvento levento) {
        this.levento = levento;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    
}
