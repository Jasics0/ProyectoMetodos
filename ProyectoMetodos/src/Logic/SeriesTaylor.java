package Logic;

import java.util.Scanner;

public class SeriesTaylor {

    private final Funcion funcion = new Funcion();

    public SeriesTaylor(String funcion) {
        this.funcion.definirFuncion(funcion);
        this.funcion.valorX(1);

        while (this.funcion.getResultado().contains("error")) {
            System.out.print("La función no sirve weonaso. Digite otra:");
            this.funcion.definirFuncion(new Scanner(System.in).next());
        }
    }

    public double encontrarNumeroCercano(double x) {

        int i = (int)x, i2 = Integer.parseInt(((x%1)+"").charAt(2)+"");
        int c = 0, c2 = 0;
        double a = Double.parseDouble(i + "." + i2);
        funcion.valorX(a);
        //Intenta de 0 hasta 1000
        while (((Math.abs(Double.parseDouble(funcion.getResultado())))-(Math.abs(Math.floor(Double.parseDouble(funcion.getResultado())))))%1!=0) {
            i2 += 1;
            if (i2 == 10) {
                i += 1;
                i2 = 0;
            }
            a = Double.parseDouble(i + "." + i2);
            funcion.valorX(a);
            c += 1;
            if (c >= 10000) {
                break;
            }
        }

        i = (int)x;
        i2 = Integer.parseInt(((x%1)+"").charAt(2)+"");
        double b = Double.parseDouble(i + "." + i2);
        funcion.valorX(b);
       //Intenta de 0 hasta -1000
        while (((Math.abs(Double.parseDouble(funcion.getResultado())))-(Math.abs(Math.floor(Double.parseDouble(funcion.getResultado())))))%1!=0) {
            if (i2 == 0) {
                i -= 1;
                i2 = 9;
            }else
                i2 -= 1;

            b = Double.parseDouble(i + "." + i2);
            funcion.valorX(b);
            c2 += 1;
            if (c2 >= 10000) {
                break;
            }
        }
        if (c == 10000 && c2==10000) {
            System.out.println("No se encontró número entero");
            return 0;
        } else if (c2 > c) {
            return a;
        } else {
            return b;
        }

    }

    public static void main(String[] args) {
        SeriesTaylor s = new SeriesTaylor("tan(x)");
        System.out.println(s.encontrarNumeroCercano(2));

    }
    //xddddddddddddd
}
