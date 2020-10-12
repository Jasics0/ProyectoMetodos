package Logic;

import java.util.Scanner;

public class FalsaPosicion {

    private final Funcion funcion = new Funcion();
    private double xi = 0, xu = 0;

    public FalsaPosicion(String funcion) {
        this.funcion.definirFuncion(funcion);
    }


    public static void main(String[] args) {
        FalsaPosicion f = new FalsaPosicion("x");
    }
}
