open class Shape {
    
    open fun calculateArea() = 0.0
    
    open fun calculatePerimeter() = 0.0
}

abstract class Polygon : Shape()

class Rectangle(private val width: Double, private val length: Double) : Polygon() {
    
    override fun calculateArea() = length * width
    
    override fun calculatePerimeter() = 2 * (length + width)
}

fun main() = 
    Rectangle(readln().toDouble(), readln().toDouble())
        .run { println("Area = ${calculateArea()}\nPerimeter = ${calculatePerimeter()}") }
