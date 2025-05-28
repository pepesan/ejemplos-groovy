package org.example


static void main(String[] args) {
    // Definición de una lista de enteros
    def numeros = [1, 2, 3, 4, 5]
    println numeros         // → [1, 2, 3, 4, 5]

    // Acceder a un elemento por índice
    println numeros[2]      // → 3

    // Añadir y eliminar elementos
    numeros << 6            // append
    println numeros         // → [1, 2, 3, 4, 5, 6]
    numeros.remove(0)       // elimina el primer elemento
    println numeros         // → [2, 3, 4, 5, 6]

    // Creación de un rango inclusivo
    def rango = 1..5
    println rango           // → 1..5
    println rango.toList()  // → [1, 2, 3, 4, 5]

    // Rango decremental
    def descendente = []
    5.downto(1) { i ->
        descendente << i
    }
    println descendente   // → [5, 4, 3, 2, 1]

    // Rango de caracteres
    def letras = 'a'..'e'
    println letras.toList() // → ['a','b','c','d','e']

    // Definición de un mapa
    def persona = [nombre: 'Ana', edad: 30, ciudad: 'Madrid']
    println persona                   // → [nombre:Ana, edad:30, ciudad:Madrid]

    // Acceso y modificación
    println persona['nombre']         // → Ana
    persona.edad = 31
    println persona                  // → [nombre:Ana, edad:31, ciudad:Madrid]

    // Iterar sobre entradas
    persona.each { clave, valor ->
        println "$clave: $valor"
    }

    // Definición de un set (no permite duplicados)
    def conjunto = [1,2,3,2,1] as Set
    println conjunto      // → [1, 2, 3]

    // Comprobación de pertenencia
    println 2 in conjunto // → true

    // Operaciones de teoría de conjuntos
    def a = [1,2,3] as Set
    def b = [2,3,4] as Set
    println a.intersect(b) // → [2,3]
    println a + b          // unión → [1,2,3,4]
    println a - b          // diferencia → [1]



    // Operaciones comunes: each, collect, findAll, find
    def lista = [1,2,3,4,5]

    // each: para efectos secundarios
    lista.each { println it }

    // collect: transforma cada elemento y devuelve una nueva lista
    def dobles = lista.collect { it * 2 }
    println dobles        // → [2,4,6,8,10]

    // findAll: filtra según la condición
    def pares = lista.findAll { it % 2 == 0 }
    println pares         // → [2,4]

    // find: devuelve el primer que cumpla
    def primerPar = lista.find { it % 2 == 0 }
    println primerPar     // → 2

    // Agregación con inject (reduce)
    def nums = [1,2,3,4,5]

    // Suma de todos
    def suma = nums.inject(0) { acc, val -> acc + val }
    println suma         // → 15

    // Producto de todos
    def producto = nums.inject(1) { acc, val -> acc * val }
    println producto    // → 120

    // Agrupación: groupBy
    def palabras = ['uno','dos','tres','cuatro','cinco']

    // Agrupar por longitud de palabra
    def porLongitud = palabras.groupBy { it.length() }
    println porLongitud
    // → [3:[uno,dos], 4:[tres,cinco], 6:[cuatro]]

    // Transformaciones anidadas y aplanado: collectNested y flatten
    def matriz = [[1,2], [3,4], [5,6]]

    // collectNested: aplica un closure a cada elemento de la sub-colección
    def masUno = matriz.collectNested { it + 1 }
    println masUno        // → [[2,3],[4,5],[6,7]]

    // flatten: aplana un nivel
    def aplanada = matriz.flatten()
    println aplanada      // → [1,2,3,4,5,6]

    // Ventanas móviles: collate (sliding windows)
    def datos = [1,2,3,4,5]

    // En grupos de 2, sin solapamiento
    def pares2 = datos.collate(2)
    println pares2        // → [[1,2],[3,4],[5]]

    // Ventana deslizante de tamaño 3 con salto 1
    def sliding = datos.collate(3, 1)
    println sliding       // → [[1,2,3],[2,3,4],[3,4,5]]

    // Map con valor por defecto: withDefault
    // Mapa que crea listas vacías al acceder claves nuevas
    def multiMap = [:].withDefault { [] }

    multiMap['frutas'] << 'manzana'
    multiMap['frutas'] << 'pera'
    multiMap['verduras'] << 'zanahoria'

    println multiMap
    // → [frutas:[manzana, pera], verduras:[zanahoria]]

    // Ordenación y estadística
    def notas = [7.5, 8.0, 6.0, 9.0, 5.5]

    // Ordenar ascendente y descendente
    println notas.sort()               // → [5.5,6.0,7.5,8.0,9.0]
    println notas.sort(false)         // → [9.0,8.0,7.5,6.0,5.5]

    // Mínimo, máximo y sumatoria
    println notas.min()                // → 5.5
    println notas.max()                // → 9.0
    println notas.sum()                // → 36.0

}

