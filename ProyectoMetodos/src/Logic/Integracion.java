/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logic;
import java.util.Scanner;
/**
 *
 * @author Sebástian
 */
public class Integracion {
 private final Funcion funcion = new Funcion();
    private double xi, xu;

    public Integracion(String funcion) {
        this.funcion.definirFuncion(funcion);
        this.xi = this.funcion.getA();
        this.xu = this.funcion.getB();
        }
  public double simpson(double a, double b) {
        double h,fNext,acumu=0;

       
        h=(b-a)/100000;
         for (int i = 0; i <100000; i++) {
        if(i==1 || i==100000){
        fNext=a+i*h;
        acumu+=evaluarFuncion(fNext);
        }else{
         if(i%2==0){
        fNext=a+i*h;
        acumu=acumu+2*evaluarFuncion(fNext);
        }else{
         fNext=a+i*h;
        acumu=acumu+4*evaluarFuncion(fNext);
}}
}
        
        return acumu*(h/3);
}
    

    private double evaluarFuncion(double x){
        Funcion funcion = new Funcion();
        funcion.definirFuncion(this.funcion.getFuncion());
        funcion.valor(x);
        return Double.parseDouble(funcion.getResultado());
    }

    public static void main(String[] args) {

        Integracion i = new Integracion("x^(1/2)");
        
            System.out.println(i.simpson(1,2));
    }
}
