PROJECT TITLE: 
Práctica #11 - Persistencia

PURPOSE OF PROJECT: Implementar programas con persistencia de datos para guardar el estado de los de los objetos mediante las operaciones de la lectura y escritura de archivos de texto, con actitud analítica y reflexiva.

VERSION or DATE: Version 1 (06/11/2024)

HOW TO START THIS PROJECT:

AUTHORS: Ana Chen Zhang

DEFINITIONS:
Persistencia: La persistencia de datos en el contexto de la programación orientada a objetos (POO) con Java se refiere a la capacidad de los objetos creados en un programa para seguir existiendo más allá de la duración de la ejecución del mismo. Esto se logra almacenando el estado de estos objetos en un medio externo, como un archivo de texto, de manera que puedan ser recuperados y reconstruidos en ejecuciones futuras del programa. Implementar la persistencia mediante archivos de texto en Java generalmente implica convertir los atributos de los objetos en cadenas de texto (serialización manual) y escribirlas en un archivo. Posteriormente, al leer el archivo, se procesan estas cadenas para reconstruir los objetos originales, asegurando que el programa pueda retomar su estado anterior de manera eficiente. Esta técnica es útil para aplicaciones simples o cuando no se necesita el uso de una base de datos completa para el almacenamiento de datos.

USER INSTRUCTIONS:
Modificar el código de la Práctica 10 para agregar un mecanismo de almacenamiento del Escenario.
Utilizar el siguiente formato para almacenar en un archivo de texto una configuración de objetos de un escenario. Cada línea de texto del archivo deberá tener el siguiente formato:
        <Elemento> <Renglon> <Columna> [parámetros adicionales]
Por ejemplo, para representar una Roca en la posición (3,4) un Extraterrestre en la posición (4,4) y una Bomba con radio de acción 1 en la posición (4,3), el archivo de configuración será de la siguiente forma:
        Roca 3 4
        Extraterrestre 4 4
        Bomba 4 3 1
El archivo de configuración inicial se podrá crear con un editor de texto sencillo (e.g. notepad)

REQUIREMENTS SPECIFICATION:
Modificar el programa MisionPosible para que cumpla con los siguientes requerimientos:
    R01. Que lea de archivo la configuración inicial de Elementos (Bombas, Extraterrestres, Terricolas, Rocas) y los agregue al Escenario.
    R02. Que despliegue el estado actual del Escenario  (matriz con ceros o letras en la ubicación de los elementos)
    R03. Que lea del teclado la instrucción de detonar alguna bomba en particular. 
    R04. Que despliegue de nuevo el estado actual del Escenario.
    R05. Que guarde la configuración actual de los Elementos en el mismo archivo de configuración.  


ACTIVITIES:
    Crear un branch llamado practica11 en su repositorio practica10.
    Implementar el código para cumplir con los requerimientos de la práctica. 
    Si se entrega después de la hora límite, se tiene que realizar un video para explicar el funcionamiento del programa y que permita evaluar el nivel de conocimiento que tienen del código presentado.
    Entregar por classroom la URL del repositorio de código en GitHub, y en caso de entrega tardía, entregar también el enlace al video explicando el funcionamiento.


DELIVERY:
    Entregar el enlace al repositorio de GitHub y 
    en caso de entrega tardía, entregar también el enlace al video explicando el funcionamiento.


EVALUATION CRITERIA
    Correcta implementación de las clases, atributos, constructores y métodos.
    Funcionalidad del programa.
    Estructura y organización del código.
    Legibilidad del código (indentación, nombrado de variables, comentarios y documentación).
    Uso adecuado de encapsulamiento, herencia y polimorfismo.

Sample code for manipulating text files:
// Método para escribir en un archivo de texto
public static void escribirConfiguracion(String nombreArchivo, List<String> configuracion) {
    BufferedWriter writer = null;
    try {
        writer = new BufferedWriter(new FileWriter(nombreArchivo));
        for (String linea : configuracion) {
            writer.write(linea);
            writer.newLine();
        }
        System.out.println("Configuración escrita en el archivo: " + nombreArchivo);
    } catch (IOException e) {
        System.err.println("Error al escribir en el archivo: " + e.getMessage());
    } finally {
        if (writer != null) {
            try {
                writer.close();
            } catch (IOException e) {
                System.err.println("Error al cerrar el archivo: " + e.getMessage());
            }
        }
    }
}

// Método para leer desde un archivo de texto
public static List<String> leerConfiguracion(String nombreArchivo) {
    List<String> configuracion = new ArrayList<>();
    BufferedReader reader = null;
    try {
        reader = new BufferedReader(new FileReader(nombreArchivo));
        String linea;
        while ((linea = reader.readLine()) != null) {
            configuracion.add(linea);
        }
        System.out.println("Configuración leída del archivo: " + nombreArchivo);
    } catch (IOException e) {
        System.err.println("Error al leer el archivo: " + e.getMessage());
    } finally {
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException e) {
                System.err.println("Error al cerrar el archivo: " + e.getMessage());
            }
        }
    }
    return configuracion;
}
