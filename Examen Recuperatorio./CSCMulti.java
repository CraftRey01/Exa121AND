package COLAS;
public class CSCMulti {
    private int nCSC = 0;
    private int max = 0;
    private CSCircular[] CCC = new CSCircular[100];
    
    public CSCMulti(int c){
        this.max = c;
    }
    
    public boolean esvacia(int i){
        return CCC[i].esvacia();
    }
    
    public boolean esllena(int i){
        return CCC[i].esLleno();
    }

    public int nColas(){
        return this.nCSC;
    }
    
    public void adicionar(int i,Object n){
        
        CCC[i].adicionar(n);
    }
    
    public Object eliminar(int i){
        return CCC[i].eliminar();
    }
    
    public void mostrar(int i){
        System.out.println("-- mostrando cola "+i+" --");
        CCC[i].mostrar();
    }
    
    public void mostrar(){
        if(this.nElem()== 0){ System.out.println("no es posible mostrar, la multicola esta vacia");
        }else{
            for(int i = 1 ; i<= nCSC ; i++){
                this.mostrar(i);
            }
            System.out.println("---------------------");
        }
    }
    
    public int nElem(int i){
        return CCC[i].nElem();
    }
    
    public int nElem(){
        int c = 0;
        for(int i=1 ;i<=nCSC ; i++){
            c = c+this.nElem(i);
        }
        return c;
    }
    
    public void crearCSN(int i, int m){
        CCC[i] = new CSCircular(m);
        nCSC++;
    }

    public boolean buscar(int i, Object ele){
        return CCC[i].buscar(ele);
    }

    public int getMax(int i){
        return CCC[i].getMax();
    }

    public int getMax(){
        return this.max;
    }

    public void vaciarCSCMulti() {
        for (int i = 0; i < CCC.length; i++) {
            CCC[i] = null;
        }
        nCSC = 0;
    }
    
}
