
fun main() = readln()
    .split(" ")
    .map { it.split("-") }
    .map { Spell(it[0], it[1].toInt()) }
    .groupBy { it.power }
    .let(::println)

data class Spell(val name: String, val power: Int)