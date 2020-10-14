package Logic;

import java.util.ArrayList;
import java.util.Scanner;

public class RaicesEcuaciones {

    static ArrayList <double[]> tabla= new ArrayList<double[]>();
    static  double[][] A,B;
    static Matriz m=new Matriz();

    public RaicesEcuaciones(){
    }

    public void ingresarDatos(double x,double y){
        tabla.add(new double[2]);
        tabla.get(tabla.size()-1)[0]=x;
        tabla.get(tabla.size()-1)[1]=y;
    }

    public static ArrayList<double[]> getTabla() {
        return tabla;
    }

    public  int numDatos(){
        return tabla.size();
    }

    public double sumX(String funcion,int num){
        Funcion f = new Funcion();
        double suma=0;
        f.definirFuncion(funcion);
        for (int i = 0; i <numDatos() ; i++) {
        f.valor(tabla.get(i)[num]);
        suma+=Double.parseDouble(f.getResultado());
        }
        return suma;
    }

    public double sumXY(String funcion,String funcion2,int num,int num2){
        Funcion f = new Funcion();
        Funcion f2= new Funcion();
        
        double suma=0;
        f.definirFuncion(funcion);
        f2.definirFuncion(funcion2);
        for (int i = 0; i <numDatos() ; i++) {
            f.valor(tabla.get(i)[num]);
            f2.valor(tabla.get(i)[num2]);
            suma+=Double.parseDouble(f.getResultado())*Double.parseDouble(f2.getResultado());
        }
        return suma;
    }

    public static void main(String[] args) {

        RaicesEcuaciones r= new RaicesEcuaciones();

        r.ingresarDatos(2.5,13);
        r.ingresarDatos(3.5,11);
        r.ingresarDatos(5,8.5);
        r.ingresarDatos(6,8.2);
        r.ingresarDatos(7.5,7);
        r.ingresarDatos(10,6.2);
        r.ingresarDatos(12.5,5.2);
        r.ingresarDatos(15,4.8);
        r.ingresarDatos(17.5,4.6);
        r.ingresarDatos(20,4.3);



        A= new double[2][2];
        B= new double[2][1];

        A[0][0]= r.numDatos();
        A[0][1]= r.sumX("x",0);

        A[1][0]= r.sumX("x",0);
        A[1][1]= r.sumX("x^2",0);

        B[0][0]=r.sumX("x",1);

        B[1][0]=r.sumXY("x","x",0,1);

        double[][] AI=m.matrizInversa(A);
        double[][] resul= m.multiplicarMatriz(AI,B);

        m.imprimirMatriz(resul);
        System.out.println("La funcion aproximada a los valores de la tabla está definida por : Y="+resul[1][0]+"(X) +"+resul[0][0]);



    }
}
