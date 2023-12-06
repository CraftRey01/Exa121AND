/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PILAS;

/**
 *
 * @author erick_pc
 */
public class PilaMulti {

    int n_pilas = 0, max = 0;
    Pila[] V = new Pila[100];

    public PilaMulti(int maximo) {
        max = maximo;
    }

    public boolean esVacio(int pila_numero) {
        return V[pila_numero].esVacio();
    }

    public boolean esLleno(int pila_numero) {
        return V[pila_numero].esLleno();
    }

    public void adicionar(int pila_numero, Object dato) {
        V[pila_numero].addcionar(dato);
    }

    public Object eliminar(int pila_numero) {
        return V[pila_numero].eliminar();
    }

    public void mostrar(int pila_numero) {
        V[pila_numero].mostrar();
    }

    public void mostrar() {
        for (int i = 0; i < n_pilas; i++) {
            this.mostrar(i);
        }
    }

    public int nElem(int pila_numero) {
        return V[pila_numero].nElem();
    }

    public int nElem() {
        int cont = 0;
        for (int i = 0; i < n_pilas; i++) {
            cont += this.nElem(i);
        }
        return cont;
    }

    public void crearPila(int posicion, int maximo) {
        V[posicion] = new Pila(maximo);
    }

    public boolean buscar(int pila_numero, Object obj) {
        return V[pila_numero].buscar(obj);
    }

}
