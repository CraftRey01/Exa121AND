package COLAS;
public class CSNMulti {
    private int nCSN = 0;
    private int max = 0;
    private CSNormal[] CCN = new CSNormal[100];
    
    public CSNMulti(int c){
        this.max = c;
    }
    
    public boolean esvacia(int i){
        return CCN[i].esvacia();
    }
    
    public boolean esllena(int i){
        return CCN[i].esLleno();
    }
   
    public int nColas(){
        return this.nCSN;
    }

    public void adicionar(int i,Object n){
        CCN[i].adicionar(n);
    }
    
    public Object eliminar(int i){
        return CCN[i].eliminar();
    }
    
    public void mostrar(int i){
        System.out.println("-- mostrando cola "+i+" --");
        CCN[i].mostrar();
    }
    
    public void mostrar(){
        if(this.nElem()== 0){ System.out.println("no es posible mostrar, la multicola esta vacia");
        }else{
            for(int i = 1 ; i<= nCSN ; i++){
                this.mostrar(i);
            }
            System.out.println("---------------------");
        }
    }
    
    public int nElem(int i){
        return CCN[i].nElem();
    }
    
    public int nElem(){
        int c = 0;
        for(int i=1 ;i<=nCSN ; i++){
            c += this.nElem(i);
        }
        return c;
    }
    
    public void crearCSN(int i, int m){
        CCN[i] = new CSNormal(m);
        nCSN++;
    }

    public boolean buscar(int i, Object ele){
        return CCN[i].buscar(ele);
    }
    
    public int getMax(int i){
        return CCN[i].getMax();
    }

    public int getMax(){
        return this.max;
    }
}