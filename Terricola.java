public class Terricola extends Elemento {
    private String nombre;

    public Terricola(String nombre, Escenario e, Posicion p) {
        super(e, p);
        this.nombre = nombre;
    }

    @Override
    public char getRepresentacion() {
        return 'T';
    }

    @Override
    public String toString() {
        return nombre;
    }
}

