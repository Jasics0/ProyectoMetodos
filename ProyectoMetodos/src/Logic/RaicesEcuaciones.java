package Logic;

import java.util.ArrayList;

public class RaicesEcuaciones {

    static ArrayList <double[]> tabla= new ArrayList<double[]>();

    public void ingresarDatos(double x,double y){
        tabla.add(new double[2]);
        tabla.get(0)[0]=x;
        tabla.get(0)[1]=y;
    }



    public static void main(String[] args) {
    }
}
