
@Suppress("All")
class Square(val side: Double) : Shape() {

    override fun calculateArea() = side * side

    override fun calculatePerimeter() = side * 4
}

fun main() =
    Square(readln().toDouble())
        .run { println("Area = ${calculateArea()}\nPerimeter = ${calculatePerimeter()}") }
