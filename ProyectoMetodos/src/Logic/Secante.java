package Logic;

public class Secante {

    private final Funcion funcion = new Funcion();
    private double xi, xi_1;

    public Secante(String funcion) {
        this.funcion.definirFuncion(funcion);
        this.xi = this.funcion.getA();
        this.xi_1 = xi - 1;
    }

    public double calcularSecante() {
        double xr = xi - (evaluarFuncion(xi) * (xi - xi_1) / (evaluarFuncion(xi) - evaluarFuncion(xi_1)));
        double fBack = 0;
        double fNext = xr;
        while (Float.isNaN(Float.parseFloat(((fNext - fBack) / fNext) + "")) || (Math.round(Math.abs((fNext - fBack) / fNext) * 100)) != 0) {
            fBack = fNext;
            xi_1 = xi;
            xi = fNext;
            if (fNext != 0) {
                fNext = xi - (evaluarFuncion(xi) * (xi - xi_1) / (evaluarFuncion(xi) - evaluarFuncion(xi_1)));
            } else {
                break;
            }
        }
        return fNext;
    }

    private double evaluarFuncion(double x) {
        Funcion funcion = new Funcion();
        funcion.definirFuncion(this.funcion.getFuncion());
        funcion.valor(x);
        return Double.parseDouble(funcion.getResultado());
    }

    public static void main(String[] args) {
        Secante s = new Secante("x^2-43");
        System.out.println(s.calcularSecante());
    }
}
