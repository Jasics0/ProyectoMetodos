package Logic;

import org.lsmp.djep.djep.DJep;
import org.nfunk.jep.JEP;
import org.nfunk.jep.Node;
import org.nfunk.jep.ParseException;

import java.util.Scanner;

public class Funcion {

    private String funcionOriginal;
    private String funcion;
    private double resultado;
    private double x;
    private String error = "";
    private final JEP javaFuncion = new JEP();
    private double a, b;

    public Funcion() {
        this.javaFuncion.addStandardFunctions();
        this.javaFuncion.addStandardConstants();
    }

    public void definirFuncion(String funcion) {
        this.funcionOriginal = this.funcion = funcion;
        valor(1);
        while (getResultado().contains("error")) {
            System.out.print("La función no sirve weonaso. Digite otra:");
            definirFuncion(new Scanner(System.in).next());
        }

        if (Double.parseDouble(getResultado())>0){
            valor(-1);
            if (Double.parseDouble(getResultado())>0){
               // System.out.println("La funcion es par.");
            }
        } else {
            encontrarNumeros();
        }
    }

    public void valor(double x) {
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

    public void volverFuncionOriginal() {
        funcion=funcionOriginal;
    }

    private boolean trigonometrica() {
        if (funcion.contains("sin") || funcion.contains("cos") || funcion.contains("tan") || funcion.contains("asin") || funcion.contains("acos") || funcion.contains("atan")) {
            return true;
        }
        return false;
    }

    public Double distribuirSignos(int i, int i2) {
        if (i < 0 || i2 < 0) {
            i = Math.abs(i);
            i2 = Math.abs(i2);

            return -Double.parseDouble(i + "." + i2);
        } else {
            return Double.parseDouble(i + "." + i2);
        }
    }

    public void derivar() {
        String derivada = "";
        String respecto = "x";

        DJep derivador = new DJep();

        derivador.addStandardFunctions();
        derivador.addStandardConstants();
        derivador.addComplex();
        derivador.setAllowUndeclared(true);
        derivador.setAllowAssignment(true);
        derivador.setImplicitMul(true);
        derivador.addStandardDiffRules();

        try {
            Node diff = derivador.parse(funcion);
            diff = derivador.differentiate(diff, respecto);
            diff = derivador.simplify(diff);
            derivada = derivador.toString(diff);
            funcion = derivada;
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void encontrarNumeros() {
        double anterior = 0;
        valor(0.1);
        int i = 0, i2 = 1;
        while (Float.isInfinite(Float.parseFloat(getResultado()))) {
            i2 += 1;
            if (i2 == 10) {
                i += 1;
                i2 = 0;
            }
            valor(distribuirSignos(i, i2));
        }
        if (Double.parseDouble(getResultado()) < 0) {
            while (Double.parseDouble(getResultado()) < 0) {
                anterior = distribuirSignos(i, i2);
                i2 += 1;
                if (i2 == 10) {
                    i += 1;
                    i2 = 0;
                }
                valor(Double.parseDouble(i + "." + i2));
            }
            a = anterior;
            while (Double.parseDouble(getResultado()) <= 0) {
                i2 += 1;
                if (i2 == 10) {
                    i += 1;
                    i2 = 0;
                }
                valor(distribuirSignos(i, i2));
            }
            b = distribuirSignos(i, i2);
        } else {
            while (Double.parseDouble(getResultado()) > 0) {
                anterior = distribuirSignos(i, i2);
                if (i2 == -9) {
                    i -= 1;
                    i2 = 0;
                } else
                    i2 -= 1;
                valor(distribuirSignos(i, i2));
            }
            b = anterior;
            while (Double.parseDouble(getResultado()) >= 0) {
                if (i2 == -9) {
                    i -= 1;
                    i2 = 0;
                } else
                    i2 -= 1;
                valor(distribuirSignos(i, i2));
            }
            a = distribuirSignos(i, i2);
        }
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double derivarDefinicion(double xo) {
        double h=0.000000001,acumu=0,fxi,fxl;
        valor(xo+h);
        fxi=Double.parseDouble(getResultado());
        valor(xo);
        fxl=Double.parseDouble(getResultado());
        acumu=(fxi-fxl)/h;
        
         
        
        return acumu;
}

}
