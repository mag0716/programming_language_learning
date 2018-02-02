fun main(args: Array<String>) {
    println(isDivided(2))
    println(isDivided(3))
    println(isDivided(5))
    println(isDivided(8))
    println(isDivided(21))
    println(isDivided(144))

    val fibonacciNumbers = mutableListOf<Int>(1, 1)
    generateFibonacci(fibonacciNumbers, 10)
    println(fibonacciNumbers)
}

/**
 * 指定したcount分までフィボナッチ数列を生成する
 */
fun generateFibonacci(fibonacci: MutableList<Int>, count: Int) {
    if(count > 0) {
        val nextNumber = fibonacci.takeLast(2).sum()
        fibonacci.add(nextNumber)
        generateFibonacci(fibonacci, count-1)
    }
}

/**
 * 各桁の数字を足した数で自身が割り切れるかどうか
 */
fun isDivided(number: Int) : Boolean {
    val numberStr = number.toString()
    if(numberStr.length >= 2) {
        return number % generateSumOfAllDigits(numberStr) == 0
    }
    return true
}

fun generateSumOfAllDigits(numberStr: String) : Int {
    return numberStr.toList()
            .map { it.toString().toInt() }
            .sum()
}