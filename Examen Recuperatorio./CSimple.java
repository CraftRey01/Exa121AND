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
public abstract class CSimple {
    protected int ini, fin, max;
    protected Object V[] = new Object[100];

    public CSimple(int cap) {
        max = cap;
        ini = 0;
        fin = 0;
    }

    public abstract boolean esVacio();

    public abstract boolean esLleno();

    public abstract void adicionar(Object ele);

    public abstract Object eliminar();

    public abstract void mostrar();

    public abstract int nElem();

    abstract void vaciar(CSimple b);

    abstract void vaciar();

    public int getMax(){//no tiene la lista
        return this.max;
    }
    public boolean esvacia(){//
        return this.nElem()==0;
    }
    public void vaciar_en(Object P){
        while(!this.esvacia()){
            CSimple x = (CSimple)P;
            x.adicionar(this.eliminar());
        }
    }
    public boolean buscar(Object ele){//
        boolean flag = false;
        CSCircular au = new CSCircular(100);
        while(this.esvacia()){
            Object x = this.eliminar();
            if( x.equals(ele)){  flag = true; }
            au.adicionar(x);
        }
        au.vaciar_en(this);
        return flag;
    }

}
