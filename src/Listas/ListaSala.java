
package Listas;

import java.time.LocalDate;
import Interfaces.IListaSala;
import Nodos.NodoEvento;
import Nodos.NodoSala;


public class ListaSala implements IListaSala {
    NodoSala primero;
    NodoSala ultimo;
    int cantnodos;

//constructor
    public ListaSala() {
        this.primero = null;
        this.ultimo = null;
        this.cantnodos = 0;
     
    }

// set get

    public NodoSala getPrimero() {
        return primero;
    }

    public void setPrimero(NodoSala primero) {
        this.primero = primero;
    }

    public NodoSala getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoSala ultimo) {
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
    public void agregarInicio(String nombre,int capacidad) {
        NodoSala nuevo = new NodoSala(nombre,capacidad);
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
    public void agregarFinal(String nombre, int capacidad) {
        NodoSala nuevo = new NodoSala(nombre,capacidad);
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
    public void agregarOrd(String nombre, int capacidad) {
        NodoSala nuevo = new NodoSala(nombre, capacidad);
        if (this.esVacia() || nombre.compareTo(this.getPrimero().getNombre()) < 0) {
            this.agregarInicio(nombre, capacidad);
        } else {
            if (nombre.compareTo(this.getUltimo().getNombre()) > 0) {
                this.agregarFinal(nombre, capacidad);
            } else {
                NodoSala actual = this.getPrimero();
                while (actual.siguiente != null && 
                       nombre.compareTo(actual.siguiente.getNombre()) > 0) {
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
            System.out.println("Lista vacia, no hay salas para borrar");

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
                 NodoSala aux= this.getPrimero();
                 while (aux.siguiente!=this.getUltimo()){
                     aux=aux.getSiguiente();
                 }
                 aux.setSiguiente(null);
                 this.setUltimo(aux);
                 this.cantnodos--;
            }
     }else{
         System.out.println("Lista vacia, no hay salas para borrar");

     }       
    }

    @Override
    public void borrarElemento(String nombre) {
       if (!this.esVacia()) {
            NodoSala aux = this.getPrimero();
            boolean borrado = false;
            while (aux != null && aux.getSiguiente() != null && !borrado) {
                if (aux.siguiente.getNombre().compareTo(nombre)==0) {
                    aux.siguiente = aux.siguiente.siguiente;
                    borrado = true;
                }
                aux = aux.siguiente;
                this.cantnodos--;
            }
        } else {
            System.out.println("Lista vacia, no hay salas para borrar");

        }     

    }

    @Override
    public boolean buscarelemento(String nombre) {
      NodoSala aux=this.getPrimero();
        boolean existe=false;
        while (aux!=null && !existe){
            if (aux.getNombre().compareTo(nombre)==0){

                existe=true;
            }
            aux=aux.siguiente;
        }
        return existe;  

    }

    public boolean buscarelementoPorNom(String nombre) {

        NodoSala aux=this.getPrimero();
        boolean existe=false;
        while (aux!=null && !existe){
            if (aux.getNombre().compareTo(nombre)==0){
                existe=true;
            }
            aux=aux.siguiente;
        }
        return existe;    }     

    @Override
    public NodoSala obtenerElemento(String nombre) {
      NodoSala aux=this.getPrimero();
        NodoSala existe=null;
        while (aux!=null && existe==null){
            if (aux.getNombre().compareTo(nombre)==0){
                existe=aux;
            }
            aux=aux.siguiente;
        }
        return existe;  
    }
    
    public NodoSala obtenerElementoSegunAforo(int aforo){
     NodoSala aux=this.getPrimero();
        NodoSala ns=null;
        while (aux!=null && ns==null){
            if (aux.capacidad >=aforo){
                ns=aux;
            }
            aux=aux.siguiente;
        }
        return ns; 
        
    }

    @Override
    public void vaciar() {
               this.setPrimero(null);
                this.setUltimo(null);
                this.cantnodos=0;               
    }

    @Override
    public void mostrar() {
        NodoSala aux= this.getPrimero();
        while(aux!=null){
            System.out.println("Nombre = "+aux.getNombre()+" - Capacidad= " +aux.getCapacidad());

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
    
    public String mostrarRecAsc(NodoSala primero,NodoSala ultimo){
        if (this.esVacia()){
            return " ";
        }
        if (primero==ultimo){
            return  ultimo.getNombre()+" - "+ ultimo.getCapacidad();
        }else{
        
            return primero.getNombre()+" "+ primero.getCapacidad()+ " - "+mostrarRecAsc(primero.getSiguiente(),ultimo);
        }
        
    
    }
 
   public String mostrarRecDsc(NodoSala primero,NodoSala ultimo){
        if (this.esVacia()){
            return " ";
        }
        if (primero==ultimo){
            return  ultimo.getNombre()+" - "+ ultimo.getCapacidad();
        }else{
        
            return mostrarRecDsc(primero.getSiguiente(),ultimo)+ primero.getNombre()+" "+ primero.getCapacidad()+ " - ";
        }
        
    
    }    
   // Método auxiliar para encontrar sala disponible
    public NodoSala encontrarSalaDisponible(int aforoNecesario, LocalDate fecha,String codigo) {
        NodoSala actual = this.getPrimero();
        NodoSala mejorSala = null;
    
         while (actual != null) {
        // Verificar si la sala cumple con el aforo y no tiene eventos en esa fecha
            if (actual.getCapacidad() >= aforoNecesario && 
                !tieneEventoEnFecha(actual, fecha,codigo)) {
            
            // Seleccionar la sala con capacidad más ajustada al aforo necesario
                if (mejorSala == null || 
                actual.getCapacidad() < mejorSala.getCapacidad()) {
                mejorSala = actual;
                }
            }
            actual = actual.getSiguiente();
        }
    
        return mejorSala;
    }

// Método auxiliar para verificar si una sala tiene eventos en una fecha específica
    private boolean tieneEventoEnFecha(NodoSala sala, LocalDate fecha,String codigo) {
        NodoEvento eventoActual = sala.getLevento().obtenerElemento(codigo);
        while (eventoActual != null) {
            if (eventoActual.getFecha() == fecha) {
                return true;
            }
            eventoActual = eventoActual.getSiguiente();
        }
        return false;
    }
}
