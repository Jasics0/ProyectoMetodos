package Logic;

import java.util.Scanner;

public class FaltaPosicion {

    private final Funcion funcion = new Funcion();
    private double a = 0, b = 0;

    public FaltaPosicion(String funcion) {
        this.funcion.definirFuncion(funcion);
        this.funcion.valorX(1);
        while (this.funcion.getResultado().contains("error")) {
            System.out.print("La función no sirve weonaso. Digite otra:");
            this.funcion.definirFuncion(new Scanner(System.in).next());
        }
    }

    private void encontrarNumeros() {
        double anterior = 0;
        funcion.valorX(0);
        int i = 0, i2 = 0;
        if (Float.isInfinite(Float.parseFloat(funcion.getResultado()))) {
            i = 0;
            i2 = 1;
            funcion.valorX(Double.parseDouble(i + "." + i2));
        }
        if (Double.parseDouble(funcion.getResultado()) < 0) {
            while (Double.parseDouble(funcion.getResultado()) < 0) {
                anterior = Double.parseDouble(i + "." + i2);
                i2 += 1;
                if (i2 == 10) {
                    i += 1;
                    i2 = 0;
                }
                funcion.valorX(Double.parseDouble(i + "." + i2));
            }
            a = anterior;
            while (Double.parseDouble(funcion.getResultado()) <= 0) {
                i2 += 1;
                if (i2 == 10) {
                    i += 1;
                    i2 = 0;
                }
                funcion.valorX(Double.parseDouble(i + "." + i2));
            }
            b = Double.parseDouble(i + "." + i2);
            System.out.println(a);
            System.out.println(b);
        } else {
            while (Double.parseDouble(funcion.getResultado()) > 0) {
                anterior = Double.parseDouble(i + "." + i2);
                if (i2 == 0) {
                    i -= 1;
                    i2 = 9;
                } else
                    i2 -= 1;
                funcion.valorX(Double.parseDouble(i + "." + i2));
            }
            a = anterior;
            while (Double.parseDouble(funcion.getResultado()) >= 0) {
                if (i2 == 0 && i!=0) {
                    i -= 1;
                    i2 = 9;
                } else
                    i2 -= 1;
                funcion.valorX(Double.parseDouble(i + "." + i2));
            }
            b = Double.parseDouble(i + "." + i2);
            System.out.println(a);
            System.out.println(b);
        }
    }

    public static void main(String[] args) {
        FaltaPosicion f = new FaltaPosicion("x");
        f.encontrarNumeros();
    }
}
