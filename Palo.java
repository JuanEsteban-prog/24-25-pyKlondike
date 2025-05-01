public class Palo {
    private Carta[] cartas;
    private int cantidad;

    public Palo() {
        cartas = new Carta[13];
        cantidad = 0;
    }

    public void agregarCarta(Carta carta) {
        if (cantidad < 13) {
            cartas[cantidad] = carta;
            cantidad++;
        }
    }
}
