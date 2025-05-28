package org.example

// Sin tipo de retorno explícito (dynamic return)
def saludar() {
    println '¡Hola desde Groovy!'
}

def sumar(a, b) {
    a + b    // el resultado de la última expresión se retorna
}

// Con tipo de retorno y parámetros tipados
def String concat(String a, String b) {
    return a + b
}

// Parámetros con valor por defecto
def multiplicar(int a = 2, int b = 2) {
    a * b
}

// Argumento indefinidos
def sumAll(int... nums) {
    nums.sum()
}

static void main(String[] args) {
    // llamada a función
    saludar()

    // llamada a función que devuelve un valor
    def ret = sumar(2,3)
    println(ret)

    def concatRet = concat("hola", " mundo!")
    println(concatRet)

    def multiRet = multiplicar(2, 2)
    println(multiRet)
    multiRet = multiplicar(2)
    println(multiRet)
    multiRet = multiplicar()
    println(multiRet)

    println "Suma varargs = ${sumAll(1,2,3,4)}"



}

