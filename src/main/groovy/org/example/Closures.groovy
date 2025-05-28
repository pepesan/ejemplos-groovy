package org.example

void ejecutarTresVeces(Closure c) {
    3.times { c(it) }
}

static void main(String[] args) {
    // Definición de un closure que imprime un mensaje
    def saludo = { println "¡Hola, Mundo!" }

    // Llamada al closure
    saludo()
    saludo.call()

    // Closure que recibe un parámetro
    def doble = { int x -> x * 2 }

    // Parámetro tipado
    println doble(5)    // → 10
    println doble.call(7) // → 14

    // Uso de it para un único parámetro

    // Cuando sólo hay un parámetro, Groovy lo asigna a 'it'
    def cuadrado = { it * it }

    println cuadrado(4)  // → 16

    // Procesamiento de colecciones
    def nums = [1, 2, 3, 4, 5]

    // .each{} para iterar
    nums.each { println it }

    // .findAll{} filtra por la condición
    def pares = nums.findAll { it % 2 == 0 }
    println pares  // → [2, 4]

    // collect (map) transforma cada elemento
    def dobles = nums.collect { it * 2 }
    println dobles // → [2, 4, 6, 8, 10]

    // Closure como parámetro de método

    // Pasamos un closure que imprime el índice
    ejecutarTresVeces { idx -> println "Iteración $idx" }

    // Currying (parcial aplicación)
    // .curry(val) fija el primer parámetro y devuelve un nuevo closure
    def sumar = { int a, int b -> a + b }

    // Curryando el primer parámetro
    def sumarCinco = sumar.curry(5)

    println sumarCinco(10)  // → 15

    // Memoización (cacheo de resultados)
    // .memoize() guarda los resultados previos para evitar recomputar

    def fibo
    fibo = { int n ->
        if (n < 2) n
        else fibo(n-1) + fibo(n-2)
    }.memoize()

    println fibo(40)  // Se calcula mucho más rápido gracias al cache

    // Trampoline para recursión sin desbordar pila
    // .trampoline() convierte la recursión en bucle interno

    // Closure recursivo con trampoline
    def factorial
    factorial = { int n, BigInteger acc = 1 ->
        if (n < 2) acc
        else factorial.trampoline(n-1, acc * n)
    }.trampoline()

    println factorial(10)
    println factorial(10000) // No causa StackOverflowError

    // Composición de closures

    def doblar = { it * 2 }
    def luegoSumaTres = { it + 3 }

    // first >> then: primero aplico 'doblar', luego 'luegoSumaTres'
    def compuesto = doblar >> luegoSumaTres

    println compuesto(5)  // → (5*2)+3 = 13

    // También se puede hacer al revés:
    def compuesto2 = luegoSumaTres << doblar
    println compuesto2(5) // → igual, 13
}

