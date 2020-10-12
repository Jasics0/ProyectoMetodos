package Logic;

public class NewtonRaphson {

    private final Funcion funcion = new Funcion();
    private double xi = 0;


    public NewtonRaphson(String funcion) {
        this.funcion.definirFuncion(funcion);
        this.xi=this.funcion.getA();
    }

    public double calcularNewtonRaphson(){
        double xr=0;
        funcion.valorX(xi);
        xr= Double.parseDouble(funcion.getResultado());
        funcion.derivar();
        xr/= Double.parseDouble(funcion.getResultado());
        xr= xi-xr;
        double fBack = 0;
        double fNext=xr ;
        while (Float.isNaN(Float.parseFloat(((fNext - fBack) / fNext) + "")) || (Math.round(Math.abs((fNext - fBack) / fNext) * 100)) != 0) {
            fBack=fNext;
            xi=xr;
            funcion.valorX(xi);
            funcion.volverFuncionOriginal();
            fNext= Double.parseDouble(funcion.getResultado());
            funcion.derivar();
            fNext/= Double.parseDouble(funcion.getResultado());
            fNext= xi-fNext;
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
        NewtonRaphson n = new NewtonRaphson("x^2+ln(x)+e^x-205");
        System.out.println(n.calcularNewtonRaphson());
    }
}
