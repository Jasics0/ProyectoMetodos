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
public class Derivacion {
private final Funcion funcion = new Funcion();
    private double xi, xu;

    public Derivacion(String funcion) {
        this.funcion.definirFuncion(funcion);
        this.xi = this.funcion.getA();
        this.xu = this.funcion.getB();
        }
  public double derivacion() {
        double xo,h=0.000000001,acumu=0;

        
        Scanner sc = new Scanner(System.in);
        System.out.print("El numero donde quiere evaluar la funcion");
        xo = sc.nextDouble();
        acumu=(evaluarFuncion(xo+h)-evaluarFuncion(xo))/h;
        
         
        
        return acumu;
}
    

    private double evaluarFuncion(double x){
        Funcion funcion = new Funcion();
        funcion.definirFuncion(this.funcion.getFuncion());
        funcion.valor(x);
        return Double.parseDouble(funcion.getResultado());
    }

    public static void main(String[] args) {
        double a=0;
        Derivacion i = new Derivacion("(x^3)+3*x");
        
        System.out.println(i.derivacion());
       /* Funcion porno = new Funcion();
        porno.definirFuncion("(x^3)+3*x");
        porno.derivar();
        porno.valor(5.0);
        System.out.println(porno.getResultado());
     */
    }
}
