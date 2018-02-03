
fun main(args: Array<String>) {
    //println(isDivided(2))
    //println(isDivided(3))
    //println(isDivided(5))
    //println(isDivided(8))
    //println(isDivided(21))
    //println(isDivided(144))

    val fibonacciNumbers = mutableListOf(1L, 1L)
    val dividableFibonacciNumbers = mutableListOf<Long>()
    generateFibonacci(fibonacciNumbers, dividableFibonacciNumbers) {
        // 2, 3, 5, 8, 21, 144 に続く 5つを発見したら終了
        it.size <= 10
    }
    println(dividableFibonacciNumbers)
}

/**
 * 指定したcount分までフィボナッチ数列を生成する
 */
fun generateFibonacci(fibonacci: MutableList<Long>, dividableFibonacci: MutableList<Long>, isContinue:(MutableList<Long>)->Boolean) {
    if(isContinue(dividableFibonacci)) {
        val nextNumber = fibonacci.takeLast(2).sum()
        fibonacci.add(nextNumber)
        if(isDivided(nextNumber)) {
            dividableFibonacci.add(nextNumber)
        }
        generateFibonacci(fibonacci, dividableFibonacci, isContinue)
    }
}

/**
 * 各桁の数字を足した数で自身が割り切れるかどうか
 */
fun isDivided(number: Long) : Boolean {
    val numberStr = number.toString()
    if(numberStr.length >= 2) {
        return number % generateSumOfAllDigits(numberStr) == 0L
    }
    return true
}

fun generateSumOfAllDigits(numberStr: String) : Int {
    return numberStr.toList()
            .map { it.toString().toInt() }
            .sum()
}