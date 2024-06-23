fun main() = Cat().let { c ->
    c
        .javaClass
        .declaredFields
        .forEach {
            it.isAccessible = true
            println(it.get(c))
        }
}

