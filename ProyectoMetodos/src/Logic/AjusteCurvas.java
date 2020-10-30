package Logic;

import java.util.ArrayList;
import java.util.Scanner;

public class AjusteCurvas {

    static ArrayList<double[]> tabla = new ArrayList<double[]>();
    static double[][] A, B;
    static Matriz m = new Matriz();
    Funcion ay = new Funcion();
    public AjusteCurvas() {
    }

    public void ingresarDatos(double x, double y) {
        tabla.add(new double[2]);
        tabla.get(tabla.size() - 1)[0] = x;
        tabla.get(tabla.size() - 1)[1] = y;
    }

    public static ArrayList<double[]> getTabla() {
        return tabla;
    }

    public int numDatos() {
        return tabla.size();
    }

    public double sumX(String funcion, int num) {
        Funcion f = new Funcion();
        double suma = 0;
        f.definirFuncion(funcion);
        for (int i = 0; i < numDatos(); i++) {
            f.valor(tabla.get(i)[num]);
            suma += Double.parseDouble(f.getResultado());
        }
        return suma;
    }

    public String sacarEcu(int x) {
        x++;
        A = new double[x][x];
        B = new double[x][1];
        int aux = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {

                if (i == 0) {
                    if (j == 0) {
                        A[0][0] = numDatos();
                    } else {
                        A[i][j] = sumX("x^" + (j), 0);
                    }
                } else {
                    A[i][j] = sumX("x^" + (j + aux), 0);

                }
                if (j == (x - 1)) {
                    aux += 1;
                }
            }

        }
        for (int i = 0; i < x; i++) {
            if (i == 0) {
                B[0][0] = sumX("x", 1);
            } else {
                B[i][0] = sumXY("x^" + i, "x", 0, 1);
            }

        }
        double[][] AI = m.matrizInversa(A);
        double[][] resul = m.multiplicarMatriz(AI, B);
        String ecuacion = " Y=";
        for (int i = (x - 1); i >= 0; i--) {
            if (i == 0) {
                ecuacion += resul[i][0];
            } else {
                ecuacion += resul[i][0] + " X^" + i + " + ";
            }
        }
        return ecuacion;
    }

    public double sumXY(String funcion, String funcion2, int num, int num2) {
        Funcion f = new Funcion();
        Funcion f2 = new Funcion();

        double suma = 0;
        f.definirFuncion(funcion);
        f2.definirFuncion(funcion2);
        for (int i = 0; i < numDatos(); i++) {
            f.valor(tabla.get(i)[num]);
            f2.valor(tabla.get(i)[num2]);
            suma += Double.parseDouble(f.getResultado()) * Double.parseDouble(f2.getResultado());
        }
        return suma;
    }

    public void borrarTabla() {
        tabla = null;
        tabla = new ArrayList<double[]>();
    }

    public String sacarEcuLog() {
        A = new double[2][2];
        B = new double[2][1];

        for (int i = 0; i < 2; i++) {

            for (int j = 0; j < 2; j++) {

                if (i == 0) {
                    if (j == 0) {
                        A[0][0] = numDatos();
                    } else {
                        A[i][j] = sumX("ln(x)", 0);
                    }
                } else {
                    A[i][j] = sumX("(ln(x))^" + (j + 1), 0);

                }

            }

        }

        B[0][0] = sumX("x", 1);
        B[1][0] = sumXY("ln(x)", "x", 0, 1);
        double[][] AI = m.matrizInversa(A);
        double[][] resul = m.multiplicarMatriz(AI, B);
        return " Y=" + resul[1][0] + "ln(x) + " + resul[0][0];

    }

    public String sacarEcuExp() {
        A = new double[2][2];
        B = new double[2][1];

        for (int i = 0; i < 2; i++) {

            for (int j = 0; j < 2; j++) {

                if (i == 0) {
                    if (j == 0) {
                        A[0][0] = numDatos();
                    } else {
                        A[i][j] = sumX("x", 0);
                    }
                } else {
                    A[i][j] = sumX("x^" + (j + 1), 0);

                }

            }

        }

        B[0][0] = sumX("ln(x)", 1);
        B[1][0] = sumXY("x", "ln(x)", 0, 1);
        double[][] AI = m.matrizInversa(A);
        double[][] resul = m.multiplicarMatriz(AI, B);
      
        ay.definirFuncion("e^x");
        ay.valor(resul[0][0]);
        return " Y=" + ay.getResultado() + "*e^(" + resul[1][0] + "*X)";

    }

    public String sacarEcuPot(){
        A = new double[2][2];
        B = new double[2][1];

        for (int i = 0; i < 2; i++) {

            for (int j = 0; j < 2; j++) {

                if (i == 0) {
                    if (j == 0) {
                        A[0][0] = numDatos();
                    } else {
                        A[i][j] = sumX("ln(x)", 0);
                    }
                } else {
                    A[i][j] = sumX("ln(x)^" + (j + 1), 0);

                }

            }

        }

        B[0][0] = sumX("ln(x)", 1);
        B[1][0] = sumXY("ln(x)", "ln(x)", 0, 1);
        double[][] AI = m.matrizInversa(A);
        double[][] resul = m.multiplicarMatriz(AI, B);
       
        ay.definirFuncion("e^x");
        ay.valor(resul[0][0]);
        return " Y= " + ay.getResultado() + "*x^(" + resul[1][0] + ")";

    }

}
