package Logic;

import org.nfunk.jep.JEP;

public class Funcion {

    private String funcion;
    private double resultado;
    private double x;
    private String error = "";
    private JEP javaFuncion = new JEP();

    public Funcion() {
        this.javaFuncion.addStandardFunctions();
        this.javaFuncion.addStandardConstants();
    }

    public void definirFuncion(String funcion) {
        this.funcion = funcion;
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

    private boolean trigonometrica() {
        if (funcion.contains("sin") || funcion.contains("cos") || funcion.contains("tan") || funcion.contains("asin") || funcion.contains("acos") || funcion.contains("atan")) {
            return true;
        }
        return false;
    }
}
