/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COLAS;

/**
 *
 * @author AREA_PROGRAMACION
 */
public class CSCircular extends CSimple{

    public CSCircular(int cap) {
        super(cap);
    }

    @Override
    public boolean esVacio() {
        if (nElem()==0) {
            return true;
        }else{
            return false;
        }
    }    @Override


    public boolean esLleno() {
        if (nElem()==max-1) {
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void adicionar(Object ele) {
        if (!esLleno()) {
            fin=(fin+1)%max;
            V[fin]=ele;
        } else {
            System.out.println("Cola LLena");
        }
    }

    @Override
    public Object eliminar() {
        Object ele=null;
        if (!esVacio()) {
            ini=(ini+1 %max);
            ele=V[ini];
        } else {
            System.out.println("Cola Vacia");
        }
        return ele;
    }

    @Override
    public void mostrar() {
        if (!esVacio()) {
            int n=nElem();
            for (int i = 1; i <=n; i++) {
                Object da =eliminar();
                adicionar(da);
                System.out.print(" "+da);
            }
        } else {
            System.out.println("Cola Vacia");
        }
    }

    @Override
    public int nElem() {
        return ((fin-ini+max)%max);
    }

    @Override
    void vaciar(CSimple b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void vaciar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
