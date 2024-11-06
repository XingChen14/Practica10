
public class Posicion {
    private int renglon;
    private int columna;

    public Posicion(int renglon, int columna){
        this.renglon = renglon;
        this.columna = columna;
    }

    public int getRenglon() {
        return renglon;
    }
    
    public int getColumna() {
        return columna;
    }

    public void setRenglon(int renglon) {
        this.renglon = renglon;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
}
