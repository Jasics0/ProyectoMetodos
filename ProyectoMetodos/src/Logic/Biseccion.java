package Logic;

public class Biseccion {

    private final Funcion funcion = new Funcion();
    private double xi, xu;

    public Biseccion(String funcion) {
        this.funcion.definirFuncion(funcion);
        this.xi = this.funcion.getA();
        this.xu = this.funcion.getB();
    }

    public double biseccion() {
        double xr=(xi+xu)/2;
        double fBack = 0;
        double fNext=xr ;
        while (Float.isNaN(Float.parseFloat(((fNext - fBack) / fNext) + "")) || (Math.round(Math.abs((fNext - fBack) / fNext) * 100)) != 0) {
            fBack=fNext;
            if (evaluarFuncion(xi) * evaluarFuncion(fNext)<0){
                xu=fNext;
            } else{
                xi=fNext;
            }
            fNext= (xi+xu)/2;
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
        Biseccion b = new Biseccion("x^2+ln(x)+e^x-205");
        System.out.println(b.biseccion());
    }
}
