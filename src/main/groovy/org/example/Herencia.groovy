package org.example

// Clase base Animal
class Animal {
    String nombre

    void hacerSonido() {
        println "${nombre}: Sonido genérico de animal"
    }
}

// Subclase Perro que hereda de Animal
class Perro extends Animal {
    @Override
    void hacerSonido() {
        println "${nombre}: ¡Guau guau!"
    }
}

// Clase base Vehiculo con atributo 'matricula' y constructor
class Vehiculo {
    String matricula

    // Constructor que inicializa la matrícula
    Vehiculo(String matricula) {
        this.matricula = matricula
    }

    // Método para mostrar información del vehículo
    String mostrarInfo() {
        return "Vehículo con matrícula: $matricula"
    }
}

// Subclase Coche que hereda de Vehiculo, con atributo 'ruedas' inicializado
class Coche extends Vehiculo {
    int ruedas = 4

    // Constructor que recibe matrícula y delega a Vehiculo
    Coche(String matricula) {
        super(matricula)
    }

    // Sobrescribe mostrarInfo para incluir las ruedas
    @Override
    String mostrarInfo() {
        return "Coche con matrícula: $matricula y $ruedas ruedas"
    }
}

// Clase base Ordenador con atributos cpu y memoria, y constructor con valores por defecto
class Ordenador {
    String cpu
    int memoria  // en GB

    // Constructor con valores por defecto
    Ordenador(String cpu = 'Intel Core i5', int memoria = 8) {
        this.cpu = cpu
        this.memoria = memoria
    }

    // Método para mostrar información del ordenador
    String info() {
        return "Ordenador: CPU=$cpu, Memoria=${memoria}GB"
    }
}

// Subclase Portatil que añade el atributo bateria, también con valor por defecto
class Portatil extends Ordenador {
    int bateria  // en porcentaje

    // Constructor con valores por defecto para cpu, memoria y batería
    Portatil(String cpu = 'Intel Core i5', int memoria = 8, int bateria = 50) {
        super(cpu, memoria)
        this.bateria = bateria
    }

    // Sobrescribimos info() para incluir la batería
    @Override
    String info() {
        return "Portátil: CPU=$cpu, Memoria=${memoria}GB, Batería=${bateria}%"
    }
}

static void main(String[] args) {
    // Instanciamos un Animal genérico
    def animal = new Animal()
    animal.nombre = 'AnimalGenérico'
    animal.hacerSonido()    // → AnimalGenérico: Sonido genérico de animal

    // Instanciamos un Perro
    def perro = new Perro()
    perro.nombre = 'Rex'
    perro.hacerSonido()     // → Rex: ¡Guau guau!

    // Creamos un Vehiculo genérico
    def v = new Vehiculo("ABC-123")
    println v.mostrarInfo()   // → Vehículo con matrícula: ABC-123

    // Creamos un Coche
    def c = new Coche("XYZ-789")
    println c.mostrarInfo()   // → Coche con matrícula: XYZ-789 y 4 ruedas

    // Instancia de Ordenador con valores por defecto
    def o1 = new Ordenador()
    println o1.info()
    // → Ordenador: CPU=Intel Core i5, Memoria=8GB

    // Instancia de Ordenador con valores personalizados
    def o2 = new Ordenador('AMD Ryzen 7', 16)
    println o2.info()
    // → Ordenador: CPU=AMD Ryzen 7, Memoria=16GB

    // Instancia de Portatil con valores por defecto
    def p1 = new Portatil()
    println p1.info()
    // → Portátil: CPU=Intel Core i5, Memoria=8GB, Batería=50%

    // Instancia de Portatil con valores personalizados
    def p2 = new Portatil('Apple M1', 16, 85)
    println p2.info()
    // → Portátil: CPU=Apple M1, Memoria=16GB, Batería=85%

}

