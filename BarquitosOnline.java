import java.util.Scanner;
import java.io.*;
import java.net.*;

public class BarquitosOnline {

    private Socket rival;
    private ServerSocket jugador;
    private DataOutputStream flujoSalida;
    private DataInputStream flujoEntrada;
    private int puerto;
    private Scanner sc = new Scanner(System.in);

    /**
     * Constructor de la clase BarquitosOnline. Crea una partida online
     */
    public BarquitosOnline(){
        try{
            int opcion = 0;
            puerto = 6000;
            do {
                System.out.println("¿Eres el servidor? \n 1. Sí \n 2. No");
                opcion = sc.nextInt();
                sc.nextLine();
                switch (opcion) {
                    case 1:
                        esperarConexion();
                        break;
                    case 2:
                        conectar();
                        break;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }
            } while(opcion != 1 && opcion != 2);

        }catch(Exception e){
            System.out.println("Error al conectar con el rival");
        }
    }

    /**
     * Método para conectar con el rival introduciendo su IP.
     */
    private void conectar(){
        try{
            System.out.println("Introduce la IP del rival");
            String ipRival = sc.nextLine();
            System.out.println("Conectando con el rival...");
            rival = new Socket(ipRival, puerto);
            flujoSalida = new DataOutputStream(rival.getOutputStream());
            flujoEntrada = new DataInputStream(rival.getInputStream());
            System.out.println("Conexión establecida");
        }catch(Exception e){
            e.printStackTrace();


            System.out.println("Error al conectar con el rival");
        }
    }

    /**
     * Método para actuar como servidor y esperar la conexión del rival.
     */
    private void esperarConexion(){
        try{
            System.out.println("Esperando conexión...");
            jugador = new ServerSocket(puerto);
            rival = jugador.accept();
            flujoSalida = new DataOutputStream(rival.getOutputStream());
            flujoEntrada = new DataInputStream(rival.getInputStream());
            System.out.println("Conexión establecida");
        }catch(Exception e){
            System.out.println("Error al conectar con el rival");
        }
    }

    /**
     * Método para enviar un disparo al rival.
     * @param x Coordenada x del disparo.
     * @param y Coordenada y del disparo.
     */
    public String enviardisparo(int x, int y){
        try{
            flujoSalida.writeInt(x);
            flujoSalida.writeInt(y);

            // Respuesta del rival
            return flujoEntrada.readUTF();
        }catch(Exception e){
            System.out.println("Error al enviar disparo");
            return "";
        }

    }

    /**
     * Método para recibir un disparo del rival.
     * @return Array con las coordenadas del disparo.
     */
    public int[] recibirDisparo(){
        try{
            int x = flujoEntrada.readInt();
            int y = flujoEntrada.readInt();
            return new int[]{x, y};
        }catch(Exception e){
            System.out.println("Error al recibir disparo");
            return null;
        }
    }

    public void tocado(){
        try{
            flujoSalida.writeUTF("Tocado");
        }catch(Exception e){
            System.out.println("Error al enviar tocado");
        }
    }
    
    public void hundido(){
        try{
            flujoSalida.writeUTF("Hundido");
        }catch(Exception e){
            System.out.println("Error al enviar hundido");
        }
    }
    
    public void agua(){
        try{
            flujoSalida.writeUTF("Agua");
        }catch(Exception e){
            System.out.println("Error al enviar agua");
        }
    }

    /**
     * Método para terminar la partida.
     */
    public void terminarPartida(){
        try{
            flujoSalida.close();
            flujoEntrada.close();
            rival.close();
            jugador.close();
        }catch(Exception e){
            System.out.println("Error al cerrar la conexión");
        }
    }
}
