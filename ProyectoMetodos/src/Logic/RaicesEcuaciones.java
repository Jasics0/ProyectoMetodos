package Logic;

import java.util.ArrayList;
import java.util.Scanner;

public class RaicesEcuaciones {

    static ArrayList <double[]> tabla= new ArrayList<double[]>();
    double [][] A,B;
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

        }
        return suma;
    }

    public static void main(String[] args) {
        RaicesEcuaciones r= new RaicesEcuaciones();
        r.ingresarDatos(new Scanner(System.in).nextDouble(),new Scanner(System.in).nextDouble());
        r.ingresarDatos(new Scanner(System.in).nextDouble(),new Scanner(System.in).nextDouble());
        for (int i = 0; i < r.getTabla().size() ; i++) {
            m.imprimirMatriz(r.getTabla().get(i));
            System.out.println();
        }
    }
}
