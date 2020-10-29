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
    
    public String sacarEcu(int x){
        A= new double[x][x];
        B= new double[x][1];
        int aux=0;
        for(int i=0;i<x;i++){
            for(int j=0;j<x;j++){
               
                if(i==0){
                if(j==0)
                 A[0][0]= numDatos();
                 else
                 A[i][j]=sumX("x^"+(j),0);
                }else{ 
                 A[i][j]=sumX("x^"+(j+aux),0);
                 
}
                if(j==(x-1)){
                aux+=1;
                }
            }
            
        }
         for(int i=0;i<x;i++){
            if(i==0){   
                B[0][0]=sumX("x",1);
            }else{
                 B[i][0]=sumXY("x^"+i,"x",0,1);
}

}
        double[][] AI=m.matrizInversa(A);
        double[][] resul= m.multiplicarMatriz(AI,B);
        String ecuacion="La funcion aproximada a los valores de la tabla está definida por : Y=";
    for(int i=(x-1);i>=0;i--){
    if(i==0)
ecuacion+=resul[i][0];  
else
    ecuacion+=resul[i][0]+" X^"+i+" + ";  
}
        return ecuacion;
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
public String sacarEcuLog(){
       A= new double[2][2];
       B= new double[2][1];

        for(int i=0;i<2;i++){
        
            for(int j=0;j<2;j++){
               
                if(i==0){
                if(j==0)
                 A[0][0]= numDatos();
                 else
                 A[i][j]=sumX("ln(x)",0);
                }else{ 
                 A[i][j]=sumX("(ln(x))^"+(j+1),0);
                 
}
                
            }
            
        }
           
         B[0][0]=sumX("x",1);
         B[1][0]=sumXY("ln(x)","x",0,1);
         double[][] AI=m.matrizInversa(A);
         double[][] resul= m.multiplicarMatriz(AI,B);
         return "La funcion aproximada a los valores de la tabla está definida por : Y="+resul[1][0]+"ln(x) + "+resul[0][0];
         
}


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RaicesEcuaciones r= new RaicesEcuaciones();
        int num;
        double x,y;
       /* System.out.print("Digite la cantidad de filas que contiene la tabla ");
        num = sc.nextInt();
        for (int i = 0; i<num; i++) {
        System.out.print("Dijite el valor de x");
        x = sc.nextDouble();
        System.out.print("Dijite el valor de y");
        y = sc.nextDouble();
        r.ingresarDatos(x,y);
        }
        

*/

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

      


        A= new double[3][3];
        B= new double[3][1];

        A[0][0]= r.numDatos();
        A[0][1]= r.sumX("x",0);
        A[0][2]= r.sumX("x^2",0);
        
        A[1][0]= r.sumX("x",0);
        A[1][1]= r.sumX("x^2",0);
        A[1][2]= r.sumX("x^3",0);
        
        A[2][0]= r.sumX("x^2",0);
        A[2][1]= r.sumX("x^3",0);
        A[2][2]= r.sumX("x^4",0);
        

        B[0][0]=r.sumX("x",1);

        B[1][0]=r.sumXY("x","x",0,1);

        B[2][0]=r.sumXY("x^2","x",0,1);

        double[][] AI=m.matrizInversa(A);
        double[][] resul= m.multiplicarMatriz(AI,B);

        System.out.println(r.sacarEcu(2));
       
        System.out.println("La funcion aproximada a los valores de la tabla está definida por : Y="+resul[2][0]+"X^2"+resul[1][0]+"(X) +"+resul[0][0]);
        System.out.println(r.sacarEcuLog());



    }
}
