import java.util.ArrayList;
public class Estado_Abierto{
    Estado_Abierto siguiente;
    Estado estado;
    public Estado_Abierto padre;
    public Estado_Abierto(){
        siguiente=null;
        estado=null;
    }
    public boolean estaEnCerrados(ArrayList<Estado_Abierto> cerrados) {
        boolean bandera = false;
        for(int i=0; i<cerrados.size(); i++){
                Estado x = cerrados.get(i).estado;
                if((x.torre_1.sonTorresIguales(this.estado.torre_1)&&(x.torre_2.sonTorresIguales(this.estado.torre_2))&&(x.torre_3.sonTorresIguales(this.estado.torre_3)))){
                    bandera=true;
                    i=cerrados.size();
                }
            
        }
        return bandera;
    }
}
