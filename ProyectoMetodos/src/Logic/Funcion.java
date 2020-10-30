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

    private void definirFuncionN(String funcion) {
        this.funcionOriginal = this.funcion = funcion;
    }

    public void definirFuncion(String funcion) {
        this.funcionOriginal = this.funcion = funcion;
        valor(1);
        while (getResultado().contains("error")) {
            System.out.print("La función no sirve weonaso. Digite otra:");
            definirFuncion(new Scanner(System.in).next());
        }
        encontrarNumeros();
    }
    
        public void definirFuncionA(String funcion) {
        this.funcionOriginal = this.funcion = funcion;
        valor(1);
        while (getResultado().contains("error")) {
            System.out.print("La función no sirve weonaso. Digite otra:");
            definirFuncion(new Scanner(System.in).next());
        }
    }

    public void valor(double x) {
        this.x = x;
    }

    public String getResultado() {
        evaluarFuncion();
        if (!error.equals("")) {
            System.out.println("jajabruto");
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
        funcion = funcionOriginal;
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
                } else {
                    i2 -= 1;
                }
                valor(distribuirSignos(i, i2));
            }
            b = anterior;
            while (Double.parseDouble(getResultado()) >= 0) {
                if (i2 == -9) {
                    i -= 1;
                    i2 = 0;
                } else {
                    i2 -= 1;
                }
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

    public double derivarDefinicion(String funcion, double xo, int orden) {
        definirFuncionN(funcion);
        double h = 0.1;
        double acumu = 0, fxi, fxl, aux = 0;
        double[] A = new double[6];
        switch(orden){
          case 1:
                h=0.000000001;
                break;
            case 2:
                h=0.000001;
                break;
            case 3:
                h=0.001;
                break;
            case 4:
                h=0.1;
                break;
        }
       for (int i = 0; i < A.length; i++) {
            aux = xo + (h * i);
            valor(aux);
            A[i] = Double.parseDouble(getResultado());
        }

        switch (orden) {
            case 1:
                acumu = (-A[2] + 4 * A[1] - 3 * A[0]) / (2 * h);
                break;
            case 2:
                acumu = (-A[3] + 4 * A[2] - 5 * A[1] + 2 * A[0]) / Math.pow(h, 2);
                break;
            case 3:
                acumu = (-3 * A[4] + 14 * A[3] - 24 * A[2] + 18 * A[1] - 5 * A[0]) / (2 * (Math.pow(h, 3)));
                break;
            case 4:
                acumu = (-2 * A[5] + 11 * A[4] - 24 * A[3] + 26 * A[2] - 14 * A[1] + 3 * A[0]) / (Math.pow(h, 4));
                break;
        }

        return acumu;
    }

   
}
