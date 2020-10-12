/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.util.Scanner;

/**
 *
 * @author Sebástian
 */
public class Biseccion {
    double a=0,b=0;
    private final Funcion funcion = new Funcion();
    
    public Biseccion(String funcion) {
        this.funcion.definirFuncion(funcion);
        this.funcion.valorX(1);
        while (this.funcion.getResultado().contains("error")) {
            System.out.print("La función no sirve weonaso. Digite otra:");
            this.funcion.definirFuncion(new Scanner(System.in).next());
        }
    }
       
    public static void raizEqu(){
        Funcion porno= new Funcion();
        porno.definirFuncion("x^(2)-43");
        porno.valorX(3);
         double num1=10.2,num2=30,aux;
         int  entero=(int)num1 ,decimal=(int)(num1%1)*10;
             if(num1>0 && num2>0){
                if(num1<=num2){
                 while(num1>0) {
                    num2=num1;
                    if(decimal==0){
                       decimal=9;
                       entero--;
                    } else{decimal--;}  
              
                    num1=Double.parseDouble(entero+"."+decimal);
               
              
                    System.out.println("num1  :"+num1+"    num2  :"+num2);                                      
            }
                 num1-=0.1;          
                 System.out.println("num1  :"+num1+"    num2  :"+num2);
            }else{
                  aux=num1;
                  num1=num2;
                  num2=aux;
                  while(num1>0) {
                    num2=num1;
                    if(decimal==0){
                       decimal=9;
                       entero--;
                    } else{decimal--;}  
              
                    num1=Double.parseDouble(entero+"."+decimal);
               
              
                    System.out.println("num1  :"+num1+"    num2  :"+num2);                                      
            }
                 num1-=0.1;          
                 System.out.println("num1  :"+num1+"    num2  :"+num2);
                }    
                
                }
        
        
    
}    
    
    
    
    
    
    
    public static void main(String[] args) {
        
        raizEqu();
        
        /* Funcion porno= new Funcion();
        porno.definirFuncion("x^(1/5)");
        porno.valorX(3);
        System.out.println(porno.getResultado());
        */
        /* double num1=10.2,num2=30,numero1;
        int  entero=(int)num1 ,decimal=(int)(num1%1)*10;
        if(num1>0 && num2>0){
            if(num1<=num2){
                while(num1>0) {
              num2=num1;
              if(decimal==0){
                  decimal=9;
                  entero--;
              } else{decimal--;}  
              
              num1=Double.parseDouble(entero+"."+decimal);
               
              
            System.out.println("num1  :"+num1+"    num2  :"+num2);
            
             
              
              
            }
                num1-=0.1;          
                System.out.println("num1  :"+num1+"    num2  :"+num2);
            }
           
            
                }
        */
    }
    
}
