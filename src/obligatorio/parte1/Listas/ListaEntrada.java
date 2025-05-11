// Este Lista es por el momento para que los Eventos tengan una Lista de Entradas
package obligatorio.parte1.Listas;

import obligatorio.parte1.Interfaces.IListaEntrada;
import obligatorio.parte1.Nodos.NodoEntrada;

public class ListaEntrada implements IListaEntrada {

    NodoEntrada primero;
    NodoEntrada ultimo;
    int cantnodos;
    int cantnodospermitido;

//constructor
    public ListaEntrada(int cantnodospermitido) {
        this.primero = null;
        this.ultimo = null;
        this.cantnodos = 0;
        this.cantnodospermitido = cantnodospermitido;

    }

// set get
    public NodoEntrada getPrimero() {
        return primero;
    }

    public void setPrimero(NodoEntrada primero) {
        this.primero = primero;
    }

    public NodoEntrada getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoEntrada ultimo) {
        this.ultimo = ultimo;
    }

    public int getCantnodos() {
        return cantnodos;
    }

    public void setCantnodos(int cantnodos) {
        this.cantnodos = cantnodos;
    }

    public int getCantnodospermitido() {
        return cantnodospermitido;
    }

    public void setCantnodospermitido(int cantnodospermitido) {
        this.cantnodospermitido = cantnodospermitido;
    }

// metodos abstractos    
    @Override
    public boolean esLLena() {
        return this.cantnodos == this.cantnodospermitido;
    }

    @Override
    public boolean esVacia() {
        return this.cantnodos == 0;
    }

    @Override
    public void agregarInicio(int nro, String nombre) {
        if (!this.esLLena()) {
            NodoEntrada nuevo = new NodoEntrada(nro, nombre);
            if (this.esVacia()) {
                this.setPrimero(nuevo);
                this.setUltimo(nuevo);
            } else {
                nuevo.setSiguiente(this.getPrimero());
                this.setPrimero(nuevo);
            }
            this.cantnodos++;
        } else {
            System.out.println("La lista esta llena, no puede agregar el elemento");
        }
    }

    @Override
    public void agregarFinal(int nro, String nombre) {
        if (!this.esLLena()) {
            NodoEntrada nuevo = new NodoEntrada(nro, nombre);
            if (this.esVacia()) {
                this.setPrimero(nuevo);
                this.setUltimo(nuevo);
            } else {
                this.ultimo.setSiguiente(nuevo);
                this.ultimo = nuevo;
            }
            this.cantnodos++;
        } else {
            System.out.println("La lista esta llena, no puede acomprar entrada");
        }
    }

    @Override
    public void agregarOrd(int nro, String nombre) {
        if (!this.esLLena()) {
        NodoEntrada nuevo = new NodoEntrada(nro, nombre);
        if (this.esVacia() || nro < this.getPrimero().getNro()) {
            this.agregarInicio(nro, nombre);
        } else {
            if (nro > this.getUltimo().getNro()) {
                this.agregarFinal(nro, nombre);
            } else {
                NodoEntrada actual = this.getPrimero();
                while (actual.siguiente != null && nro > actual.siguiente.nro) {
                    actual = actual.siguiente;
                }
                nuevo.setSiguiente(actual.getSiguiente());
                actual.setSiguiente(nuevo);
                this.cantnodos++;
            }
        }
        
        }else{
            System.out.println("La lista esta llena, no se puede comprar entrada " + nro + " - "+nombre);        
        }
    }

    @Override
    public void borrarInicio() {
        if (!this.esVacia()) {
            if (this.cantnodos == 1) {
                this.setPrimero(null);
                this.setUltimo(null);
                this.cantnodos = 0;
            } else {
                this.setPrimero(this.primero.getSiguiente());
                this.cantnodos--;
            }

        } else {
            System.out.println("No hay elementos en la Lista");
        }

    }

    @Override
    public void borrarFin() {
        if (!this.esVacia()) {
            if (this.cantnodos == 1) {
                this.setPrimero(null);
                this.setUltimo(null);
                this.cantnodos = 0;
            } else {
                NodoEntrada aux = this.getPrimero();
                while (aux.siguiente != this.getUltimo()) {
                    aux = aux.getSiguiente();
                }
                aux.setSiguiente(null);
                this.setUltimo(aux);
                this.cantnodos--;
            }
        } else {
            System.out.println("No hay elementos en la Lista");
        }
    }

    @Override
    public void borrarElemento(int nro, String nombre) {
        if (!this.esVacia()) {
            NodoEntrada aux = this.getPrimero();
            boolean borrado = false;
            while (aux != null && aux.getSiguiente() != null && !borrado) {
                if (aux.siguiente.getNro() == nro && aux.siguiente.getNombre().compareTo(nombre) == 0) {
                    aux.siguiente = aux.siguiente.siguiente;
                    borrado = true;
                }
                aux = aux.siguiente;
                this.cantnodos--;
            }
        } else {
            System.out.println("Lista vacia, no hay entradas para borrar");
        }

    }

    @Override
    public boolean buscarelemento(int nro, String nombre) {
        NodoEntrada aux = this.getPrimero();
        boolean existe = false;
        while (aux != null && !existe) {
            if (aux.getNro() == nro && aux.getNombre().compareTo(nombre) == 0) {
                existe = true;
            }
            aux = aux.siguiente;
        }
        return existe;

    }
/*
    public boolean buscarelementoPorNro(int nro, String nombre) {
        NodoEntrada aux = this.getPrimero();
        boolean existe = false;
        while (aux != null && !existe) {
            if (aux.getNro() == nro) {
                existe = true;
            }
            aux = aux.siguiente;
        }
        return existe;
    }

    public boolean buscarelementoPorNom(int nro, String nombre) {
        NodoEntrada aux = this.getPrimero();
        boolean existe = false;
        while (aux != null && !existe) {
            if (aux.getNombre().compareTo(nombre) == 0) {
                existe = true;
            }
            aux = aux.siguiente;
        }
        return existe;
    }
*/
    @Override
    public NodoEntrada obtenerElemento(int nro, String nombre) {
        NodoEntrada aux = this.getPrimero();
        NodoEntrada existe = null;
        while (aux != null && existe == null) {
            if (aux.getNro() == nro && aux.getNombre().compareTo(nombre) == 0) {
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
        this.cantnodos = 0;
    }

    @Override
    public void mostrar() {
        NodoEntrada aux = this.getPrimero();
        while (aux != null) {
            System.out.println("Nro = " + aux.getNro() + " - Nombre= " + aux.getNombre());
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
        System.out.println("mostrar Ascendente");
        System.out.println(mostrarRecAsc(this.getPrimero(), this.getUltimo()));

        System.out.println();

        System.out.println("mostrar Descendente");
        System.out.println(mostrarRecDsc(this.getPrimero(), this.getUltimo()));

        System.out.println();
    }

    public String mostrarRecAsc(NodoEntrada primero, NodoEntrada ultimo) {
        if (this.esVacia()) {
            return " ";
        }
        if (primero == ultimo) {
            return ultimo.getNro() + " - " + ultimo.getNombre();
        } else {

            return primero.getNro() + " " + primero.getNombre() + " - " + mostrarRecAsc(primero.getSiguiente(), ultimo);
        }

    }

    public String mostrarRecDsc(NodoEntrada primero, NodoEntrada ultimo) {
        if (this.esVacia()) {
            return " ";
        }
        if (primero == ultimo) {
            return ultimo.getNro() + " - " + ultimo.getNombre();
        } else {

            return mostrarRecDsc(primero.getSiguiente(), ultimo) + primero.getNro() + " " + primero.getNombre() + " - ";
        }

    }

}
