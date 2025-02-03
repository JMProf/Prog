/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesAbstractas;

public class Principal {
    public static void main(String[] args) {
        // No se puede instanciar directamente una clase abstracta
        // Animal animal = new Animal("AnimalAbstracto", 3); // Esto generaría un error

        // Se crea una instancia de la clase derivada Perro
        Perro miPerro = new Perro("Pluto", 2, "Labrador");
        
        // Se crea una instancia de la clase derivada Gato
        Gato miGato = new Gato("Silvestre", 3, "Gris");

        // Se accede a los atributos y métodos de la clase abstracta y la clase concreta
        System.out.println("Nombre del perro: " + miPerro.nombre);
        System.out.println("Edad del perro: " + miPerro.edad);
        miPerro.saludar();
        miPerro.hacerSonido();
        miPerro.correr();
        
        System.out.println("Nombre del gato: " + miGato.nombre);
        System.out.println("Edad del perro: " + miGato.edad);
        miGato.saludar();
        miGato.hacerSonido();
        miGato.jugar();
    }
}

