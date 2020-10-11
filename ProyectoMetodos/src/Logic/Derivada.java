package Logic;

import org.lsmp.djep.djep.DJep;
import org.nfunk.jep.ParseException;
import org.nfunk.jep.Node;

import java.util.Scanner;

public class Derivada {


    public static String derivar(String funcion){
        String derivada="";
        String respecto="x";

        DJep derivador= new DJep();

        derivador.addStandardFunctions();
        derivador.addStandardConstants();
        derivador.addComplex();
        derivador.setAllowUndeclared(true);
        derivador.setAllowAssignment(true);
        derivador.setImplicitMul(true);
        derivador.addStandardDiffRules();

        try {
            Node diff = derivador.parse(funcion);
             diff= derivador.differentiate(diff,respecto);
             diff= derivador.simplify(diff);
            derivada= derivador.toString(diff);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return derivada;
    }



}
