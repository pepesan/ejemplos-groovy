package org.example

// Definición de la clase Cliente con un atributo público 'nombre'
class Cliente {
    String nombre
}

// Definición de la clase Cliente con constructor para el atributo 'nombre'
class Cliente2 {
    String nombre

    // Constructor que recibe el nombre
    Cliente2(String nombre) {
        this.nombre = nombre
    }
}

// Atributo privado y getters y setters

class Cliente3 {
    // Atributo privado
    private String email

    // Getter explícito
    String getEmail() {
        return email
    }

    // Setter explícito
    void setEmail(String email) {
        this.email = email
    }
}

// Atributo estático
class Cliente4 {
    // Atributo estático: pertenece a la clase, no a instancias
    static int contador = 0

    String nombre

    // Constructor que incrementa el contador estático
    Cliente4(String nombre) {
        this.nombre = nombre
        contador++
    }

    // Método de instancia para mostrar datos del cliente
    String mostrarInfo() {
        return "Cliente: $nombre"
    }
}


/**
 * Ejemplo de atributos con distintos modificadores de acceso.
 */
class ModificadorAtributos {
    // 1) Propiedad pública (getter/setter públicos)
    String publico = "público"

    // 2) Campo privado (sin getter/setter automáticos)
    private String privado = "privado"

    // 3) Propiedad protegida (getter/setter protegidos)
    protected String protegido = "protegido"

    // 4) Atributo estático público
    public static String estaticoPublico = "estático público"

    // 5) Atributo estático privado
    private static String estaticoPrivado = "estático privado"

    // 6) Constante pública
    public static final String CONSTANTE = "CONSTANTE"

    // 7) Propiedad final (inmutable tras inicialización)
    final String inmutable = "inmutable"

    // Método de instancia para mostrar valores desde la propia clase
    void mostrar() {
        println "=== Dentro de ModificadorAtributos.mostrar() ==="
        println "publico:         $publico"
        println "privado:         $privado"
        println "protegido:       $protegido"
        println "estaticoPublico: ${ModificadorAtributos.estaticoPublico}"
        println "estaticoPrivado: ${estaticoPrivado}"
        println "CONSTANTE:       ${ModificadorAtributos.CONSTANTE}"
        println "inmutable:       $inmutable"
    }
}

// Clase helper con métodos estáticos
class MathHelper {
    // Suma una cantidad arbitraria de enteros
    static int sumar(int... numeros) {
        numeros.sum()
    }

    // Devuelve el máximo de una lista de números
    static int maximo(int... numeros) {
        numeros.max()
    }

    // Comprueba si un número es par
    static boolean esPar(int n) {
        n % 2 == 0
    }

    // Formatea un número con separador de miles
    static String formatearConMiles(int n) {
        String.format("%,d", n)
    }
}

static void main(String[] args) {

    // Instanciamos Cliente
    def c = new Cliente()

    // Asignamos el nombre
    c.nombre = 'María López'

    // Mostramos por consola
    println "Cliente registrado: ${c.nombre}"

    // Instanciamos Cliente usando el constructor
    def c2 = new Cliente2("Carlos Ruiz")

    // Mostramos por consola el nombre asignado
    println "Cliente registrado: ${c2.nombre}"

    def c3 = new Cliente3()

    // Usamos el setter para asignar el email
    c3.setEmail("cliente@ejemplo.com")
    // También podríamos usar la sintaxis de propiedad:
    // c.email = "cliente@ejemplo.com"

    // Usamos el getter para leer el email
    println "Email del cliente (getter): ${c3.getEmail()}"
    // O con sintaxis de propiedad:
    // println "Email del cliente: ${c.email}"


    // uso de atributos estáticos
    // Antes de crear clientes
    println "Clientes creados hasta ahora: ${Cliente4.contador}"  // → 0

    // Creamos varias instancias
    def cUno = new Cliente4("Ana García")
    def cDos = new Cliente4("Luis Fernández")
    def cTres = new Cliente4("María Ruiz")

    // Cada nueva instancia ha incrementado el contador
    println cUno.mostrarInfo()                                    // → Cliente: Ana García
    println cDos.mostrarInfo()                                    // → Cliente: Luis Fernández
    println cTres.mostrarInfo()                                    // → Cliente: María Ruiz

    // Acceso al atributo estático desde la clase
    println "Total de clientes creados: ${Cliente4.contador}"    // → 3

    // También podríamos modificarlo directamente si fuera necesario
    Cliente4.contador = 10
    println "Contador ajustado manualmente: ${Cliente4.contador}"// → 10

    // Llamadas directas a los métodos estáticos sin instanciar MathHelper
    println "Suma de 1, 2, 3, 4: ${MathHelper.sumar(1, 2, 3, 4)}"           // → 10
    println "Máximo de 5, 8, 2, 9: ${MathHelper.maximo(5, 8, 2, 9)}"       // → 9
    println "¿Es 7 par? ${MathHelper.esPar(7)}"                             // → false
    println "¿Es 12 par? ${MathHelper.esPar(12)}"                           // → true
    println "Formatear 1234567: ${MathHelper.formatearConMiles(1234567)}"   // → 1.234.567 (en Locale por defecto)

    // acceso a atributos
    def obj = new ModificadorAtributos()
    obj.mostrar()

    println "\n=== Desde MainApp ==="
    println "publico:         ${obj.publico}"
    // println "privado:         ${obj.privado}"         // ❌ Error: privado no es accesible
    // println "protegido:       ${obj.protegido}"       // ❌ Error: protegido no es accesible
    println "por defecto:     ${obj.getPublico()}"     // equivalente a obj.publico
    println "estaticoPublico: ${ModificadorAtributos.estaticoPublico}"
    // println "estaticoPrivado: ${ModificadorAtributos.estaticoPrivado}" // ❌ Error
    println "CONSTANTE:       ${ModificadorAtributos.CONSTANTE}"
    println "inmutable:       ${obj.inmutable}"
}