import javax.swing.border.EmptyBorder
import kotlin.random.Random

class Gestor {

    private fun marcaMotocicleta(): String = listOf("Harley-Davidson", "Honda", "Kawasaki", "Vespa").random()

    private fun modeloMotocicleta(): String = listOf("CVO", "Africa Twin", "Eliminator", "GTS 300").random()

    private fun cilindrada(): Int = listOf(125, 250, 400, 500, 750, 900, 1000).random()

    private fun marcaAutomovil(): String = listOf("Audi", "Alfa Romeo", "Bugatti", "Ferrari", "Fiat", "Ford").random()

    private fun modeloAutomovil(): String = listOf("Q7", "Sportage", "Puma", "Divo", "California T", "500", "Fiesta").random()

    private fun esElectrico(): Boolean = Random.nextBoolean()

    private fun tipoQuad() = listOf("Cuadriciclos ligeros", "Cuadriciclos no ligeros" , "Vehículos especiales").random()

    fun pedirParticipantes(): Int {

        var numParticipantes: Int

        while (true){
            try {
                print("Introduzca el número de participantes: ")
                numParticipantes = readln().toInt()
                if (numParticipantes is Int){
                    break
                }
            } catch (e: Exception) {
                println("***$e -> Debe ingresar un número entero positivo y mayor a 0.")
            }

        }

        return numParticipantes
    }

    fun listaVehiculos(numParticipantes: Int): List<Vehiculo>{
        var par = numParticipantes
        var cont = 1
        val vehiculos = mutableListOf<Vehiculo>()
        var terminar = true

        while (terminar){
            try {
                while (par != 0){
                    print("Nombre del vehículo $cont -> ")
                    val nombre = readln().capitalizar()

                    if (nombre.isBlank()){
                        terminar = true
                        throw Exception()
                    }

                    val nombreSinEspacios = nombre.trim()
                    val vehiculo = vehiculoAleatorio(nombreSinEspacios)
                    cont++
                    par--

                    if (vehiculo is Automovil || vehiculo is Quad){
                        println("\tTe ha tocado un ${vehiculo.toString()}")
                    }else{
                        println("\tTe ha tocado una ${vehiculo.toString()}")
                    }

                    vehiculos.add(vehiculo)

                    terminar = false

                }
            }catch (e: Exception){
                println("$e -> El nombre no puede estar vacío")
            }
        }

        return vehiculos
    }

    //mirar si hay otra forma de hacerlo
    fun vehiculoAleatorio(nombre: String): Vehiculo {

        val num = (1..4).random()
        var capacidad: Float
        val km = 0f

        if (num == 1){
            capacidad = (30..60).random().toFloat()
            val combustible = ((20..100).random().toFloat()/100f) * capacidad
            return Automovil(nombre, marcaAutomovil(), modeloAutomovil(), capacidad, combustible, km, esElectrico())

        }else if(num == 2){
            capacidad = (15..30).random().toFloat()
            val combustible = (((20..100).random())/100f) * capacidad
            return Motocicleta(nombre, marcaMotocicleta(), modeloMotocicleta(), capacidad, combustible, km, cilindrada())

        }else if (num == 3){
            capacidad = (90..150).random().toFloat()
            val combustible = ((20..100).random()/100f) * capacidad
            return Camion(nombre, marcaAutomovil(), modeloAutomovil(), capacidad, combustible, km, esElectrico())

        }else{
            capacidad = (20..40).random().toFloat()
            val combustible = ((20..100).random()/100f) * capacidad
            return Quad(nombre, marcaMotocicleta(), modeloMotocicleta(), capacidad, combustible, km, cilindrada(), tipoQuad())
        }
    }


}