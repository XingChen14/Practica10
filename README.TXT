PROJECT TITLE: 
Práctica 10 Clases abstractas e interfaces

PURPOSE OF PROJECT: Implementar un programa orientado a objetos basado en un diseño con clases abstractas e interfaces para definir comportamientos comunes y contratos que faciliten la interoperabilidad de los componentes y el mantenimiento del software, con actitud analítica y reflexiva.

VERSION or DATE: Version 1 (23/10/2024)

HOW TO START THIS PROJECT:

AUTHORS: Ana Chen Zhang

DEFINITIONS:
Clase Abstracta: Una clase abstracta en programación orientada a objetos es una plantilla que define un conjunto de atributos y métodos que las clases derivadas deben implementar, pero que no puede ser instanciada por sí misma. 
                 Su propósito es proporcionar una base común para otras clases, permitiendo la creación de jerarquías de clases donde ciertas características y comportamientos son compartidos, mientras que los detalles específicos se definen en las subclases. 
                 Las clases abstractas pueden contener métodos abstractos (sin implementación) que obligan a las subclases a ofrecer su propia implementación, así como métodos concretos (con implementación) que pueden ser utilizados directamente o sobreescritos. Este enfoque promueve la reutilización de código y facilita el mantenimiento, al permitir que los cambios en la clase base se propaguen a todas las subclases.

Interface (interfaz): Una interfaz en programación orientada a objetos es un contrato que define un conjunto de métodos que una clase debe implementar, sin proporcionar ninguna implementación concreta para esos métodos. 
                      A diferencia de las clases, las interfaces no pueden contener atributos o métodos con implementación (en versiones anteriores a Java 8); su propósito principal es establecer una estructura que las clases concretas deben seguir, promoviendo la interoperabilidad y la flexibilidad del código. 
                      Las interfaces permiten que diferentes clases, incluso aquellas que no están relacionadas jerárquicamente, puedan ser tratadas de manera uniforme si implementan la misma interfaz.
                      Esto facilita la implementación de principios como la programación orientada a contratos y el polimorfismo, ya que permite a los desarrolladores crear código más modular y extensible.


USER INSTRUCTIONS:
Se requiere implementar el motor básico de un videojuego que contenga elementos de varios tipos: personajes, bombas y rocas; estos se pueden ubicar en un escenario. Algunos elementos podrán realizar acciones que modificarán el escenario bajo ciertas reglas.

Los requerimientos específicos son los siguientes:
R01- Se deberán poder ubicar elementos en el objeto escenario.
R02- La representación en cadena del Escenario (toString) deberá ser una matriz de caracteres de N x N con indicadores diferentes para cada tipo de Elemento, por ejemplo ver la Fig. 1
                    0 0 0 0 0 0 0 0 0 0
                    0 0 0 0 0 0 0 0 0 0
                    0 0 0 0 0 0 0 0 0 0
                    0 0 T 0 0 E 0 0 0 0
                    0 0 0 R B 0 0 0 0 0
                    0 0 0 0 0 0 0 0 0 0
                    0 0 0 0 0 0 0 0 0 0
                    0 0 0 0 0 0 0 0 0 0
                    0 0 0 0 0 0 0 0 0 0
                    0 0 0 0 0 0 0 0 0 0
Fig.1 Ejemplo de cadena que retorna Escenario.toString()
En la Fig. 1 se muestra un Escenario de 10 x 10 donde están ubicados un Terricola en la posición (3,2), un Extraterreste en la posición (3,5), una Roca en la posición (4,3) y una Bomba en la posición (4,4)

R03 - Cada objeto tipo Bomba tendrá un radio de alcance, el cual se le definirá cuando se cree el objeto (parámetro del constructor). Cuando se invoque el método explotar() de la Bomba, deberá avisarle al Escenario que destruya a los objetos destruibles en el radio de alcance invocando el método Escenario.destruirElementos().

En el ejemplo de la Fig. 1 si Bomba tiene un radio de alcance de 1, deberá destruir solo al Extraterrestre y a la Bomba misma. La salida esperada para este ejemplo  es la siguiente:
                    Explotando bomba!!
                    Alien destruido
                    Bomba destruida
Fig. 2 - Ejemplo de salida del método Bomba.explotar().

R04 - El método Escenario.destruirElementos() deberá crear un ArrayList con todos los objetos dentro del área de la explosión, después filtrar en el ArrayList los que implementan la interfaz Destruible para sobre de ellos ejecutar el método destruir() y desplegar en consola el resultado (ver Fig 2).

R05 - Utilizar la instrucción  instanceof  para determinar si un objeto es de un tipo particular. 
Por ejemplo, si se tiene un objeto p del tipo Extraterrestre:
            p instanceof Extraterrestre    // es verdadero por tipo directo
            p instanceof Personaje          // es verdadero por herencia
            p instanceof Destruible         // es verdadero por interface
            p instanceof Elemento         // es verdadero por herencia
            p instanceof Escenario        // es falso, nada que ver

R06 - El método main de MisionPosibleMain deberá ser el siguiente:
    public static void main(String[] args) {
    	Escenario e = new Escenario("Nostromo");
    	e.addElemento(new Terricola("Ripley", e,new Posicion(3,2)));
    	e.addElemento(new Extraterrestre("Alien", e,new Posicion(3,5)));
    	e.addElemento(new Roca(e, new Posicion(4,3)));
    	Bomba b = new Bomba(e, new Posicion(4,4),1);
    	e.addElemento(b);
    	System.out.println(e);
    	b.explotar();
	}
    //La salida del main es lo que se muestra en Fig. 1 y Fig. 2.

En el diagrama  3 se muestran las clases a implementar y sus relaciones.







ACTIVITIES:
    Implementar las clases del diagrama de la Fig. 3 que cumpla con los requerimientos definidos anteriormente.

    Versionar el código en un nuevo repositorio y subir el código a GitHub como practica10

    Si se entrega después de la hora límite, se tiene que realizar un video para explicar el funcionamiento del programa y que permita evaluar el nivel de conocimiento que tienen del código presentado.


DELIVERY:
    Entregar el enlace al repositorio de GitHub y 
    en caso de entrega tardía, entregar también el enlace al video explicando el funcionamiento.


EVALUATION CRITERIA
    Correcta implementación de las clases, atributos, constructores y métodos.
    Funcionalidad del programa.
    Estructura y organización del código.
    Legibilidad del código (indentación, nombrado de variables, comentarios y documentación).
    Uso adecuado de encapsulamiento, herencia y polimorfismo.

