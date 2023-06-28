/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete1;

import java.util.ArrayList;
import paquete2.*;

public class Ejecutor2 {

    public static void main(String[] args) {

        ArrayList<PasajeUrbano> pasajes = new ArrayList<>();
        String[] nombres = {"Austin", "Monique", "Glen", "Richard", "Patrick"};
        String[] apellidos = {"Martinez", "Lyons", "Kim", "Tate", "Lee"};
        int[] edad = {9, 70, 35, 23, 10};
        double pasajeFijo = 0.4;

        /*
        Generar un proceso que permita iterar los arreglos; el objetivo es 
        crear objetos de tipo Pasaje Menor de edad, Pasaje Normal, Pasaje 
        Universitario y Pasaje Tercera Edad. Los arreglos tienen una 
        característica, las posiciones se corresponden; por ejemplo, todas las 
        posiciones 0, crearán un objeto de cualquiera de los tipos nombrados de
        Pasajes.
        Cada objeto creado será agregado a la lista pasajes.
        
        ¿Cómo saber a que tipo de Pasaje pertenece cada objeto? Usar la edad 
        como discriminatoria.
        
        menor de edad: mayor o igual a 0 y menor o igual a 18
        universitario: mayor a 18 y menor o igual a 25
        normal: mayor a 25 y menor 65
        tercera edad: mayor o igual a 65
        
         */
        // inicio de solución
        for (int i = 0; i < nombres.length; i++) {

            String nombre = nombres[i];
            String apellido = apellidos[i];
            int edadPersona = edad[i];

            Persona p = new Persona(nombre, apellido, edadPersona);
            
            PasajeUrbano pa = null;
            
            if (edadPersona >= 0 && edadPersona <= 18) {

                pa = new PasajeMenorEdad(pasajeFijo);
                pa.establecerPersona(p);
                
            } else if (edadPersona > 18 && edadPersona <= 25) {

                pa = new PasajeUniversitario(pasajeFijo);
                pa.establecerPersona(p);
                
            } else if (edadPersona > 25 && edadPersona < 65) {

                pa = new PasajeNormal(pasajeFijo);
                pa.establecerPersona(p);
                
            } else if (edadPersona > 65) {

                pa = new PasajeTerceraEdad(pasajeFijo);
                pa.establecerPersona(p);
                
            }
            
            pasajes.add(pa);
        }

        // fin  de solución
        // no incrementar líneas de código desde aquí
        for (int i = 0; i < pasajes.size(); i++) {
            pasajes.get(i).establecerValorPasaje();
        }

        for (int i = 0; i < pasajes.size(); i++) {
            System.out.printf("%s\n",
                    pasajes.get(i));
        }

    }
}
