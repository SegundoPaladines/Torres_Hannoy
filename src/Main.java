import java.util.ArrayList;
import java.util.Scanner;
public class Main{
    public static void main (String [ ] args) {
        ArrayList<Estado_Abierto> cerrados = new ArrayList<Estado_Abierto>();
        Cola abiertos = new Cola();
        Pila torre_1 = new Pila();
        Pila torre_2 = new Pila();
        Pila torre_3 = new Pila();

        //Establecer Estado Objetivo
        torre_3.Apilar(new Nodo(1));
        torre_3.Apilar(new Nodo(2));
        torre_3.Apilar(new Nodo(3));
        torre_3.Apilar(new Nodo(4));

        Estado e_objetivo= new Estado();
        e_objetivo.torre_1=torre_1;
        e_objetivo.torre_2=torre_2;
        e_objetivo.torre_3=torre_3;
        e_objetivo.nombre="EO";
        e_objetivo.profundidad=16;
        e_objetivo.Calcular_FH();

        //e_objetivo.imprimirEstado();

        torre_1.LimpiarPila();
        torre_2.LimpiarPila();
        torre_3.LimpiarPila();
        //establecer el estado inicial

        torre_1.Apilar(new Nodo(1));
        torre_1.Apilar(new Nodo(2));
        torre_1.Apilar(new Nodo(3));
        torre_1.Apilar(new Nodo(4));

        Estado e_inicial= new Estado();
        e_inicial.torre_1=torre_1;
        e_inicial.torre_2=torre_2;
        e_inicial.torre_3=torre_3;
        e_inicial.nombre="EI";
        e_inicial.profundidad=0;
        e_inicial.Calcular_FH();

        e_inicial.imprimirEstado();
        Estado e_actual=new Estado();
        e_actual.torre_1=torre_1;
        e_actual.torre_2=torre_2;
        e_actual.torre_3=torre_3;
        e_actual.nombre="EA";
        e_actual.profundidad=0;
        e_actual.Calcular_FH();

        Estado_Abierto e_i = new Estado_Abierto();
        e_i.estado=e_actual;
        e_actual.GenerarHijos(abiertos, e_i);
        int i=0;
        while((e_objetivo.valor_heurisctico>e_actual.valor_heurisctico)){

            Estado_Abierto x = abiertos.extraer();
            while(x.estaEnCerrados(cerrados)){
                x=abiertos.extraer();
            }
            abiertos.imprimir();
            e_actual=x.estado;
            e_actual.GenerarHijos(abiertos, x);
            //e_actual.imprimirEstado();
            cerrados.add(x);
            i++;
        }

        //System.out.println("Solucion Encontrada en "+(i+1)+" Pasos");

            Estado_Abierto e_final = new Estado_Abierto();
            e_final=cerrados.get(cerrados.size()-1);
            pilaPadres padres = new pilaPadres();
            
            Estado_Abierto aux=e_final;
            while(aux!=null){
                padres.Apilar(aux);
                aux=aux.padre;
            }
            System.out.println("Inicio_________________________________________________________________________________");
            int j=0;
            Estado_Abierto aux2=padres.primero;
            while(aux2!=null){
                aux2.estado.imprimirEstado();
                System.out.println("Paso Numero: "+(j+1)+"");
                System.out.println("____________________________________________________________________________________");
                aux2=aux2.siguiente;
                j=j+1;
            }
            int k=0;
            Estado_Abierto x=abiertos.pri;
            while(x!=null){
                x=x.siguiente;
                k++;
            }

            System.out.println("\n"+k+" Estados Abiertos");
            System.out.println("Solucion Encontrada en "+(j)+" Pasos");
            System.out.println("____________________________________________________________________________________");
            System.out.println("\nNOTA: LOS VALORES DE TAMAÑO REPRESENTAN LA PEQUEÑURA DE LAS FICHAS \n"
            +"ES DECIR, LA FUCHA 4 ES LA MAS PEQUEÑA, LUEGO LA FICHA 3 ES LA SEGUNDA MAS PEQUEÑA \n"
            +"SEGUDIA DE LA FICHA 2 Y LA FICHA 1 ES LA MAS GRANDE\n");
            System.out.println("Fin Programa_______________________________________________________________________________");
    }
}
