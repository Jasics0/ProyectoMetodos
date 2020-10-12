package Logic;

import org.lsmp.djep.djep.DJep;
import org.nfunk.jep.JEP;
import org.nfunk.jep.Node;
import org.nfunk.jep.ParseException;

public class Funcion {

    private String funcionOriginal;
    private String funcion;
    private double resultado;
    private double x;
    private String error = "";
    private final JEP javaFuncion = new JEP();

    public Funcion() {
        this.javaFuncion.addStandardFunctions();
        this.javaFuncion.addStandardConstants();
    }

    public void definirFuncion(String funcion) {
        this.funcionOriginal=this.funcion = funcion;
    }

    public void valorX(double x) {
        this.x = x;
    }

    public String getResultado() {
        evaluarFuncion();
        if (!error.equals("")) {
            return error;
        } else {
            return resultado + "";
        }
    }

    private void evaluarFuncion() {
        if (trigonometrica()) {
            x = Math.toRadians(x);
            javaFuncion.addVariable("x", x);
        } else {
            javaFuncion.addVariable("x", x);
        }

        javaFuncion.parseExpression(funcion);

        if (trigonometrica()) {
            resultado = javaFuncion.getValue();
        } else {
            resultado = javaFuncion.getValue();
        }
        error = (javaFuncion.hasError()) ? "Hubo un error." : "";
    }

    public String getFuncion() {
        return funcion;
    }

    public String getFuncionOriginal(){
        return funcionOriginal;
    }

    private boolean trigonometrica() {
        if (funcion.contains("sin") || funcion.contains("cos") || funcion.contains("tan") || funcion.contains("asin") || funcion.contains("acos") || funcion.contains("atan")) {
            return true;
        }
        return false;
    }


    public void derivar(){
        String derivada="";
        String respecto="x";

        DJep derivador= new DJep();

        derivador.addStandardFunctions();
        derivador.addStandardConstants();
        derivador.addComplex();
        derivador.setAllowUndeclared(true);
        derivador.setAllowAssignment(true);
        derivador.setImplicitMul(true);
        derivador.addStandardDiffRules();

        try {
            Node diff = derivador.parse(funcion);
            diff= derivador.differentiate(diff,respecto);
            diff= derivador.simplify(diff);
            derivada= derivador.toString(diff);
            funcion=derivada;
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
