
fun main() = println(table { tr { for (i in 1..2) { td {} } } })

fun table(init: TABLE.() -> Unit): TABLE = TABLE().apply(init)

open class Tag(private val name: String) {

    private val list = mutableListOf<Tag>()
    fun <T : Tag> doInit(child: T, init: T.() -> Unit) {
        child.init()
        list.add(child)
    }

    override fun toString() = "<$name>${list.joinToString("")}</$name>"
}

class TR : Tag("tr") { fun td(init: TD.() -> Unit) = doInit(TD(), init) }

class TD : Tag("td")

class TABLE : Tag("table") { fun tr(init: TR.() -> Unit) = doInit(TR(), init) }