package Logic;

public class SecanteModificado {
    private final Funcion funcion = new Funcion();
    private double xi;

    public SecanteModificado(String funcion) {
        this.funcion.definirFuncion(funcion);
        this.xi=this.funcion.getB();
    }

    public double calcularSecanteModificado(){
        double d = 0.1;
        double xr=xi-((d *xi*evaluarFuncion(xi))/(evaluarFuncion(xi+ d *xi)-evaluarFuncion(xi)));
        double fBack = 0;
        double fNext=xr ;
        while (Float.isNaN(Float.parseFloat(((fNext - fBack) / fNext) + "")) || (Math.round(Math.abs((fNext - fBack) / fNext) * 100)) != 0) {
            fBack=fNext;
            xi=fNext;
            fNext=xi-((d *xi*evaluarFuncion(xi))/(evaluarFuncion(xi+ d *xi)-evaluarFuncion(xi)));
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
        SecanteModificado sm=new SecanteModificado("x^2-43");
        System.out.println(sm.calcularSecanteModificado());
    }
}
