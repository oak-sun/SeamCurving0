abstract class Employee(val name: String, val surname: String) {

    abstract val age: Int
   
    abstract fun doWork()

    fun fullName() = "$name $surname"
}

@Suppress("All")
class Worker(name: String, surname: String) : Employee(name, surname) {

    override val age = 40

    override fun doWork() = println("I am working!")

}

fun main() = 
    Worker(readln(), readln()).apply { println("My name is: ${fullName()}") }
        .doWork()
