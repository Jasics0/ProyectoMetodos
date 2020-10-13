package Logic;

import java.util.ArrayList;

public class RaicesEcuaciones {

    static ArrayList <double[]> tabla= new ArrayList<double[]>();
    double [][] A,B;
    Matriz m=new Matriz();

    public RaicesEcuaciones(){
        A =new double[2][2];

        A[0][0]=10;
        A[0][1]=99.5;

        A[1][0]=99.5;
        A[1][1]=1323.25;

        B =new double[2][1];

        B[0][0]=72.8;

        B[1][0]=580.7;

        m.imprimirMatriz(m.multiMatri(m.matrizInversa(A),B));

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
