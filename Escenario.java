import java.io.*;
import java.util.*;

public class Escenario {
    private String nombre;
    private int dimension = 10; // Definimos el tamaño del escenario como 10x10
    private ArrayList<Elemento> campoDeBatalla;

    public Escenario(String nombre){
        this.nombre = nombre;
        this.campoDeBatalla = new ArrayList<>();
    }

    public void addElemento(Elemento e){
        campoDeBatalla.add(e);
    }

    public void destruirElemento(Posicion p, int radio){
        int renglonBomba = p.getRenglon();
        int columnaBomba = p.getColumna();
        
        // Crear un iterator para poder eliminar elementos mientras iteramos
        Iterator<Elemento> it = campoDeBatalla.iterator();

        // Iterar sobre cada elemento en el campo de batalla
        while (it.hasNext()) {
            Elemento e = it.next();
            Posicion posicionElemento = e.getPosicion();
            
            // Calcular la distancia desde la bomba y verificar si está en el rango
            for (int i = -radio; i <= radio; i++) {
                for (int j = -radio; j <= radio; j++) {
                    // Verificar si la posición está dentro del rango y corresponde a la posición del elemento
                    if (posicionElemento.getRenglon() == renglonBomba + i && 
                        posicionElemento.getColumna() == columnaBomba + j) {
                        
                        if (e instanceof Destruible destruible) {
                            destruible.destruir(); // Destruir el elemento
                            //System.out.println("Elemento destruido: " + e.getClass().getSimpleName());
                            it.remove(); // Eliminar el elemento del campo de batalla
                        }
                    }
                }
            }
        }

    }

    // Representación en cadena del escenario
    @Override
    public String toString() {
        char[][] matriz = new char[dimension][dimension];

        // Llenar la matriz con '0'
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                matriz[i][j] = '0';
            }
        }

        // Colocar los elementos en la matriz
        for (Elemento e : campoDeBatalla) {
            Posicion p = e.getPosicion();
            matriz[p.getRenglon()][p.getColumna()] = e.getRepresentacion();
        }

        // Convertir la matriz a cadena de texto
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                sb.append(matriz[i][j]).append(" ");
            }
            sb.append("\n");
        }

        return "\nNombre Batalla: "+ nombre + "\n" +sb.toString();
    }

    // Método para cargar elementos desde un archivo
    public void cargarArchivo(String nameArchivo){
        try (Scanner scanner = new Scanner(new File(nameArchivo))){
            while(scanner.hasNextLine()){
                String[] linea = scanner.nextLine().split(" ");
                String tipo = linea[0];
                int renglon = Integer.parseInt(linea[1]);
                int columna = Integer.parseInt(linea[2]);
                Posicion posicion = new Posicion(renglon, columna);

                switch (tipo) {
                    case "Roca" -> addElemento(new Roca(this, posicion));
                    case "Extraterrestre" -> {
                        String nombreExtraterrestre = linea[3];
                        addElemento(new Extraterrestre(nombreExtraterrestre, this, posicion));
                    }
                    case "Bomba" -> {
                        int radio = Integer.parseInt(linea[3]);
                        addElemento(new Bomba(this, posicion, radio));
                    }
                    case "Terricola" -> {
                        String nombreTerricola = linea[3];
                        addElemento(new Terricola(nombreTerricola, this, posicion));
                    }
                    default -> throw new AssertionError();
                }
            } 
        }catch(FileNotFoundException e){
            System.out.println("Archivo no encontrado: " + nameArchivo);
        }
    }

    // Método para guardar la configuración actual en el archivo
    public void guardarEnArchivo(String nameArchivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nameArchivo))) {
            for (Elemento e : campoDeBatalla) {
                Posicion pos = e.getPosicion();
                if (e instanceof Roca) {
                    writer.printf("Roca %d %d%n", pos.getRenglon(), pos.getColumna());
                } else if (e instanceof Extraterrestre extraterrestre) {
                    writer.printf("Extraterrestre %d %d %s%n", pos.getRenglon(), pos.getColumna(), extraterrestre.toString());
                } else if (e instanceof Bomba bomba) {
                    writer.printf("Bomba %d %d %d%n", pos.getRenglon(), pos.getColumna(), bomba.getRadio());
                } else if (e instanceof Terricola terricola) {
                    writer.printf("Terricola %d %d %s%n", pos.getRenglon(), pos.getColumna(), terricola.toString());
                }
            }
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Elemento> getCampoDeBatalla() {
        return campoDeBatalla;
    }
    public void setCampoDeBatalla(ArrayList<Elemento> campoDeBatalla) {
        this.campoDeBatalla = campoDeBatalla;
    }

    public int getDimension() {
        return dimension;
    }
    public void setDimension(int dimension) {
        this.dimension = dimension;
    }


}
