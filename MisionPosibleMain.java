import java.util.*;

public class MisionPosibleMain {
    public static void main(String[] args) {
    	Escenario e = new Escenario("Nostromo");
/*
    	e.addElemento(new Terricola("Ripley", e,new Posicion(3,2)));
    	e.addElemento(new Extraterrestre("Alien", e,new Posicion(3,5)));
    	e.addElemento(new Roca(e, new Posicion(4,3)));

    	Bomba b = new Bomba(e, new Posicion(4,4),1);
    	e.addElemento(b);
*/
		// Cargar la configuración inicial desde el archivo
        e.cargarArchivo("Practica10//escenarioInicial.txt");

    	// Mostrar el estado inicial del escenario
		System.out.print("Estado inicial del escenario:");
		System.out.println(e);

		try (
			// Leer del teclado la instrucción para detonar una bomba
			Scanner scanner = new Scanner(System.in)) {
			System.out.print("Ingrese la posición de la bomba a detonar (renglon columna): ");
			int renglon = scanner.nextInt();
			int columna = scanner.nextInt();

			// Buscar y detonar la bomba en la posición especificada
			for (Elemento elemento : e.getCampoDeBatalla()) {
			    if (elemento instanceof Bomba && elemento.getPosicion().getRenglon() == renglon && elemento.getPosicion().getColumna() == columna) {
			        ((Bomba) elemento).explotar();
			        break;
			    }
			}
		}
        // Mostrar el estado Final del escenario
		System.out.print("Estado Final del escenario:");
		System.out.println(e);

		// Guardar la configuración actual en el archivo
		e.guardarEnArchivo("Practica10//escenarioFinal.txt");
	}
}
