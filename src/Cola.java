public class Cola {	
     
    public Estado_Abierto pri,ult;    
    
    public Cola () {
        pri  =null;
        ult = null;
    }
    public void insertar(Estado_Abierto nue) {       
        if (pri==null)
        {            
            pri = nue;
            ult = pri;
            //ult.sig = null;
        }
        else
        {
            if(nue.estado.valor_heurisctico>pri.estado.valor_heurisctico){
                nue.siguiente=pri;
                pri=nue;
            }else{
                Estado_Abierto aux=pri;
                Estado_Abierto aux2=aux;
                int validar=0;	        
                while ((aux!=null)&&(validar==0)) {
                    if(aux.estado.valor_heurisctico<nue.estado.valor_heurisctico){
                        nue.siguiente=aux;
                        aux2.siguiente=nue;
                        validar=1;
                    }
                    aux2=aux;
                    aux=aux.siguiente;
                }
                if(validar==0){
                    ult.siguiente=nue;
                    ult=nue;
                }
            }
        }
    }
    public Estado_Abierto extraer()
    {
        Estado_Abierto cerrado= null;
        if (pri!=null)
        {
            cerrado = pri;
            pri = pri.siguiente;         
        }
        return cerrado;  
    }
    public void imprimir() {
        if (pri!=null)
       	{        
	        Estado_Abierto aux=pri;	        
	        System.out.println("\nCola Abiertos:\n");
	        while (aux!=null) {
	            System.out.print(aux.estado.nombre+"(FH: "+aux.estado.valor_heurisctico+") -> ");
	            aux=aux.siguiente;
	        }
            System.out.println();
	    }else{System.out.println("Cola vacia.");}
            
    }
    public void vaciarCola() {
        if (pri!=null)
       	{        
	        Estado_Abierto aux=pri;	        	        
	        while (aux!=null) {
	            System.out.print("Liberado: " + aux.estado.nombre+"\n");
				pri = pri.siguiente;	            
	            aux=null;
	            aux = pri;
	        }	        
	    }    
        System.out.println("Cola vacia.");
    }  
}
    	    	