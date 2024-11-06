public class Extraterrestre extends Elemento implements Destruible {
    private String nombre;

    public Extraterrestre(String nombre, Escenario escenario, Posicion posicion) {
        super(escenario, posicion);
        this.nombre = nombre;
    }

    @Override
    public char getRepresentacion() {
        return 'E';
    }

    @Override
    public void destruir() {
        System.out.println(nombre + " destruido");
    }

    @Override
    public String toString() {
        return nombre;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
