package Logic;

import java.util.Scanner;

public class FalsaPosicion {

    private final Funcion funcion = new Funcion();
    private double xi = 0, xu = 0;


    public FalsaPosicion(String funcion) {
        this.funcion.definirFuncion(funcion);
        this.xi=this.funcion.getA();
        this.xu=this.funcion.getB();
    }

    public double  hallarXr(){
        double xr=0;
        xr= ((evaluarFuncion(xu)*xi)-evaluarFuncion(xi)*xu)/(evaluarFuncion(xu)-evaluarFuncion(xi));
        double fBack = 0;
        double fNext=xr ;
        while (Float.isNaN(Float.parseFloat(((fNext - fBack) / fNext) + "")) || (Math.round(Math.abs((fNext - fBack) / fNext) * 100)) != 0) {
        fBack=fNext;
        if (evaluarFuncion(xi) * evaluarFuncion(xr)<0){
        xu=xr;
        } else{
        xi=xr;
        }
        fNext= ((evaluarFuncion(xu)*xi)-evaluarFuncion(xi)*xu)/(evaluarFuncion(xu)-evaluarFuncion(xi));
        }
        return fNext;
    }

    private double evaluarFuncion(double x){
        Funcion funcion = new Funcion();
        funcion.definirFuncion(this.funcion.getFuncion());
        funcion.valorX(x);
        return Double.parseDouble(funcion.getResultado());
    }

    public static void main(String[] args) {
        FalsaPosicion f = new FalsaPosicion("x^2+ln(x)+e^x-205");
        System.out.println(f.hallarXr());
    }
}
