import kotlin.random.Random

class Gestor {

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

    fun pedirNombre(numParticipantes: Int){
        var par = numParticipantes
        var cont = 1

        while (par != 0){
            print("Nombre del vehículo $cont -> ")
            val nombre = readln()
            val vehiculo = vehiculoAleatorio(nombre)
            cont++
            par--
            println(vehiculo.toString())
        }

    }

    //mirar si hay otra forma de hacerlo
    fun vehiculoAleatorio(nombre: String): Vehiculo {
        val num = (1..4).random()
        var capacidad: Float

        if (num == 1){
            val modelo = listOf("Q7", "Sportage", "Puma", "Divo", "California T", "500", "Fiesta").random()
            val marca = listOf("Audi", "Alfa Romeo", "Bugatti", "Ferrari", "Fiat", "Ford").random()
            val km = 0f
            val hibrido = Random.nextBoolean()
            capacidad = (30..60).random().toFloat()
            val combustible = ((20..100).random().toFloat()/100f) * capacidad
            return Automovil(nombre, marca, modelo, capacidad, combustible, km, hibrido)
        }else if(num == 2){
            val modelo = listOf("CVO", "Africa Twin", "Eliminator", "GTS 300").random()
            val marca = listOf("Harley-Davidson", "Honda", "Kawasaki", "Vespa").random()
            val cilindrada = listOf(125, 250, 400, 500, 750, 900, 1000).random()
            val km = 0f
            capacidad = (15..30).random().toFloat()
            val combustible = (((20..100).random())/100f) * capacidad
            return Motocicleta(nombre, marca, modelo, capacidad, combustible, km, cilindrada)
        }else if (num == 3){
            val modelo = listOf("Q7", "Sportage", "Puma", "Divo", "California T", "500", "Fiesta").random()
            val marca = listOf("Audi", "Alfa Romeo", "Bugatti", "Ferrari", "Fiat", "Ford").random()
            val km = 0f
            val hibrido = Random.nextBoolean()
            capacidad = (90..150).random().toFloat()
            val combustible = ((20..100).random()/100f) * capacidad
            return Camion(nombre, marca, modelo, capacidad, combustible, km, hibrido)
        }else{
            val modelo = listOf("Q7", "Sportage", "Puma", "Divo", "California T", "500", "Fiesta").random() //cambiar
            val marca = listOf("Audi", "Alfa Romeo", "Bugatti", "Ferrari", "Fiat", "Ford").random()  //cambiar
            val tipo = listOf("Cuadriciclos ligeros", "Cuadriciclos no ligeros" , "Vehículos especiales").random()
            val cilindrada = listOf(125, 250, 400, 500, 750, 900, 1000).random()
            val km = 0f
            capacidad = (20..40).random().toFloat()
            val combustible = ((20..100).random()/100f) * capacidad
            return Quad(nombre, marca, modelo, capacidad, combustible, km, cilindrada, tipo)
        }
    }

}