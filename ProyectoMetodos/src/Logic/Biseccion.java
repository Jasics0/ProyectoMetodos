/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

/**
 *
 * @author Sebástian
 */
public class Biseccion {
    private final Funcion funcion = new Funcion();
    public Biseccion(String funcion) {
        this.funcion.definirFuncion(funcion);
        this.funcion.valorX(1);
    }
    
    
    
    
    
    public static void main(String[] args) {
        
        double num=1.5;
        int num1=(int)num;
        int num2=(int) ((num%1)*10);
        for (int i = 0; i < 10; i++) {
           num2++;
           if(num2==10){
           num1++;
           num2=0;
           }
           
            System.out.println();
        }
    }
    
}
