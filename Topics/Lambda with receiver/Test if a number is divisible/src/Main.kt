fun main() {
    val (one, two) = readln()
        .split(' ')
        .map { it.toInt() }
    println(one.isDivisible(two))
}

val isDivisible: Int.(Int) -> Boolean = { this % it == 0 }
