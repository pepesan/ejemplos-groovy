package org.example

// Definición de la clase abstracta
abstract class Animal2 {
    String nombre

    // Método abstracto: no tiene cuerpo, obliga a las subclases a implementarlo
    abstract void hacerSonido()

    // Método concreto: puede usarse tal cual o sobrescribirse
    void dormir() {
        println "$nombre está durmiendo"
    }
}

// Subclase que extiende de Animal e implementa hacerSonido()
class Perro2 extends Animal2 {
    @Override
    void hacerSonido() {
        println "$nombre: ¡Guau guau!"
    }
}

static void main(String[] args) {
    def perro = new Perro2(nombre: 'Rex')
    perro.hacerSonido()   // → Rex: ¡Guau guau!
    perro.dormir()        // → Rex está durmiendo
}

