/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorlexico;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Joosz
 */
public class AnalizadorLexico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Leo la cadena
        System.out.println("Escriba una cadena de texto con el siguiente formato (X1,Y1)texto1(X2,Y2)texto2(X3,Y3)texto3:");
        Scanner scanner = new Scanner(System. in);
	String cadena=scanner.nextLine();
        
        // Remplazo el caracater "(" por " (" para preparar la cadena para transformarla en una matriz
        cadena=cadena.replace("(", " ("); 
        // Arreglo estos posibles efectos secundarios:
        cadena=cadena.replace(") (", ")("); // ) (
        cadena=cadena.trim(); // espacio al inicio de la cadena    
        
        // Creo la matriz llenandola con las subcadenas que estan entre los espacios y la convierto en una lista
        String[] tokens = cadena.split("[ ]");
        List<String> list = Arrays.asList(tokens);
        
        // El patron que buscare en cada elemento de la matriz estara formado por:
        String patron="^("
        + "[(]{1}" // un abre parentesis
        + "-?[0-9]+" // uno o varios digitos
        + "[,]{1}" // una coma
        + "-?[0-9]+" // uno o varios digitos
        + "[)]{1}" // un cierre de parentesis
        + "[\\S]+" // y uno o varios caracteres
        + ")$";
        
//        Aqui se puede observar en que items de la lista se ecuentra el patron y en cuales no       
//        for(int i=0; i<list.size(); i++){
//            System.out.println(list.get(i)+" "+list.get(i).matches(patron));
//        }
        
//        System.out.println("");
        
        // Recorro la lista
        for(int i=0; i<list.size(); i++)
        {
            if(list.get(i).matches(patron)){ // Si el item de la lista hace match con el patron
                               
                if(i>0) // Si no esta en la 1ra iteracion imprimo el salto de linea
                    System.out.println(""); 
                
                // imprimo agregando un espacio despues del primer cierre de parentesis
                int indice = list.get(i).indexOf(")")+1;          
                System.out.print(list.get(i).substring(0, indice)+" "+list.get(i).substring(indice));
            }
            else // Si no, solo concateno el item
                System.out.print(list.get(i));
        }
        System.out.println(""); 
        
    }
}

/* Inputs de prueba

(79,34)Holaafklndfoi(10asldkfj)(98,902843)lnkjasdlnkfjas(34,56)Bingopingolingo
(56,44)aasdf(23,345)qwe(as(f)rqrf(99,01)ew454
(56,44))\|))aas"df(23,345)((56:'((qwe(as(f)rqrf(99,01)()e(:;@)(((w)))454        

*/
