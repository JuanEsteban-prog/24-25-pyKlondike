import java.util.Scanner;

public class Juego {
    private Baraja baraja;
    private Descarte descarte;
    private Columna[] columnas;

    public Juego() {
        baraja = new Baraja();
        descarte = new Descarte();
        columnas = new Columna[7];
        for (int i = 0; i < 7; i++) {
            columnas[i] = new Columna();
        }
        repartirCartas();
    }

    private void repartirCartas() {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j <= i; j++) {
                Carta carta = baraja.sacarCarta();
                if (j == i && carta != null) {
                    carta.voltear();
                }
                columnas[i].agregarCarta(carta);
            }
        }
    }

    public void mostrarJuego() {
        System.out.println("\nEstado actual del juego:");
        for (int i = 0; i < columnas.length; i++) {
            System.out.println("Columna " + (i + 1) + ": " + columnas[i].mostrar());
        }
        System.out.print("Descarte: ");
        Carta cartaDescarte = descarte.verCarta();
        if (cartaDescarte != null) {
            System.out.println("[" + cartaDescarte.mostrar() + "]");
        } else {
            System.out.println("[ ]");
        }
    }

    public void sacarDeBaraja() {
        Carta carta = baraja.sacarCarta();
        if (carta != null) {
            descarte.agregarCarta(carta);
        }
    }

    public void iniciar() {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        while (opcion != 3) {
            mostrarJuego();
            System.out.println("\n1. Sacar carta de la baraja");
            System.out.println("2. Ver estado del juego");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();

            if (opcion == 1) {
                sacarDeBaraja();
            } else if (opcion == 2) {
                mostrarJuego();
            }
        }
        sc.close();
        System.out.println("Juego finalizado.");
    }
}
