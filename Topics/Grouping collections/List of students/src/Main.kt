fun main() = readln()
    .split(" ")
    .groupingBy { it.first() }
    .reduce { _, accumulator, e ->
        if (accumulator.length >= e.length) accumulator else e 
    }
    .let(::println)
