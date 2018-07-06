fun main(args: Array<String>) {
//    // 1
//    println(generateXorPascalTriangle(1))
//    // 1 1
//    println(generateXorPascalTriangle(2, listOf(1)))
//    // 1 0 1
//    println(generateXorPascalTriangle(3, listOf(1, 1)))
//
//    // 3
//    println(executeUntilZeroCount(1))
//    // 5
//    println(executeUntilZeroCount(2))
//    println(executeUntilZeroCount(3))
//    println(executeUntilZeroCount(4))

    // Answer
    println(executeUntilZeroCount(2014))
}

/**
 * 0 の数が count まで表示されるまで実行する
 *
 * @return 0 の数
 */
fun executeUntilZeroCount(count : Int) : Int {
    var n = 1
    var zeroCount = count
    var items = listOf(1)
    while(zeroCount > 0) {
        items = generateXorPascalTriangle(n, items)
        zeroCount -= items.filter { it == 0 }.size
        if(zeroCount <= 0) {
            break
        }
        n++
    }
    return n
}

fun generateXorPascalTriangle(n : Int, previousItems: List<Int> = emptyList()) : List<Int> {
    val result = mutableListOf<Int>()

    if(n != 1) {
        for (i in 0 until n) {
            result.add(previousItems.xor(i - 1, i))
        }
    } else {
        result.add(1)
    }

    return result
}

fun List<Int>.xor(i1 : Int, i2 : Int) : Int {
    val v1 = getOrElse(i1) {0}
    val v2 = getOrElse(i2) {0}
    return v1.xor(v2)
}