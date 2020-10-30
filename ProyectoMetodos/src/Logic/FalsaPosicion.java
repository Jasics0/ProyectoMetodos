package Logic;

public class FalsaPosicion {

    private final Funcion funcion = new Funcion();
    private double xi, xu;

    public FalsaPosicion(String funcion) {

        this.funcion.definirFuncion(funcion);
        this.xi = this.funcion.getA();
        this.xu = this.funcion.getB();
    }

    public String hallarXr() {
        if (xi == xu) {
            return "La funcion es par";
        } else {
            double xr = ((evaluarFuncion(xu) * xi) - evaluarFuncion(xi) * xu) / (evaluarFuncion(xu) - evaluarFuncion(xi));
            double fBack = 0;
            double fNext = xr;

            while (Float.isNaN(Float.parseFloat(((fNext - fBack) / fNext) + "")) || (Math.round(Math.abs((fNext - fBack) / fNext) * 100)) != 0) {
                fBack = fNext;
                if (evaluarFuncion(xi) * evaluarFuncion(fNext) < 0) {
                    xu = fNext;
                } else {
                    xi = fNext;
                }
                if (fNext != 0) {
                    fNext = ((evaluarFuncion(xu) * xi) - evaluarFuncion(xi) * xu) / (evaluarFuncion(xu) - evaluarFuncion(xi));
                } else{
                break;
                }
            }
            return fNext + "";
        }
    }

    private double evaluarFuncion(double x) {
        Funcion funcion = new Funcion();
        funcion.definirFuncion(this.funcion.getFuncion());
        funcion.valor(x);
        return Double.parseDouble(funcion.getResultado());
    }

    public static void main(String[] args) {
        FalsaPosicion f = new FalsaPosicion("x-23");
        System.out.println(f.hallarXr());

    }
}
