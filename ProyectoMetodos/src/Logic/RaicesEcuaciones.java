package Logic;

import java.util.ArrayList;

public class RaicesEcuaciones {

    static ArrayList <double[]> tabla= new ArrayList<double[]>();
    double [][] A,B;
    Matriz m=new Matriz();

    public RaicesEcuaciones(){
        A =new double[2][4];

        A[0][0]=5;
        A[0][1]=3;
        A[0][2]=-4;
        A[0][3]=-2;

        A[1][0]=8;
        A[1][1]=-1;
        A[1][2]=0;
        A[1][3]=-3;


        B =new double[4][3];

        B[0][0]=1;
        B[0][1]=4;
        B[0][2]=0;

        B[1][0]=-5;
        B[1][1]=3;
        B[1][2]=7;

        B[2][0]=0;
        B[2][1]=-9;
        B[2][2]=5;

        B[3][0]=5;
        B[3][1]=1;
        B[3][2]=4;

        m.imprimirMatriz(m.multiMatri(A,B));

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
