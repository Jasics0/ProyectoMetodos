package Logic;

public class FalsaPosicion {

    private final Funcion funcion = new Funcion();
    private double xi, xu;

    public FalsaPosicion(String funcion) {
        this.funcion.definirFuncion(funcion);
        this.xi=this.funcion.getA();
        this.xu=this.funcion.getB();
    }

    public double  hallarXr(){
        double xr=((evaluarFuncion(xu)*xi)-evaluarFuncion(xi)*xu)/(evaluarFuncion(xu)-evaluarFuncion(xi));
        double fBack = 0;
        double fNext=xr ;
        while (Float.isNaN(Float.parseFloat(((fNext - fBack) / fNext) + "")) || (Math.round(Math.abs((fNext - fBack) / fNext) * 100)) != 0) {
        fBack=fNext;
        if (evaluarFuncion(xi) * evaluarFuncion(fNext)<0){
        xu=fNext;
        } else{
        xi=fNext;
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
        FalsaPosicion f = new FalsaPosicion("x^2-43");
        System.out.println(f.hallarXr());
    }
}
