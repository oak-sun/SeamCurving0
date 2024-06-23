fun main() = println(readln().woodoow { uppercase().reversed().dropLast(1) })

fun String.woodoow(str: String.() -> String): String { return str() }

