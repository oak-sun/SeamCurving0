fun main() = readln()
    .split(" ")
    .groupingBy { it.first() }
    .fold(0) { a, e -> a + e.length }
    .let(::println)