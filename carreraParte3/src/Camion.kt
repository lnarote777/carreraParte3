class Camion (
    nombre: String,
    marca: String,
    modelo: String,
    capacidadCombustible: Float,
    combustibleActual: Float,
    kilometrosActuales: Float,
    esHibrido: Boolean
): Automovil(nombre, marca, modelo, capacidadCombustible, combustibleActual, kilometrosActuales, esHibrido ) {



    companion object{
        const val KM_POR_LITRO = 6.25f

        private val peso: Int = (1000..10000).random()
        val kmReducidos = ((peso * 0.2)/1000)
        val kmPorLitros = (KM_POR_LITRO - kmReducidos).toFloat()

   }

    override fun toString(): String {
        return super.toString().replace("Automovil", "Camion")
    }

    override fun calcularAutonomia(): Float =
        if (esHibrido){
            (combustibleActual * (kmPorLitros + AHORRO_ELECTRICO)).redondear(2)
        }else{
            (combustibleActual * kmPorLitros).redondear(2)
        }


}