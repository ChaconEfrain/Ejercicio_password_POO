/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio_password;

/**
 *
 * @author Dell
 */
public class Password {
    //Longitud por defecto del password
    private final static int LONGITUD_DEF = 8;
    
    //Atributos
    private int longitud;
    private String contraseña;
    
    //Métodos públicos
    
    //Devuelve la longitud de la contraseña
    public int getLongitud(){
        return longitud;
    }
    //Modifica la longitud de la contraseña
    public void setLongitud(int longitud){
        this.longitud = longitud;
    }
    //Devuelve la contraseña
    public String getContraseña(){
        return contraseña;
    }
    //Genera una contraseña al azar con la longitud definida
    public String generaPassword(){
        String password = "";
        for(int i = 0; i < longitud; i++){
            //Generamos un número aleatorio que elige si añadir una minúscula, mayúscula o número
            int eleccion = ((int)Math.floor(Math.random()*3+1));
            if(eleccion == 1){
                char minusculas = (char)((int)Math.floor(Math.random()*(123 - 97) + 97));
                password += minusculas;
            }else{
                if(eleccion == 2){
                    char mayusculas = (char)((int)Math.floor(Math.random()*(91 - 65) + 65));
                    password += mayusculas;
                }else{
                    char numeros = (char)((int)Math.floor(Math.random()*(58 - 48) + 48));
                    password += numeros;
                }
            }
        }
        return password;
    }
    //Comprueba la fortaleza de la contraseña
    public boolean esFuerte(){
        int contadorNumeros = 0;
        int contadorMinusculas = 0;
        int contadorMayusculas = 0;
        //Ciclo for para recorrer caracter por caracter
        for(int i = 0; i < contraseña.length(); i++){
            if(contraseña.charAt(i) >= 97 && contraseña.charAt(i) <= 122){
                contadorMinusculas += 1;
            }else{
                if(contraseña.charAt(i) >= 65 && contraseña.charAt(i) <= 90){
                    contadorMayusculas += 1;
                }else{
                    contadorNumeros += 1;
                }
            }
        }
        //Debe tener 5 o más números, 1 o más minúsculas y 2 o más mayúsculas
        if(contadorMinusculas >= 1 && contadorMayusculas >= 2 && contadorNumeros >= 5){
            return true;
        }else{
            return false;
        }
    }
    //Constructores
    public Password(){
        this(LONGITUD_DEF);
    }
    public Password(int longitud){
        this.longitud = longitud;
        contraseña = generaPassword();
    }
}
