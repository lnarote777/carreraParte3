class Camion (
    nombre: String,
    marca: String,
    modelo: String,
    capacidadCombustible: Float,
    combustibleActual: Float,
    kilometrosActuales: Float,
    esHibrido: Boolean = false,
    val peso: Int
): Automovil(nombre, marca, modelo, capacidadCombustible, combustibleActual, kilometrosActuales, esHibrido ) {

    init {

    }

    companion object{
        const val KM_POR_LITRO = 6.25
   }



}