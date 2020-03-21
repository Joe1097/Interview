/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capicuas;

import java.util.Scanner;
import java.lang.StringBuilder;

/**
 *
 * @author Joosz
 */
public class Capicuas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Declaracion de variables
        String resString1, resString2, numString2;     
        boolean esCapicua=false;
        int iteraciones=0;
        
        // Leyendo y almaceno el numero
        System.out.println("Escriba un número para ver si es capicua: ");
        Scanner scanner = new Scanner(System. in);
        String numString=scanner.nextLine();
            
        do{ // Se hace este ciclo 1 vez y mientras el resultado no sea capicua

            // Almaceno el numero al reves
            numString2=String.valueOf( (new StringBuilder()).append(numString).reverse() );

            // Sumo el numero al derecho y al reves
            long resultado=Long.parseLong(numString)+Long.parseLong(numString2);
            resString1=Long.toString(resultado);

            // Volteo el numero
            resString2=String.valueOf( (new StringBuilder()).append(resString1).reverse() ); 
        
            // Comparo el resultado al derecho y al reves
            esCapicua=(resString1.equals(resString2))?true:false;

            iteraciones++;
            
            numString=resString1; // Ahora el numero sera igual al resultado de la suma
            
        } while(!esCapicua);
        
        System.out.println(resString1+" "+iteraciones); // finalmemte imprimo el numero capicua resultante y el numero de iteraciones
        
    }
    
}