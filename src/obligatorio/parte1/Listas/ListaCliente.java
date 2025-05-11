package obligatorio.parte1.Listas;

import obligatorio.parte1.Interfaces.IListaCliente;
import obligatorio.parte1.Nodos.NodoCliente;

public class ListaCliente implements IListaCliente {
    NodoCliente primero;
    NodoCliente ultimo;
    int cantnodos;

//constructor
    public ListaCliente() {
        this.primero = null;
        this.ultimo = null;
        this.cantnodos = 0;
     
    }

// set get

    public NodoCliente getPrimero() {
        return primero;
    }

    public void setPrimero(NodoCliente primero) {
        this.primero = primero;
    }

    public NodoCliente getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoCliente ultimo) {
        this.ultimo = ultimo;
    }

    public int getCantnodos() {
        return cantnodos;
    }

    public void setCantnodos(int cantnodos) {
        this.cantnodos = cantnodos;
    }
    
    
// metodos abstractos    
    @Override
    public boolean esVacia() {
        return this.cantnodos==0;
       }

    @Override

    public void agregarInicio(String cedula,String nombre) {
        NodoCliente nuevo = new NodoCliente(cedula,nombre);
        if (this.esVacia()){
            this.setPrimero(nuevo);
            this.setUltimo(nuevo);
        }else{
            nuevo.setSiguiente(this.getPrimero());
            this.setPrimero(nuevo);
        }
        this.cantnodos++;
    }

    @Override

    public void agregarFinal(String cedula,String nombre) {
        NodoCliente nuevo = new NodoCliente(cedula,nombre);
        if (this.esVacia()){
            this.setPrimero(nuevo);
            this.setUltimo(nuevo);            
        }else{
            this.ultimo.setSiguiente(nuevo);
            this.ultimo=nuevo;
        }
        this.cantnodos++;
    }

    @Override
    public void agregarOrd(String cedula,String nombre) {
       NodoCliente nuevo = new NodoCliente(cedula, nombre);
    if (this.esVacia() || nuevo.compareTo(this.getPrimero()) < 0) {
        this.agregarInicio(cedula, nombre);
    } else {
        if (nuevo.compareTo(this.getUltimo()) > 0) {
            this.agregarFinal(cedula, nombre);
        } else {
            NodoCliente actual = this.getPrimero();
            while (actual.siguiente != null && 
                   nuevo.compareTo(actual.siguiente) > 0) {
                actual = actual.siguiente;
            }
            nuevo.setSiguiente(actual.getSiguiente());
            actual.setSiguiente(nuevo);
            this.cantnodos++;
        }
    }
    }

    @Override
    public void borrarInicio() {
        if (!this.esVacia()){
            if (this.cantnodos==1){
                this.setPrimero(null);
                this.setUltimo(null);
                this.cantnodos=0;            
            }else{
                this.setPrimero(this.primero.getSiguiente());
                this.cantnodos--;
            }
                        
        }else{
            System.out.println("No hay Clientes en la Lista");
        }

    }

    @Override
    public void borrarFin() {
     if (!this.esVacia()){
            if (this.cantnodos==1){
                this.setPrimero(null);
                this.setUltimo(null);
                this.cantnodos=0;                        
            }else{

                 NodoCliente aux= this.getPrimero();
                 while (aux.siguiente!=this.getUltimo()){
                     aux=aux.getSiguiente();
                 }
                 aux.setSiguiente(null);
                 this.setUltimo(aux);
                 this.cantnodos--;
            }
     }else{
         System.out.println("No hay Clientes en la Lista");
     }       
    }

    @Override
    public void borrarElemento(String cedula, String nombre) {
       if (!this.esVacia()) {
            NodoCliente aux = this.getPrimero();
            boolean borrado = false;
            while (aux != null && aux.getSiguiente() != null && !borrado) {
                if (aux.siguiente.getCedula().equals(cedula) && 
                    aux.siguiente.getNombre().compareTo(nombre) == 0) {
                    aux.siguiente = aux.siguiente.siguiente;
                    borrado = true;
                    this.cantnodos--;
                }
                aux = aux.siguiente;
            }
        } else {
            System.out.println("lista vacia, no hay elementos para borrar");
        }    
    }

    @Override
    public boolean buscarelemento(String cedula, String nombre) {
    NodoCliente aux = this.getPrimero();
    NodoCliente buscado = new NodoCliente(cedula, nombre);
    while (aux != null) {
        if (aux.equals(buscado) && aux.getNombre().equals(nombre)) {
            return true;
        }
        aux = aux.siguiente;
    }
    return false;
}
 
    public boolean buscarelementoPorNom(int nro, String nombre) {
        NodoCliente aux=this.getPrimero();
        boolean existe=false;
        while (aux!=null && !existe){
            if (aux.getNombre().compareTo(nombre)==0){
                existe=true;
            }
            aux=aux.siguiente;
        }
        return existe;    
    }     
    

    @Override
    public NodoCliente obtenerElemento(String cedula, String nombre) {
        NodoCliente aux = this.getPrimero();
        NodoCliente existe = null;
        while (aux != null && existe == null) {
            if (aux.getCedula().equals(cedula) && 
                aux.getNombre().compareTo(nombre) == 0) {
                existe = aux;
            }
            aux = aux.siguiente;
        }
        return existe;  
    }
         
    @Override
    public void vaciar() {
               this.setPrimero(null);
                this.setUltimo(null);
                this.cantnodos=0;               
    }

    @Override
    public void mostrar() {
        NodoCliente aux = this.getPrimero();
        while(aux != null) {
            System.out.println("Cédula = " + aux.getCedula() + " - Nombre = " + aux.getNombre());
            aux = aux.siguiente;
        }
        System.out.println();
    }

    @Override
    public int cantElementos() {
        return this.cantnodos;
    }

    @Override
    public void mostrarREC() {
        System.out.println("Mostrar Ascendente");
        System.out.println(mostrarRecAsc(this.getPrimero(), this.getUltimo()));
  
        System.out.println();
        
        System.out.println("Mostrar Descendente");
        System.out.println(mostrarRecDsc(this.getPrimero(), this.getUltimo()));  
        
        System.out.println();      
    }
    
    public String mostrarRecAsc(NodoCliente primero, NodoCliente ultimo) {
        if (this.esVacia()) {
            return " ";
        }
        if (primero == ultimo) {
            return ultimo.getCedula() + " - " + ultimo.getNombre();
        } else {
            return primero.getCedula() + " " + primero.getNombre() + " - " + 
                   mostrarRecAsc(primero.getSiguiente(), ultimo);
        }
    }
 
    public String mostrarRecDsc(NodoCliente primero, NodoCliente ultimo) {
        if (this.esVacia()) {
            return " ";
        }
        if (primero == ultimo) {
            return ultimo.getCedula() + " - " + ultimo.getNombre();
        } else {
            return mostrarRecDsc(primero.getSiguiente(), ultimo) + 
                   primero.getCedula() + " " + primero.getNombre() + " - ";
        }
    }    
}
