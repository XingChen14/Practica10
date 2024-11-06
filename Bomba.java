public class Bomba extends Elemento implements Destruible {
    private int radio;

    public Bomba(Escenario e, Posicion p, int radio){
        super(e, p);
        this.radio = radio;
    }

    public int getRadio(){
        return radio;
    }
    public void setRadio(int radio) {
        this.radio = radio;
    }

    @Override
    public char getRepresentacion() {
        return 'B';
    }

    public void explotar(){
        System.out.println("Explotando bomba!!");
        escenario.destruirElemento(this.posicion, radio);
    }

    @Override
    public void destruir() {
        System.out.println("Bomba destruida");
    }
}
