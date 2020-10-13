package Logic;

public class Matriz {


    public double[][] matrizInversa(double[][] matriz) {
        double det = 1 / determinante(matriz);
        double[][] nmatriz = matrizAdjunta(matriz);
        multiplicarMatriz(det, nmatriz);
        return nmatriz;
    }

    public void multiplicarMatriz(double n, double[][] matriz) {
        for (int i = 0; i < matriz.length; i++)
            for (int j = 0; j < matriz.length; j++)
                matriz[i][j] *= n;
    }

    public double[][] matrizAdjunta(double[][] matriz) {
        double[][] matrizT = matrizTranspuesta(matriz);
        double[][] determinante = new double[matrizT.length - 1][matrizT.length - 1];
        double[][] matrizA = new double[matriz.length][matriz.length];
        int c = 0, c2 = 0;
        for (int i = 0; i < matrizT.length; i++) {

            for (int j = 0; j < matrizT.length; j++) {

                for (int k = 0; k < matrizT.length; k++) {

                    for (int l = 0; l < matrizT.length; l++) {
                        if (k != i && l != j) {
                            determinante[c][c2] = matrizT[k][l];
                            c2 += 1;
                            if (c2 == matrizT.length - 1) {
                                c2 = 0;
                                c += 1;
                            }
                        }
                    }
                }
                c = 0;
                c2 = 0;
                if (determinante.length != 1) {
                    if ((i + 1) % 2 != 0 && ((j + 1) % 2 != 0) || (i + 1) % 2 == 0 && ((j + 1) % 2 == 0))
                        matrizA[i][j] = determinante(determinante);
                    else
                        matrizA[i][j] = -determinante(determinante);
                } else {
                    if ((i + 1) % 2 != 0 && ((j + 1) % 2 != 0) || (i + 1) % 2 == 0 && ((j + 1) % 2 == 0))
                        matrizA[i][j] = determinante[0][0];
                    else
                        matrizA[i][j] = -determinante[0][0];
                }
            }
        }
        return matrizA;
    }

    public void imprimirMatriz(double[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void imprimirMatriz(double[] matriz){
        for (int i = 0; i < matriz.length; i++) {
            System.out.print(matriz[i]+" ");
        }
    }

    public double[][] matrizTranspuesta(double[][] matriz) {
        double[][] matrizT = new double[matriz.length][matriz.length];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++)
                matrizT[i][j] = matriz[j][i];
        }
        return matrizT;
    }

    public double determinante(double[][] matriz) {
        double det;
        if (matriz.length == 2) {
            det = (matriz[0][0] * matriz[1][1]) - (matriz[1][0] * matriz[0][1]);
            return det;
        }
        double suma = 0;
        for (int i = 0; i < matriz.length; i++) {
            double[][] nm = new double[matriz.length - 1][matriz.length - 1];
            for (int j = 0; j < matriz.length; j++) {
                if (j != i) {
                    for (int k = 1; k < matriz.length; k++) {
                        int indice = -1;
                        if (j < i)
                            indice = j;
                        else if (j > i)
                            indice = j - 1;
                        nm[indice][k - 1] = matriz[j][k];
                    }
                }
            }
            if (i % 2 == 0)
                suma += matriz[i][0] * determinante(nm);
            else
                suma -= matriz[i][0] * determinante(nm);
        }
        return suma;
    }

    public double[][] multiMatri(double[][] m, double[][] m2) {
        if (m[0].length == m2.length) {
            int a=m.length,b=m2[0].length;

            double[][] mMulti = new double[m.length][m2[0].length];
                    for (int i = 0; i < a; i++) {
                        for (int j = 0; j < b; j++) {
                            for (int k = 0; k < m2.length; k++) {
                                mMulti[i][j]=mMulti[i][j] +m[i][k]*m2[k][j];
                            }
                        }
                    }
                    //Acá va el resultado;
            return mMulti;
        } else {
            System.out.println("Esas matrices no se pueden multiplicar care verga.");
            return null;
        }
    }

}
