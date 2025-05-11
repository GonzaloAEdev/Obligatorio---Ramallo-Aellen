package Nodos;

import java.time.LocalDate;
import Listas.ListaEntrada;

public class NodoEvento {
    public String codigo;
    public String descripcion;
    public int aforo;
    public NodoEvento siguiente;
    public ListaEntrada lentrada;
    public LocalDate fecha;
    public NodoSala salaAsignada;

// constructor
    public NodoEvento(String codigo, String descripcion,int aforo, LocalDate fecha, NodoSala salaAsignada) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.aforo= aforo;
        this.fecha= fecha;
        this.siguiente = null;
        this.lentrada= new ListaEntrada(aforo);
        this.salaAsignada = salaAsignada;

    }

// set y get

     public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
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
    
    public NodoSala getSalaAsignada() {
        return salaAsignada;
    }

    public void setSalaAsignada(NodoSala salaAsignada) {
        this.salaAsignada = salaAsignada;
    }
    
    // Implementacion de CompareTo
    public int compareTo(NodoEvento otro) {
        return this.codigo.compareTo(otro.codigo);
    }

    // Sobrescritura de equals para comparación por cédula
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        NodoEvento that = (NodoEvento) obj;
        return codigo.equals(that.codigo);
    }

    // Sobrescritura de hashCode consistente con equals
    @Override
    public int hashCode() {
        return codigo.hashCode();
    }

}
