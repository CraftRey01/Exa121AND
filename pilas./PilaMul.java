package PILAS;

import Ejercicios._3_4.Equipo;

/**
 *
 * @author erick_pc
 */
public class PilaMul {

    protected int n_pilas = 0;
    protected int max = 0;
    protected Pila[] V = new Pila[100];

    public PilaMul(int maximo) {//constructor
        max = maximo;
        for (int i = 0; i < V.length; i++) {
            V[i] = new Pila(maximo);
        }
    }

    public boolean esvacia(int pos) {
        return V[pos].esVacio();
    }

    public boolean esllena(int pos) {
        return V[pos].esLleno();
    }

    public int nPilas() {
        return n_pilas;
    }

    public void adicionar(int pos, Object dato) {
        V[pos].addcionar(dato);
    }

    public Object eliminar(int pos) {
        return V[pos].eliminar();
    }

    public void mostrar(int pos) {
        System.out.println("-- mostrando pila " + pos + " --");
        V[pos].mostrar();
    }

    public void mostrar() {
        if (this.nElem() == 0) {
            System.out.println("no es posible mostrar datos, multipila sin elementos");
        } else {
            for (int i = 1; i <= n_pilas; i++) {
                this.mostrar(i);
            }
            System.out.println("---------------------");
        }
    }

    public int nElem(int pos) {
        return V[pos].nElem();
    }

    public int nElem() {
        int cont = 0;
        for (int i = 1; i <= n_pilas; i++) {
            cont += this.nElem(i);
        }
        return cont;
    }

    public void crearPila(int pos, int maximo) {
        V[pos] = new Pila(maximo);
        n_pilas++;
    }

    public boolean buscar(int pos, Object obj) {
        return V[pos].buscar(obj);
    }

    public int getMax(int i) {
        return V[i].getMax();
    }

    public int getMax() {
        return this.max;
    }

    
}
