package Listas;

import java.time.LocalDate;
import Interfaces.IListaEvento;
import Nodos.NodoEvento;
import Nodos.NodoSala;

public class ListaEvento implements IListaEvento {
    NodoEvento primero;
    NodoEvento siguiente;

    int cantnodos;

//constructor
    public ListaEvento() {
        this.primero = null;
        this.siguiente = null;
        this.cantnodos = 0;
    }

// set get

    public NodoEvento getPrimero() {
        return primero;
    }

    public void setPrimero(NodoEvento primero) {
        this.primero = primero;
    }

    public NodoEvento getUltimo() {
        return siguiente;
    }

    public void setUltimo(NodoEvento ultimo) {
        this.siguiente = ultimo;

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
    public void agregarInicio(String codigo,String descripcion,int aforo, LocalDate fecha, NodoSala salaAsignada) {
        NodoEvento nuevo = new NodoEvento(codigo,descripcion,aforo,fecha,salaAsignada);

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
    public void agregarFinal(String codigo,String descripcion,int aforo, LocalDate fecha, NodoSala salaAsignada) {
        NodoEvento nuevo = new NodoEvento(codigo,descripcion,aforo,fecha,salaAsignada);
        if (this.esVacia()){
            this.setPrimero(nuevo);
            this.setUltimo(nuevo);            
        }else{
            this.siguiente.setSiguiente(nuevo);
            this.siguiente=nuevo;
        }
        this.cantnodos++;
    }

 @Override
    public void agregarOrd(String codigo,String descripcion,int aforo, LocalDate fecha, NodoSala salaAsignada) {
        NodoEvento nuevo = new NodoEvento(codigo,descripcion,aforo,fecha,salaAsignada);
        if (this.esVacia() || codigo.compareTo(this.getPrimero().getCodigo()) < 0) {
            this.agregarInicio(codigo,descripcion,aforo,fecha,salaAsignada);
        } else {
            if (codigo.compareTo(this.getUltimo().getCodigo()) > 0) {
                this.agregarFinal(codigo,descripcion,aforo,fecha,salaAsignada);
            } else {
                NodoEvento actual = this.getPrimero();
                while (actual.siguiente != null && 
                       codigo.compareTo(actual.siguiente.getCodigo()) > 0) {
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
            System.out.println("No hay eventos existentes");
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
                 NodoEvento aux= this.getPrimero();
                 while (aux.siguiente!=this.getUltimo()){
                     aux=aux.getSiguiente();
                 }
                 aux.setSiguiente(null);
                 this.setUltimo(aux);
                 this.cantnodos--;
            }
     }else{
         System.out.println("No hay eventos existentes");
     }       
    }

    @Override
    public void borrarElemento(String codigo) {

       if (!this.esVacia()) {
            NodoEvento aux = this.getPrimero();
            boolean borrado = false;
            while (aux != null && aux.getSiguiente() != null && !borrado) {
                if (aux.siguiente.getCodigo().compareTo(codigo)==0) {
                    aux.siguiente = aux.siguiente.siguiente;
                    borrado = true;
                }
                aux = aux.siguiente;
                this.cantnodos--;
            }
        } else {
            System.out.println("No hay eventos existentes");
        }     

    }

    @Override
    public boolean buscarelemento(String codigo) {
      NodoEvento aux=this.getPrimero();
        boolean existe=false;
        while (aux!=null && !existe){
            if (aux.getCodigo().compareTo(codigo)==0){
                existe=true;
            }
            aux=aux.siguiente;
        }
        return existe;  

    }
    
    @Override
    public NodoEvento obtenerElemento(String codigo) {
      NodoEvento aux = this.getPrimero();
        NodoEvento existe=null;
        while (aux!=null && existe==null){
            if (aux.getCodigo().compareTo(codigo)==0){
                existe=aux;
            }
            aux=aux.siguiente;
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
        NodoEvento aux= this.getPrimero();
        while(aux!=null){
            System.out.println(aux.getCodigo()+" - "+aux.getDescripcion()+" - "+aux.getSalaAsignada().getNombre()+" - "
                    +(aux.getAforo() - aux.getLentrada().cantnodos)+" - "
                    +aux.getLentrada().cantnodos);
            aux=aux.siguiente;
        }
        System.out.println();
    }

    @Override
    public int cantElementos() {
        return this.cantnodos;
    }

    @Override
    public void mostrarREC() {
        System.out.println("mostrar Ascendente");
        System.out.println(mostrarRecAsc(this.getPrimero(),this.getUltimo()));
  
        System.out.println();
        
        System.out.println("mostrar Descendente");
        System.out.println(mostrarRecDsc(this.getPrimero(),this.getUltimo()));  
        
          System.out.println();      
    }
    
    public String mostrarRecAsc(NodoEvento primero,NodoEvento siguiente){
        if (this.esVacia()){
            return " ";
        }
        if (primero==siguiente){
            return  siguiente.getCodigo()+" - "+ siguiente.getDescripcion();
        }else{
        
            return primero.getCodigo()+" "+ primero.getDescripcion()+ " - "+mostrarRecAsc(primero.getSiguiente(),siguiente);
        }
        
    
    }
 
   public String mostrarRecDsc(NodoEvento primero,NodoEvento siguiente){
        if (this.esVacia()){
            return " ";
        }
        if (primero==siguiente){
            return  siguiente.getCodigo()+" - "+ siguiente.getDescripcion();
        }else{
        
            return mostrarRecDsc(primero.getSiguiente(),siguiente)+ primero.getCodigo()+" "+ primero.getDescripcion()+ " - ";
        }
        
    
    }   
}

