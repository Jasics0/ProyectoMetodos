package Logic;

import java.util.ArrayList;

public class RaicesEcuaciones {

    static ArrayList <double[]> tabla= new ArrayList<double[]>();
    double [][] matrizExcel;
    Matriz m=new Matriz();

    public RaicesEcuaciones(){
        matrizExcel=new double[2][2];
        matrizExcel[0][0]=10;
        matrizExcel[0][1]=99.5;

        matrizExcel[1][0]=99.5;
        matrizExcel[1][1]=1323.25;


        m.imprimirMatriz(m.matrizInversa(matrizExcel));

    }

    public void ingresarDatos(double x,double y){
        tabla.add(new double[2]);
        tabla.get(0)[0]=x;
        tabla.get(0)[1]=y;
    }



    public static void main(String[] args) {
        RaicesEcuaciones r= new RaicesEcuaciones();
    }
}
