fun main() {
    val (INC, CTE) = readln().split(' ').map { it.toInt() }
    println(
        calculateOperation(Account()) { this.copy(result = amount * INC * CTE, status = "END") }
    )
}

data class Account(

    val id: Int = 1,
    val amount: Int = 0,
    val result: Int = 0,
    val status: String = "START"
)

@Suppress("All")
fun calculateOperation(init: Account, func: Account.() -> Account):
    Account { return init.copy(amount = 50).func() }
