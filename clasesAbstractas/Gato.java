/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesAbstractas;

public class Gato extends Animal {
    // Atributo adicional
    String colorPelaje;

    // Constructor
    public Gato(String nombre, int edad, String colorPelaje) {
        super(nombre, edad);
        this.colorPelaje = colorPelaje;
    }

    // Implementación del método abstracto
    @Override
    void hacerSonido() {
        System.out.println("Miau, miau");
    }

    // Método adicional con implementación concreta
    public void jugar() {
        System.out.println("El gato está jugando con sus juguetes");
    }
}

