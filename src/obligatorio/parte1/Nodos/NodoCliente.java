
package obligatorio.parte1.Nodos;

public class NodoCliente {
    public int  nro;
    public String cedula;
    public String nombre;
    public NodoCliente siguiente;
    
    // (ListaEntrada lentrada;) No se si incluir la lista de entradas que tiene comrpadas 
        
// constructor
    public NodoCliente(int  nro, String cedula, String nombre, NodoCliente siguiente) {
        this.nro = nro;
        this.cedula = cedula;
        this.nombre = nombre;
        this.siguiente = siguiente;
        
    }

    

// set y get
    public int getNro() {
        return nro;
    }

    public void setNro(int nro) {
        this.nro = nro;
    }
    
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
        
       
}