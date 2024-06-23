fun main() = readln()
    .split(" ")
    .groupingBy { it.length }
    .eachCount()
    .let(::println)