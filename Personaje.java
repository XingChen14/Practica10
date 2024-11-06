public class Personaje {
    private String nombre;
    private int puntosDeVida;

    public Personaje(String nombre){
        this.nombre = nombre;
        puntosDeVida = 5;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntosDeVida() {
        return puntosDeVida;
    }
    public void setPuntosDeVida(int puntosDeVida) {
        this.puntosDeVida = puntosDeVida;
    }


}
