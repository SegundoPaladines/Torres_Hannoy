public class Pila{
    public Nodo primero;

    public Pila(){
        this.primero=null;
    } 
    public void Apilar(Nodo ultimo){
        ultimo.siguiente=null;
        Nodo nuevo = ultimo;
        if (this.primero == null){
            this.primero = nuevo;
        }
        else{
            nuevo.siguiente=this.primero;
            this.primero = nuevo;
        }        
    }
    public Nodo desApilar(){
        Nodo ultimo=null;
        if(this.primero==null){

            System.out.println("No se puede sacar elementos, la pila está vacia");

        }else{
            ultimo=this.primero;
            this.primero=this.primero.siguiente;
        }

        return ultimo;
        
    }
    public void imprimirPila(String torre){
        
       System.out.print("\n"+torre+"\n ");
       if(primero!=null){
            Nodo aux=primero;
            while(aux!=null) {
                    System.out.print(aux.tamano_disco+" -> ");
                    aux=aux.siguiente;
            }
       }else{System.out.print("Vacia");}
       System.out.print(" \n ");
    }
    public void LimpiarPila() {
        if(this.primero!=null){this.primero=null;}
    }
    public boolean esVacia(){
        boolean bandera=true;
        if(primero!=null){
            bandera=false;
        }
        return bandera;
    }
    public static Pila PasarElementos(Pila torre){
        Pila pila = new Pila();
        if(!torre.esVacia()){
            Pila aux= new Pila();
            Nodo tmp=torre.primero;
            while(tmp!=null){
                aux.Apilar(new Nodo(tmp.tamano_disco));
                tmp=tmp.siguiente;
            }
            Nodo tmp2=aux.primero;
            while(tmp2!=null){
                pila.Apilar(new Nodo(tmp2.tamano_disco));
                tmp2=tmp2.siguiente;
            }
        }
        return pila;
    }
    public boolean sonTorresIguales(Pila t1){
        boolean bandera = false;
        if((t1.primero==null)&&(this.primero==null)){
            bandera= true;
        }else{
                String cadena1="";
                if(this.primero!=null){
                    Nodo aux=this.primero;
                    while(aux!=null) {
                        cadena1=cadena1+aux.tamano_disco;
                        aux=aux.siguiente;
                    }
               }else{cadena1="Vacia";}

               String cadena2="";
                if(t1.primero!=null){
                    Nodo aux=t1.primero;
                    while(aux!=null) {
                        cadena2=cadena2+aux.tamano_disco;
                        aux=aux.siguiente;
                    }
               }else{cadena2="Vacia";}

               if(cadena1.equals(cadena2)){
                bandera =true;
               }
        }

        return bandera;
    }
}