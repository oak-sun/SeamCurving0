class Add(left: Int, right: Int) : Calculator(left, right) { override fun perform() = left + right }

class Multiply(left: Int, right: Int) : Calculator(left, right) { override fun perform() = left * right }

fun main() = List(2) { readln().toInt() }
    .let { 
        println(
            "${Add(it[0], it[1]).perform()}\n${Multiply(it[0], it[1]).perform()}"
        )
    }
