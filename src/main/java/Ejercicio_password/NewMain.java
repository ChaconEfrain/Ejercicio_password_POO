/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio_password;

import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        //Crear un array de passwords con el tamaño que se le indique por teclado
        System.out.println("Ingrese la cantidad de passwords a generar:");
        int passwords = lector.nextInt();
        System.out.println("Ingrese la longitud de los passwords a generar:");
        int longitudPasswords = lector.nextInt();
        Password pass[] = new Password[passwords];
        boolean fortalezaPassword[] = new boolean[passwords];
        
        //Crear un bucle que cree un objeto para cada posición del array
        for(int i = 0; i < pass.length; i++){
            pass[i] = new Password(longitudPasswords);
            fortalezaPassword[i] = pass[i].esFuerte();
            System.out.println(pass[i].getContraseña() + " " + fortalezaPassword[i]);
        }
    }
    
}
