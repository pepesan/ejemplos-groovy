package org.example

static void main(String[] args) {

    def mensaje = "Hola Mundo"    // String
    println(mensaje)
    def numero = 42                // Integer (auto-boxing)
    println(numero)
    def decimal = 3.14             // BigDecimal
    println(decimal)
    def flag = true                // Boolean
    println(flag)
    def lista = [1, 2, 3]          // List<Integer>
    println(lista)

    String nombre = 'Ana'
    println(nombre)
    Integer edad = 30
    println(edad)
    BigDecimal precio = 19.95
    println(precio)
    Boolean activo = false
    println(activo)

    // Uso de def: declara variable sin tipo explícito
    def saludo = "¡Bienvenido!"
    saludo = saludo.toUpperCase()
    println(saludo)

    // Inferencia automática: Groovy deduce el tipo:
    def x = 100        // x es Integer
    def y = x / 2      // y es BigDecimal (división precisa)
    println(y)

    // Declaración con tipo
    String ciudad = 'Madrid'
    int habitantes = 3223000    // se usa primitivo si no aplica boxing

    // Constantes con final
    final PI = 3.1416
    // PI = 2     // error: cannot reasignar constante
}

