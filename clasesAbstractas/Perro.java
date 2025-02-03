/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesAbstractas;

// Clase concreta que hereda de la clase abstracta
class Perro extends Animal {
    // Atributo adicional
    String raza;

    // Constructor
    public Perro(String nombre, int edad, String raza) {
        super(nombre, edad);
        this.raza = raza;
    }

    // Implementación del método abstracto
    @Override
    void hacerSonido() {
        System.out.println("Guau, guau");
    }

    // Método adicional con implementación concreta
    public void correr() {
        System.out.println("Estoy corriendo a toda velocidad");
    }
}

