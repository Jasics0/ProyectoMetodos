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
        double x=1,y=2;
        Funcion porno= new Funcion();
        porno.definirFuncion("x^(3)-64");
        porno.valorX(x);
        Funcion porno2= new Funcion();
        porno2.definirFuncion("x^(3)-64");
        porno2.valorX(y);
         double aux;
         int  entero=(int)x ,decimal=(int)(x%1)*10;
         double parce=Double.parseDouble(entero+"."+decimal);
             if(Double.parseDouble(porno.getResultado())>0 && Double.parseDouble(porno2.getResultado())>0){
                if(Double.parseDouble(porno.getResultado())<=Double.parseDouble(porno2.getResultado())){
                 while(Double.parseDouble(porno.getResultado())>0) {
                    y=x;
                    
                    if(x>=0.1){
                    if(decimal==0){
                       decimal=9;
                       entero--;
                       x=Double.parseDouble(entero+"."+decimal);
                    } else{decimal--;
                    x=Double.parseDouble(entero+"."+decimal);} 
                    }else{
                    if(x==0.0){
                        decimal=1;
                        entero=0;
                        x=(Double.parseDouble(entero+"."+decimal))*-1;
                    }else{if(decimal==10){
                    decimal=0;
                    entero++;
                     x=(Double.parseDouble(entero+"."+decimal))*-1;
                    }else{decimal++;
                    x=(Double.parseDouble(entero+"."+decimal))*-1;}}} 
              ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                    
               porno.valorX(x);
               porno2.valorX(y);
              
                  System.out.println("num1  :??"+x+"??  "+Double.parseDouble(porno.getResultado())+"    num2  :??"+y+"??   "+Double.parseDouble(porno2.getResultado()));                                     
            }
                 x-=0.1;          
                  System.out.println("num1  :??"+x+"??  "+Double.parseDouble(porno.getResultado())+"    num2  :??"+y+"??   "+Double.parseDouble(porno2.getResultado()));
                porno.valorX(x);
                porno2.valorX(y);
                }else{
                  aux=x;
                  x=y;
                  y=aux;
                   porno.valorX(x);
                porno2.valorX(y);
                  while(Double.parseDouble(porno.getResultado())>0) {
                    y=x;
                    
                    if(x>=0.1){
                    if(decimal==0){
                       decimal=9;
                       entero--;
                       x=Double.parseDouble(entero+"."+decimal);
                    } else{decimal--;
                    x=Double.parseDouble(entero+"."+decimal);} 
                    }else{
                    if(x==0.0){
                        decimal=1;
                        entero=0;
                        x=(Double.parseDouble(entero+"."+decimal))*-1;
                    }else{if(decimal==10){
                    decimal=0;
                    entero++;
                     x=(Double.parseDouble(entero+"."+decimal))*-1;
                    }else{decimal++;
                    x=(Double.parseDouble(entero+"."+decimal))*-1;}}} 
              ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                    
               porno.valorX(x);
               porno2.valorX(y);
              
                  System.out.println("num1  :??"+x+"??  "+Double.parseDouble(porno.getResultado())+"    num2  :??"+y+"??   "+Double.parseDouble(porno2.getResultado()));                                     
            }
                 x-=0.1;          
                  System.out.println("num1  :??"+x+"??  "+Double.parseDouble(porno.getResultado())+"    num2  :??"+y+"??   "+Double.parseDouble(porno2.getResultado()));
                porno.valorX(x);
                porno2.valorX(y);
                
                }    
                
                }if(Double.parseDouble(porno.getResultado())<0 && Double.parseDouble(porno2.getResultado())<0){
                 if(Double.parseDouble(porno.getResultado())<=Double.parseDouble(porno2.getResultado())){
                 while(Double.parseDouble(porno.getResultado())>0) {
                    y=x;
                    
                    if(x>=0.1){
                    if(decimal==0){
                       decimal=9;
                       entero--;
                       x=Double.parseDouble(entero+"."+decimal);
                    } else{decimal--;
                    x=Double.parseDouble(entero+"."+decimal);} 
                    }else{
                    if(x==0.0){
                        decimal=1;
                        entero=0;
                        x=(Double.parseDouble(entero+"."+decimal))*-1;
                    }else{if(decimal==10){
                    decimal=0;
                    entero++;
                     x=(Double.parseDouble(entero+"."+decimal))*-1;
                    }else{decimal++;
                    x=(Double.parseDouble(entero+"."+decimal))*-1;}}} 
              ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                    
               porno.valorX(x);
               porno2.valorX(y);
              
                  System.out.println("num1  :??"+x+"??  "+Double.parseDouble(porno.getResultado())+"    num2  :??"+y+"??   "+Double.parseDouble(porno2.getResultado()));                                     
            }
                 x-=0.1;          
                  System.out.println("num1  :??"+x+"??  "+Double.parseDouble(porno.getResultado())+"    num2  :??"+y+"??   "+Double.parseDouble(porno2.getResultado()));
                porno.valorX(x);
                porno2.valorX(y);
                }else{
                  aux=x;
                  x=y;
                  y=aux;
                   porno.valorX(x);
                porno2.valorX(y);
                  while(Double.parseDouble(porno.getResultado())>0) {
                    y=x;
                    
                    if(x>=0.1){
                    if(decimal==0){
                       decimal=9;
                       entero--;
                       x=Double.parseDouble(entero+"."+decimal);
                    } else{decimal--;
                    x=Double.parseDouble(entero+"."+decimal);} 
                    }else{
                    if(x==0.0){
                        decimal=1;
                        entero=0;
                        x=(Double.parseDouble(entero+"."+decimal))*-1;
                    }else{if(decimal==10){
                    decimal=0;
                    entero++;
                     x=(Double.parseDouble(entero+"."+decimal))*-1;
                    }else{decimal++;
                    x=(Double.parseDouble(entero+"."+decimal))*-1;}}} 
              ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                    
               porno.valorX(x);
               porno2.valorX(y);
              
                  System.out.println("num1  :??"+x+"??  "+Double.parseDouble(porno.getResultado())+"    num2  :??"+y+"??   "+Double.parseDouble(porno2.getResultado()));                                     
            }
                 x-=0.1;          
                  System.out.println("num1  :??"+x+"??  "+Double.parseDouble(porno.getResultado())+"    num2  :??"+y+"??   "+Double.parseDouble(porno2.getResultado()));
                porno.valorX(x);
                porno2.valorX(y);
                
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
