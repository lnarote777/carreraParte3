class Quad(
    nombre: String,
    marca: String,
    modelo: String,
    capacidadCombustible: Float,
    combustibleActual: Float,
    kilometrosActuales: Float,
    cilindrada: Int,
) : Motocicleta(nombre, marca, modelo, capacidadCombustible, combustibleActual, kilometrosActuales, cilindrada) {

    val tipo: String = listOf("Cuadriciclos ligeros", "Cuadriciclos no ligeros" , "Vehículos especiales").random()

    override fun calcularAutonomia(): Float {
        return (super.calcularAutonomia()/2).redondear(2)
    }

    override fun toString(): String {
        return super.toString().replace("Motocicleta", "Quad")
    }



}