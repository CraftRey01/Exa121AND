package PILAS;
import java.lang.reflect.Field;

public class Pila {

    private int tope, max;
    Object v[] = new Object[100];

    public Pila(int cap) {
        max = cap;
        tope = 0;
    }

    public boolean esVacio() {
        if (tope == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean esLleno() {
        if (tope == max) {
            return true;
        } else {
            return false;
        }
    }

    public void addcionar(Object item) {
        if (esLleno()) {
            System.err.println("Pila llena");
        } else {
            tope++;
            v[tope] = item;
        }
    }

    public Object eliminar() {
        Object dato = null;//VE es el valor predeterminado para null
        if (esVacio()) {
            System.out.println("Pilla Vacia");
        } else {
            dato = v[tope];
            tope--;

        }
        return dato;
    }

    public int nElem() {
        return tope;
    }

    public void mostrar() {
        Pila aux = new Pila(max);
        if (!esVacio()) {
            while (!esVacio()) {
                aux.addcionar(eliminar());
            }
            while (!aux.esVacio()) {
                Object da = aux.eliminar();
                System.out.println("" + da);
                addcionar(da);
            }
        } else {
            System.out.println("Pila Vacia");
        }
    }

    public void vaciar(Pila B) {
        while (!B.esVacio()) {
            addcionar(B.eliminar());
        }
    }

    public void vaciar() {
        while (!esVacio()) {
            eliminar();
        }
    }

    public boolean buscar(Object x) {
        Pila aux = new Pila(max);
        boolean esta_en_aux = false;
        while (!this.esVacio()) {
            Object var = this.eliminar();
            if (var.equals(x)) {
                esta_en_aux = true;
            }
            aux.addcionar(var);
        }
        aux.vaciar(this);
        return esta_en_aux;

    }
    public int getMax(){
		return this.max;
	}

    public void ordenar() {
        if (esVacio() || nElem() == 1) {
            return; // La pila está vacía o tiene solo un elemento, no es necesario ordenar
        }
    
        Pila pilaOrdenada = new Pila(max);
    
        while (!esVacio()) {
            Object elemento = eliminar();
    
            // Inserta el elemento en la pila ordenada en su posición correcta
            while (!pilaOrdenada.esVacio() && ((Comparable)elemento).compareTo(pilaOrdenada.v[pilaOrdenada.tope]) > 0) {
                addcionar(pilaOrdenada.eliminar());
            }
            
            pilaOrdenada.addcionar(elemento);
        }
    
        // Copia los elementos ordenados de la pila ordenada a la pila original
        while (!pilaOrdenada.esVacio()) {
            addcionar(pilaOrdenada.eliminar());
        }
    }
    public void ordenar(String atributo) {
        if (esVacio() || nElem() == 1) {
            System.out.println("No es nesesario ordenar la");
        }
    
        Object[] elementos = new Object[nElem() + 1];
        int index = 1;
    
        while (!esVacio()) {
            elementos[index++] = eliminar();
        }    
        
        for (int i = 1; i < elementos.length - 1; i++) {
            for (int j = i + 1; j < elementos.length; j++) {
                Object elementoI = elementos[i];
                Object elementoJ = elementos[j];
    
                try {                   
                    Field field = elementoI.getClass().getDeclaredField(atributo); // con esto se hace refleccion al objeto para accesar alos meetodos del mismo
                    field.setAccessible(true);
                    Comparable comparableI = (Comparable) field.get(elementoI);
                    Comparable comparableJ = (Comparable) field.get(elementoJ);
    
                    if (comparableJ.compareTo(comparableI) < 0) {
                        Object temp = elementos[i];
                        elementos[i] = elementos[j];
                        elementos[j] = temp;
                    }
                } catch (NoSuchFieldException | IllegalAccessException e) {                   
                    e.printStackTrace(); //para que no se rompa feo :v
                }
            }
        }    
      
        for (int i = 1; i < elementos.length; i++) {
            addcionar(elementos[i]);
        }
    }
    
}
