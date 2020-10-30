package Logic;

public class NewtonRaphson {

    private final Funcion funcion = new Funcion();
    private double xi;

    public NewtonRaphson(String funcion) {
        this.funcion.definirFuncion(funcion);
        this.xi = this.funcion.getA();
    }

    public double calcularNewtonRaphson() {
        double xr = 0;
        funcion.valor(xi);
        xr = Double.parseDouble(funcion.getResultado());
        funcion.derivar();
        xr /= Double.parseDouble(funcion.getResultado());
        xr = xi - xr;
        double fBack = 0;
        double fNext = xr;
        while (Float.isNaN(Float.parseFloat(((fNext - fBack) / fNext) + "")) || (Math.round(Math.abs((fNext - fBack) / fNext) * 100)) != 0) {
            fBack = fNext;
            xi = xr;
            if (fNext != 0) {
                funcion.valor(xi);
                funcion.volverFuncionOriginal();
                fNext = Double.parseDouble(funcion.getResultado());
                funcion.derivar();
                fNext /= Double.parseDouble(funcion.getResultado());
                fNext = xi - fNext;
            } else {
                break;
            }

        }
        return fNext;
    }

    public static void main(String[] args) {
        NewtonRaphson n = new NewtonRaphson("x");
        System.out.println(n.calcularNewtonRaphson());
    }
}
