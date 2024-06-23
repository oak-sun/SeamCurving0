
fun main() {
    val (course, one, two) = readln().split(' ')

    println(
        build(course) {
            add(one)
            add(two)
            for (i in 1..2) { add("Anonymous #$i") }
        }
    )
}

fun build(name: String, init: CourseBuilder.() -> Unit):
   Course { return CourseBuilder(name).apply(init).build() }

data class Course(val name: String, val students: List<Student>)

data class Student(val name: String)

class CourseBuilder(private val name: String) {

    private val list = mutableListOf<Student>()
    fun add(name: String) = list.add(Student(name))
    fun build() = Course(name, list)
}
