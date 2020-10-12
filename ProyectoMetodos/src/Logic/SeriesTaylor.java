package Logic;

import java.util.Scanner;

public class SeriesTaylor {

    private final Funcion funcion = new Funcion();
    private final double x;

    public SeriesTaylor(String funcion, double x) {
        this.funcion.definirFuncion(funcion);
        this.x = x;
    }

    public double encontrarNumeroCercano() {
        int c = 0, c2 = 0;
        int i = (int) x, i2 = (int) ((x % 1) * 10);
        double a;
        if (x < 0) {
            a = funcion.distribuirSignos(i, -i2);
        } else {
            a = funcion.distribuirSignos(i, i2);
        }

        funcion.valorX(a);
        //Intenta de 0 hasta 1000
        while (((Math.abs(Double.parseDouble(funcion.getResultado()))) - (Math.abs(Math.floor(Double.parseDouble(funcion.getResultado()))))) % 1 != 0) {
            i2 += 1;
            if (i2 == 10) {
                i += 1;
                i2 = 0;
            }
            a = funcion.distribuirSignos(i, i2);
            funcion.valorX(a);
            c += 1;
            if (c >= 10000) {
                break;
            }
        }

        i = (int) x;
        i2 = (int) ((x % 1) * 10);
        double b=funcion.distribuirSignos(i,i2);
        funcion.valorX(b);
        //Intenta de 0 hasta -1000
        while (((Math.abs(Double.parseDouble(funcion.getResultado()))) - (Math.abs(Math.floor(Double.parseDouble(funcion.getResultado()))))) % 1 != 0) {
            if (i2 == -9) {
                i -= 1;
                i2 = 0;
            } else
                i2 -= 1;
            b = funcion.distribuirSignos(i, i2);
            funcion.valorX(b);
            c2 += 1;
            if (c2 >= 10000) {
                break;
            }
        }
        if (c == 10000 && c2 == 10000) {
            System.out.println("No se encontró número entero");
            return 0;
        } else if (c2 > c) {
            return a;
        } else {
            return b;
        }

    }

    public double serieDeTaylor() {
        double c = encontrarNumeroCercano();
        double fBack = 0;
        funcion.valorX(c);
        double fNext = Double.parseDouble(funcion.getResultado());
        int i = 0;
        while (Float.isNaN(Float.parseFloat(((fNext - fBack) / fNext) + "")) || (Math.round(Math.abs((fNext - fBack) / fNext) * 100)) != 0) {
            fBack = fNext;
            i += 1;
            funcion.derivar();
            fNext = (Double.parseDouble(funcion.getResultado()) / factorial(i)) * Math.pow((x - c), i) + fBack;
        }
        return fNext;
    }

    public int factorial(int i) {
        int factorial = 1;
        for (int j = 1; j <= i; j++) {
            factorial = j * factorial;
        }
        return factorial;
    }

    public static void main(String[] args) {
        SeriesTaylor st = new SeriesTaylor("sqrt(x)", 50);

        System.out.println(st.serieDeTaylor());
        //sebastianmariconfff
    }
}
