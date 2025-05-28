package org.example

static void main(String[] args) {
    // If / Else
    def x = 2

    if (x > 0) {
        println "Positivo"
    } else if (x < 0) {
        println "Negativo"
    } else {
        println "Cero"
    }

    // Operador ternario
    def resultado = x >= 0 ? 'No negativo' : 'Negativo'
    println(resultado)

    // switch
    def diaSemana = 2
    switch (diaSemana) {
        case 1..5:
            println 'Día laborable'
            break
        case 6..7:
            println 'Fin de semana'
            break
        default:
            println 'Día inválido'
    }

    // For clásico
    for (int i = 0; i < 5; i++) {
        println i
    }

    // For in
    def lista = ['a','b','c']

    for (item in lista) {
        println item
    }

    // each / eachWithIndex
    lista.eachWithIndex { val, idx ->
        println "Índice $idx -> $val"
    }

    // While / Do-While
    def n = 3
    while (n > 0) {
        println n--
    }

    do {
        println "Se ejecuta al menos una vez"
    } while (false)
    

}

