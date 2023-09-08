public class Estado {
    public Estado_Abierto padre;
    public String nombre;
    public Pila torre_1;
    public Pila torre_2;
    public Pila torre_3;
    public double valor_heurisctico;
    public int profundidad;

    public Estado(){
        nombre="";
        padre=null;
        torre_1=null;
        torre_2=null;
        torre_3=null;
        valor_heurisctico=0;
        profundidad=0;
    }
    public void Calcular_FH(){
        valor_heurisctico=0;
        int v_torre1=0;
        if(torre_1.primero!=null){
            Nodo tmp=torre_1.primero;
            Nodo tmp1=tmp;
            int i=0;
            while(tmp!=null){
                if(tmp.tamano_disco>tmp1.tamano_disco){
                    v_torre1=v_torre1+1000;
                }
                else{
                    v_torre1=v_torre1+tmp.tamano_disco;
                }
                tmp1=tmp;
                tmp=tmp.siguiente;
                i=i+1;
            }
            v_torre1=i*(v_torre1);
        }else{v_torre1=0;}

        int v_torre2=0;
        if(torre_2.primero!=null){
            Nodo tmp=torre_2.primero;
            Nodo tmp1=tmp;
            int i=0;
            while(tmp!=null){
                if(tmp.tamano_disco>tmp1.tamano_disco){
                    v_torre2=v_torre2-1000;
                }
                else{
                    v_torre2=v_torre2+tmp.tamano_disco;
                }
                tmp1=tmp;
                tmp=tmp.siguiente;
                i=i+1;
                
            }
            v_torre2=i*(v_torre2);
            }else{v_torre2=0;}

            int v_torre3=0;
            if(torre_3.primero!=null){
                Nodo tmp=torre_3.primero;
                Nodo tmp1=tmp;
                int i=0;
                while(tmp!=null){
                    if(tmp.tamano_disco>tmp1.tamano_disco){
                        v_torre3=v_torre3-1000;
                    }
                    else{
                        v_torre3=v_torre3+tmp.tamano_disco;
                    }
                    tmp1=tmp;
                    tmp=tmp.siguiente;
                    i=i+1;
                    
                }
            v_torre3=i*(v_torre3);
            }else{v_torre3=0;}

            valor_heurisctico = v_torre3+v_torre2-v_torre1+this.profundidad;
    }
    public void GenerarHijos(Cola abiertos, Estado_Abierto pdre){
        if(this.valor_heurisctico!=0){
            if(!torre_1.esVacia()){
                Estado aux= new Estado();
                aux.torre_1=Pila.PasarElementos(torre_1);
                aux.torre_2=Pila.PasarElementos(torre_2);
                aux.torre_3=Pila.PasarElementos(torre_3);
                aux.nombre=this.nombre+"1";
                aux.torre_2.Apilar(aux.torre_1.desApilar());
                aux.profundidad=this.profundidad+1;
                aux.Calcular_FH();
                Estado_Abierto aux1=new Estado_Abierto();
                aux1.estado=aux;
                aux1.padre= pdre;
                abiertos.insertar(aux1);

                Estado aux2= new Estado();
                aux2.torre_1=Pila.PasarElementos(torre_1);
                aux2.torre_2=Pila.PasarElementos(torre_2);
                aux2.torre_3=Pila.PasarElementos(torre_3);
                aux2.nombre=this.nombre+"2";
                aux2.torre_3.Apilar(aux2.torre_1.desApilar());
                aux2.profundidad=this.profundidad+1;
                aux2.Calcular_FH();
                Estado_Abierto aux3=new Estado_Abierto();
                aux3.estado=aux2;
                aux3.padre= pdre;
                abiertos.insertar(aux3);

            }
            if(!torre_2.esVacia()){

                Estado aux= new Estado();
                aux.torre_1=Pila.PasarElementos(torre_1);
                aux.torre_2=Pila.PasarElementos(torre_2);
                aux.torre_3=Pila.PasarElementos(torre_3);
                aux.nombre=this.nombre+"3";
                aux.torre_1.Apilar(aux.torre_2.desApilar());
                aux.profundidad=this.profundidad+1;
                aux.Calcular_FH();
                Estado_Abierto aux1=new Estado_Abierto();
                aux1.estado=aux;
                aux1.padre= pdre;
                abiertos.insertar(aux1);

                Estado aux2= new Estado();
                aux2.torre_1=Pila.PasarElementos(torre_1);
                aux2.torre_2=Pila.PasarElementos(torre_2);
                aux2.torre_3=Pila.PasarElementos(torre_3);
                aux2.nombre=this.nombre+"4";
                aux2.torre_3.Apilar(aux2.torre_2.desApilar());
                aux2.profundidad=this.profundidad+1;
                aux2.Calcular_FH();
                Estado_Abierto aux3=new Estado_Abierto();
                aux3.estado=aux2;
                aux3.padre= pdre;
                abiertos.insertar(aux3);

            }
            if(!torre_3.esVacia()){

                Estado aux= new Estado();
                aux.torre_1=Pila.PasarElementos(torre_1);
                aux.torre_2=Pila.PasarElementos(torre_2);
                aux.torre_3=Pila.PasarElementos(torre_3);
                aux.nombre=this.nombre+"4";
                aux.torre_1.Apilar(aux.torre_3.desApilar());
                aux.profundidad=this.profundidad+1;
                aux.Calcular_FH();
                Estado_Abierto aux1=new Estado_Abierto();
                aux1.estado=aux;
                aux1.padre= pdre;
                abiertos.insertar(aux1);

                Estado aux2= new Estado();
                aux2.torre_1=Pila.PasarElementos(torre_1);
                aux2.torre_2=Pila.PasarElementos(torre_2);
                aux2.torre_3=Pila.PasarElementos(torre_3);
                aux2.nombre=this.nombre+"5";
                aux2.torre_2.Apilar(aux2.torre_3.desApilar());
                aux2.profundidad=this.profundidad+1;
                aux2.Calcular_FH();
                Estado_Abierto aux3=new Estado_Abierto();
                aux3.estado=aux2;
                aux3.padre= pdre;
                abiertos.insertar(aux3);

            }
        }
    }
    public void imprimirEstado(){
        System.out.println("\n"+nombre);
        torre_1.imprimirPila("Torre 1");
        torre_2.imprimirPila("Torre 2");
        torre_3.imprimirPila("Torre 3");
        System.out.println("\nValor Heuristico:"+valor_heurisctico+"\n");
    }
}
