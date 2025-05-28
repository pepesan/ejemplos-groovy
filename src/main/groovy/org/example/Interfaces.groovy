package org.example

interface Volador { void volar() }
interface Nadador { void nadar() }

class Pato implements Volador, Nadador {
    void volar()  { println "El pato vuela" }
    void nadar()  { println "El pato nada" }
}


// Definición de dos traits
trait Volador2 {
    void volar() { println "${this.class.simpleName} alza el vuelo" }
}

trait Nadador2 {
    void nadar() { println "${this.class.simpleName} se echa al agua" }
}


// Clase que mezcla ambos traits
class Pato2 implements Volador2, Nadador2 {}

static void main(String[] args) {

    new Pato().with {
        volar()   // → El pato vuela
        nadar()   // → El pato nada
    }

    def p = new Pato2()
    p.volar()  // → Pato alza el vuelo
    p.nadar()  // → Pato se echa al agua

}

