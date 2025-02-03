/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesAbstractas;

// Definición de la clase abstracta
public abstract class Animal {
    // Atributos
    String nombre;
    int edad;

    // Constructor
    protected Animal(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Método concreto
    public void saludar() {
        System.out.println("Hola, soy un animal llamado " + nombre);
        
    }

    // Método abstracto (sin implementación)
    abstract void hacerSonido();
}

