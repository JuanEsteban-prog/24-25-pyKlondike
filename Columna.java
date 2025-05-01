public class Columna {
    private Carta[] cartas;
    private int tope;

    public Columna() {
        cartas = new Carta[7];
        tope = 0;
    }

    public void agregarCarta(Carta cartasTope) {
        if (tope < cartas.length) {
            cartas[tope] = cartasTope;
            tope++;
        }
    }

    public String mostrar() {
        String resultado = "";
        for (int i = 0; i < tope; i++) {
            resultado += "[" + cartas[i].mostrar() + "] ";
        }
        return resultado;
    }
}
