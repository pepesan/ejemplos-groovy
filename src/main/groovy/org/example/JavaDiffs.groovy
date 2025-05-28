package org.example

// Groovy: importa automáticamente java.*, groovy.lang.*, groovy.util.*, etc.
class Example {
    void m(Object o) { println "Object" }
    void m(String s) { println "String" }
}

// Acceso a atributos y definición de listados
class Person {
    def numbers = [1,2,3]      // List<Integer>
    String name                // crea campo privado + getName()/setName()
}

// Groovy: sobrecarga de operadores
class Punto {
    int x, y
    Punto plus(Punto other) { new Punto(x: x+other.x, y: y+other.y) }
}

// nuevas palabras clave
trait Saluda {
    String saludar() { "Hola" }
}
class Persona implements Saluda {}


// Definimos la clase Direccion con una propiedad 'calle'
class Direccion {
    String calle
}

// Definimos la clase Persona con una propiedad 'direccion'
class Persona2 {
    Direccion direccion
}

static void main(String[] args) {
    println "Diferencias con Java"

    // importaciones
    Object x = "hola"
    def ex = new Example()
    ex.m(x)   // → "String" (dispatch dinámico en tiempo de ejecución)

    // getter y setter predefinidos
    def person = new Person()
    person.setName("hola")
    println person.getName()
    println(person.numbers)

    // Groovy: métodos con closure
    new File("datos.txt").eachLine { line ->
        println line
    }

    // o bien, con withReader
    new File("datos.txt").withReader { reader ->
        reader.eachLine { println it }
    }

    // Groovy: closures y GStrings
    def nums = [1,2,3]
    nums.each {Integer it -> println it }

    def nombre = "Ana"
    println "Hola $nombre"    // GString con interpolación

    // Groovy: literales nativos
    def lista = ["a", "b", "c"]
    println (lista)
    def mapa  = [clave:42, otro:100]
    println(mapa)

    // Groovy: '==' invoca equals(), 'is()' compara identidad
    def a = new Integer(1)
    def b = new Integer(1)
    assert a == b        // usa equals()
    assert !a.is(b)      // identidad distinta


    // Groovy: conversiones implícitas y keywords propias
    def d = 1           // d es int, pero usado como double si se asigna
    BigDecimal bd = 1   // se convierte automáticamente a BigDecimal

    // Palabras clave de Groovy
    def x2 = 42          // tipado dinámico
    String s = x2 as String

    def persona = new Persona()
    assert persona.saludar() == "Hola"

    // Caso 1: persona con dirección
    def personaConDireccion = new Persona2(
            direccion: new Direccion(calle: "Calle Falsa 123")
    )
    println "Calle de personaConDireccion: ${personaConDireccion?.direccion?.calle}"
    // → Calle de personaConDireccion: Calle Falsa 123

    def personaSinDireccion = new Persona2()
    println "Calle de personaSinDireccion: ${personaSinDireccion?.direccion?.calle}"
    // → Calle de personaSinDireccion: null

}

