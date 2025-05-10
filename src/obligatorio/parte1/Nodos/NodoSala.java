
package obligatorio.parte1.Nodos;

import obligatorio.parte1.Listas.ListaEvento;

public class NodoSala {

    public String nombre;
    public NodoSala siguiente; 
    public int capacidad;
    public ListaEvento levento;
    
// constructor
    
    public NodoSala(String nombre,int capacidad) {
        this.nombre = nombre;
        this.capacidad=capacidad;
        this.siguiente = null;
        this.levento=new ListaEvento();
    }

// set y get

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
    // Implementación de Comparable para ordenamiento
    
    public int compareTo(NodoSala otro) {
        return this.nombre.compareTo(otro.nombre);
    }

    // Sobrescritura de equals para comparación por cédula
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        NodoSala that = (NodoSala) obj;
        return nombre.equals(that.nombre);
    }

    // Sobrescritura de hashCode consistente con equals
    @Override
    public int hashCode() {
        return nombre.hashCode();
    }
}
