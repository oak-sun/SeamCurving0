class Guitar(name: String) : Portable, Instrument(name) {

    override fun carry() = println("Carrying the $name")

    override fun play() = println("Playing the $name")

}

abstract class Instrument(val name: String) { abstract fun play() }

interface Portable { fun carry() }

fun main() {
    val guitar = Guitar(readln())
    guitar.play()
    guitar.carry()
}
