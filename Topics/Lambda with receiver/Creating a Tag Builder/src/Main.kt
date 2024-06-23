
fun main() = builder { append("<tag>${readln()}</tag>") }.let(::println)

fun builder(strBuilder: StringBuilder.(String) -> Unit): String {
    val strRes = StringBuilder()
    strRes.strBuilder("")
    return strRes.toString()
}
