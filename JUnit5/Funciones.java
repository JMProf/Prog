import java.util.Scanner;


public class Funciones {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ejercicio 1: Número primo
        System.out.print("Introduzca un número: ");
        int numero = scanner.nextInt();
        if (esPrimo(numero))
            System.out.println("El número " + numero + " es primo");
        else System.out.println("El número " + numero + " NO es primo");

        // Ejercicio 2: Menú de opciones
        menu();

        // Ejercicio 3: Distancia entre dos puntos
        System.out.print("Coordenadas del punto 1: (x1 y1): ");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        System.out.print("Coordenadas del punto 1: (x2 y2): ");
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();
        
        double distancia = calcularDistancia(x1, y1, x2, y2);
        System.out.println("La distancia entre los dos puntos es: " + distancia);

        // Ejercicio 4: Convertir días, horas y minutos a segundos
        System.out.print("Días: ");
        int dias = scanner.nextInt();
        System.out.print("Horas: ");
        int horas = scanner.nextInt();
        System.out.print("Minutos: ");
        int minutos = scanner.nextInt();
        
        long segundos = pasarSegundos(dias, horas, minutos);
        System.out.println("La cantidad de segundos que hay en " + dias + " dias, " + horas + " horas y " + minutos + " minutos es: " + segundos);

        // Ejercicio 5: Diferencia de minutos entre dos instantes de tiempo
        System.out.print("Momento 1. Hora: ");
        int hora1 = scanner.nextInt();
        System.out.print("Momento 1. Minutos: ");
        int minuto1 = scanner.nextInt();
        System.out.print("Momento 2. Hora: ");
        int hora2 = scanner.nextInt();
        System.out.print("Momento 2. Minutos: ");
        int minuto2 = scanner.nextInt();
        
        int diferenciaMinutos = diferenciaMin(hora1, minuto1, hora2, minuto2);
        System.out.println("La diferencia en minutos entre los dos instantes es: " + diferenciaMinutos);
    }

    // Método para verificar si un número es primo
    static boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Método para mostrar un menú de opciones
    static void menu() {
        System.out.println("Menú de opciones:");
        System.out.println("1. Sumar ");
        System.out.println("2. Restar ");
        System.out.println("3. Multiplicar ");
        System.out.println("4. Dividir");
       
    }

    // Método para calcular la distancia entre dos puntos
    static double calcularDistancia(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    // Método para convertir días, horas y minutos a segundos
    static long pasarSegundos(int dias, int horas, int minutos) {
        return (dias * 24 * 60 * 60) + (horas * 60 * 60) + (minutos * 60);
    }

    // Método para calcular la diferencia en minutos entre dos instantes de tiempo
    static int diferenciaMin(int hora1, int minuto1, int hora2, int minuto2) {
        return Math.abs((hora1 * 60 + minuto1) - (hora2 * 60 + minuto2));
    }
}

