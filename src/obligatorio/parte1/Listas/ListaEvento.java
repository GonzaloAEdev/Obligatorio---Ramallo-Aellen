package obligatorio.parte1.Listas;

import obligatorio.parte1.Interfaces.IListaEvento;
import obligatorio.parte1.Nodos.NodoEvento;

public class ListaEvento implements IListaEvento {
    NodoEvento primero;
    NodoEvento ultimo;
    int cantnodos;

//constructor
    public ListaEvento() {
        this.primero = null;
        this.ultimo = null;
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
        return ultimo;
    }

    public void setUltimo(NodoEvento ultimo) {
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
    public void agregarInicio(int nro, String nombre,int aforo) {
        NodoEvento nuevo = new NodoEvento(nro,nombre,aforo);
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
    public void agregarFinal(int nro, String nombre,int aforo) {
        NodoEvento nuevo = new NodoEvento(nro,nombre,aforo);
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
    public void agregarOrd(int nro, String nombre,int aforo) {
       NodoEvento nuevo = new NodoEvento(nro,nombre,aforo);
       if (this.esVacia() || nro < this.getPrimero().getNro()){
           this.agregarInicio(nro, nombre,aforo);
       }else{
           if (nro > this.getUltimo().getNro()){
               this.agregarFinal(nro, nombre,aforo);
           }else{
               NodoEvento actual = this.getPrimero();
               while (actual.siguiente!=null && nro> actual.siguiente.nro){
                   actual=actual.siguiente;
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
            System.out.println("no hay elementos en la lista");
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
         System.out.println("no hay elementos en la lista");
     }       
    }

    @Override
    public void borrarElemento(int nro, String nombre) {
       if (!this.esVacia()) {
            NodoEvento aux = this.getPrimero();
            boolean borrado = false;
            while (aux != null && aux.getSiguiente() != null && !borrado) {
                if (aux.siguiente.getNro() == nro && aux.siguiente.getNombre().compareTo(nombre)==0) {
                    aux.siguiente = aux.siguiente.siguiente;
                    borrado = true;
                }
                aux = aux.siguiente;
                this.cantnodos--;
            }
        } else {
            System.out.println("lista vacia, no hay elementos para borrar");
        }     

    }

    @Override
    public boolean buscarelemento(int nro, String nombre) {
      NodoEvento aux=this.getPrimero();
        boolean existe=false;
        while (aux!=null && !existe){
            if (aux.getNro()==nro && aux.getNombre().compareTo(nombre)==0){
                existe=true;
            }
            aux=aux.siguiente;
        }
        return existe;  

    }
    /*
    public boolean buscarelementoPorNro(int nro, String nombre) {
        NodoEvento aux=this.getPrimero();
        boolean existe=false;
        while (aux!=null && !existe){
            if (aux.getNro()==nro){
                existe=true;
            }
            aux=aux.siguiente;
        }
        return existe;
    }
    
    public boolean buscarelementoPorNom(int nro, String nombre) {
        NodoEvento aux=this.getPrimero();
        boolean existe=false;
        while (aux!=null && !existe){
            if (aux.getNombre().compareTo(nombre)==0){
                existe=true;
            }
            aux=aux.siguiente;
        }
        return existe;    }     
*/
    @Override
    public NodoEvento obtenerElemento(int nro, String nombre) {
      NodoEvento aux=this.getPrimero();
        NodoEvento existe=null;
        while (aux!=null && existe==null){
            if (aux.getNro()==nro && aux.getNombre().compareTo(nombre)==0){
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
            System.out.println("Nro = "+aux.getNro()+" - Nombre= " +aux.getNombre()+" - Aforo: "+aux.getAforo());
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
    
    public String mostrarRecAsc(NodoEvento primero,NodoEvento ultimo){
        if (this.esVacia()){
            return " ";
        }
        if (primero==ultimo){
            return  ultimo.getNro()+" - "+ ultimo.getNombre();
        }else{
        
            return primero.getNro()+" "+ primero.getNombre()+ " - "+mostrarRecAsc(primero.getSiguiente(),ultimo);
        }
        
    
    }
 
   public String mostrarRecDsc(NodoEvento primero,NodoEvento ultimo){
        if (this.esVacia()){
            return " ";
        }
        if (primero==ultimo){
            return  ultimo.getNro()+" - "+ ultimo.getNombre();
        }else{
        
            return mostrarRecDsc(primero.getSiguiente(),ultimo)+ primero.getNro()+" "+ primero.getNombre()+ " - ";
        }
        
    
    }    
    
 
}

