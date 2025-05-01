public class Carta {
    private String valor;
    private char palo;
    private boolean visible;

    public Carta(String valor, char palo, boolean visible) {
        this.valor = valor;
        this.palo = palo;
        this.visible = visible;
    }

    public void voltear() {
        visible = !visible;
    }

    public String mostrar() {
        return visible ? valor + palo : "??";
    }
}
