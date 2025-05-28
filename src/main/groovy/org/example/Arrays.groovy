package org.example

static void main(String[] args) {
    // Array de enteros (primitivo) con inferencia
    def arr1 = [1, 2, 3] as int[]
    assert arr1 instanceof int[]
    println(arr1)

    // Array de Integer (wrapper)
    Integer[] arr2 = [10, 20, 30]
    assert arr2 instanceof Integer[]
    println(arr2)

    // Array de Strings con la sintaxis Java
    String[] arr3 = new String[]{"a", "b", "c"}
    println(arr3)

    // Acceso a elementos y longitud
    def arr = [5, 6, 7, 8] as int[]
    println arr[0]        // → 5
    println arr[-1]       // → 8  (índice negativo accede desde el final)
    println arr.length    // → 4

    // Iteración sobre arrays
    def nombres = ["Ana", "Luis", "María"] as String[]

    // each
    nombres.each { println it }
    // → Ana
    //   Luis
    //   María

    // for clásico
    for (int i = 0; i < nombres.length; i++) {
        println "Índice $i → ${nombres[i]}"
    }

    // for-in
    for (nombre in nombres) {
        println nombre.toUpperCase()
    }

    // Arrays multidimensionales
    // Matriz 2×2 de int
    def matriz = [[1,2], [3,4]] as int[][]

    // Acceso
    println matriz[0][1]   // → 2

    // Recorrido
    matriz.eachWithIndex { fila, i ->
        fila.eachWithIndex { val, j ->
            println "matriz[$i][$j] = $val"
        }
    }

    // Spread operator y transformaciones
    def nums = [1,2,3,4] as Integer[]

    // Aplicar método a todos los elementos
    def strings = nums*.toString()
    assert strings == ["1","2","3","4"]

    // Mapear y filtrar
    def even = nums.findAll { it % 2 == 0 }
    assert even == [2,4] as Integer[]

    // Combinar arrays
    def more = nums + [5,6] as Integer[]
    assert more == [1,2,3,4,5,6] as Integer[]

    // Ranges y conversión lista↔array

    // Crear un rango y convertir a array
    def rango = (1..5)              // es un IntRange
    def arrRange = rango as int[]   // [1,2,3,4,5]
    println(arrRange)
    // De lista a array
    def lista = ['x','y','z']
    def arrFromList = lista.toArray(new String[0])
    assert arrFromList instanceof String[]
    println(arrFromList)
}

