fun main() = Secret().let { s ->
    s
        .javaClass.declaredMethods
        .forEach {
            it.isAccessible = true
            println(it.invoke(s))
        }
}
