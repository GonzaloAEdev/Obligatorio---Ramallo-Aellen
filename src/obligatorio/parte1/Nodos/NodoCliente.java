package obligatorio.parte1.Nodos;

public class NodoCliente {
    String cedula;
    String nombre;
    public NodoCliente siguiente; // esta puublico para que ande 
           
// constructor
    
    public NodoCliente(String cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.siguiente = null;
        
    }

// set y get
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public NodoCliente getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCliente siguiente) {
        this.siguiente = siguiente;
    }

    // Implementación de Comparable para ordenamiento
    
    public int compareTo(NodoCliente otro) {
        return this.cedula.compareTo(otro.cedula);
    }

    // Sobrescritura de equals para comparación por cédula
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        NodoCliente that = (NodoCliente) obj;
        return cedula.equals(that.cedula);
    }
    
    // Sobrescritura de hashCode consistente con equals
    @Override
    public int hashCode() {
        return cedula.hashCode();
    }
}