/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COLAS;

/**
 *
 * @author itic
 */
public class CSNormal extends CSimple {

    public CSNormal(int cap) {
        super(cap);

    }

    @Override
    public boolean esVacio() {
        if ((ini == 0) && (fin == 0)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean esLleno() {
        if (fin == max) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void adicionar(Object ele) {
        if (!esLleno()) {
            if (esVacio()) {
                ini = 1;
                fin++;
                V[fin] = ele;
            } else {
                fin++;
                V[fin] = ele;
            }
        }
    }

    @Override
    public Object eliminar() {
        Object da = null;
        if (this.esVacio()) {
            System.out.println("Pila Vacia");
        } else {
            da = V[ini];
            ini++;

            if (ini > fin) {
                ini = 0;
                fin = 0;

            }
        }
        return da;
    }

    @Override
    public void mostrar() {
        CSNormal aux = new CSNormal(max);

        while (!esVacio()) {
            Object da = eliminar();
            System.out.print(" " + da);
            aux.adicionar(da);
        }
        System.out.println("");
        while (!aux.esVacio()) {
            adicionar(aux.eliminar());
        }
    }

    @Override
    public int nElem() {
        if (!esVacio()) {
            return (fin - ini + 1);
        } else {
            return 0;
        }
    }

    @Override
    public void vaciar(CSimple b) {
        while (!esVacio()) {
            b.adicionar(eliminar());
        }
    }

    @Override
    public void vaciar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
