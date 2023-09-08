public class pilaPadres {
    public Estado_Abierto primero;
    public pilaPadres(){
        this.primero=null;
    } 
    public void Apilar(Estado_Abierto ultimo){
        ultimo.siguiente=null;
        Estado_Abierto nuevo = ultimo;
        if (this.primero == null){
            this.primero = nuevo;
        }
        else{
            nuevo.siguiente=this.primero;
            this.primero = nuevo;
        }        
    }
    public void imprimirPila(){
        
       System.out.print("\n"+"Lista de Padres"+"\n ");
       if(primero!=null){
            Estado_Abierto aux=primero;
            while(aux!=null) {
                    System.out.print(aux.estado.nombre+" -> ");
                    aux=aux.siguiente;
            }
       }else{System.out.print("Vacia");}
       System.out.print(" \n ");
    }
    public void LimpiarPila() {
        if(this.primero!=null){this.primero=null;}
    }
}
