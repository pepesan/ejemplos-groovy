package org.example

static void main(String[] args) {

    // String literal simple (comillas simples)
    // No permite interpolación ni escapes especiales (salvo \ y ').
    def s1 = 'Hola Mundo'
    assert s1 instanceof String
    println s1      // → Hola Mundo

    // GString (comillas dobles) con interpolación
    // Todas las expresiones ${…} se evalúan en tiempo de ejecución
    def nombre = 'Ana'
    def edad   = 30
    def s2 = "Me llamo $nombre y tengo ${edad + 1} años"
    println s2
    // → Me llamo Ana y tengo 31 años
    def s3 = """\
    Este es un texto
    multilínea en Groovy.
    Incluye salto de línea automáticamente.
    """
    println s3

    // Slashy String (comillas /…/)
    // Facilita escribir rutas Windows o regex sin escapar las barras
    def s4 = /La ruta es C:\Users\Ana\Documents/
    println s4
    // → La ruta es C:\Users\Ana\Documents

    // También admite expresiones de interpolación:
    def carpeta = 'Groovy'
    def s4b = /Proyecto: ${carpeta}/
    println s4b
    // → Proyecto: Groovy

    // Operaciones frecuentes sobre cadenas
    def texto = "Groovy"

    // Longitud
    println texto.size()        // → 6

    // Subcadena
    println texto[0..2]         // → Gro

    // Reverso
    println texto.reverse()     // → yvoorG

    // Reemplazo
    println texto.replace('o','0')   // → Gr00vy

    // División en lista
    def partes = "a,b,c".split(',')
    assert partes == ['a','b','c']
    println(partes)

}

