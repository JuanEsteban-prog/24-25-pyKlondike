import java.util.Random;

public class Baraja {
    private Carta[] cartas;
    private int tope;
    final int MAXIMO_DE_CARTAS = 52;

    public Baraja() {
        cartas = new Carta[MAXIMO_DE_CARTAS];
        tope = 0;
        inicializarBaraja();
        mezclar();
    }

    private void inicializarBaraja() {
        char[] palos = { '♥', '♦', '♣', '♠' };
        String[] valores = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
        for (int i = 0; i < palos.length; i++) {
            for (int j = 0; j < valores.length; j++) {
                cartas[tope] = new Carta(valores[j], palos[i], false);
                tope++;
            }
        }
    }

    private void mezclar() {
        Random rand = new Random();
        for (int i = 0; i < cartas.length; i++) {
            int indice = rand.nextInt(cartas.length);
            Carta temp = cartas[i];
            cartas[i] = cartas[indice];
            cartas[indice] = temp;
        }
    }

    public boolean estaVacia() {
        return tope == 0;
    }

    public Carta sacarCarta() {
        if (tope > 0) {
            tope--;
            return cartas[tope];
        }
        return null;
    }

    public Carta verCarta() {
        if (tope > 0) {
            return cartas[tope - 1];
        }
        return null;
    }
}
