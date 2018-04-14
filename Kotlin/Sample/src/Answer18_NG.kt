fun main(args: Array<String>) {
    println("Hello Answer18")

    // expect : 6通り
    println(generateCutPattern(4).size)

    // expect : [4, 9]
    println(generateSqrtPattern(4))
    // expect : []
    println(generateSqrtPattern(2))

    // expect : true
    println(isSqrt(4, listOf(4, 9)))
    // expect : false
    println(isSqrt(5, listOf(4, 9)))

    // expect : true
    println(isAllSqrt(listOf(1, 3, 1, 3), listOf(4)))
    // expect : false
    println(isAllSqrt(listOf(1, 2, 3, 6), listOf(4, 9)))

    var count = 2
    loop@ while(true)  {
        val allCutPattern = generateCutPattern(count)
        val sqrtPattern = generateSqrtPattern(count)
        println("$count -> ${allCutPattern.size}")
        for(cutPattern in allCutPattern) {
            val pattern = mutableListOf(1)
            pattern.addAll(cutPattern)
            if(isAllSqrt(pattern, sqrtPattern)) {
                break@loop
            }
        }
        println("checked $count")
        count++
    }
    println("all sqrt cut pattern : $count")
}

fun generateCutPattern(count : Int) : List<List<Int>> {
    val strawberryPattern = mutableListOf<Int>()
    // 今回は隣り合うケーキのいちごの数の和が欲しいので、全てのパターンを求める必要はないので
    // いちごの数が1つは index が 0 固定として扱う
    for(strawberry in 2..count) {
        strawberryPattern.add(strawberry)
    }

    return strawberryPattern.permutation()
}

/**
 * ケーキのカット数から平方根のパターンを求める
 *
 * カット数が N であれば、隣り合うケーキのいちごの数の和の最大値は 2N - 1 となるので、
 * 2^2 〜 (N-1)^2
 *
 */
fun generateSqrtPattern(count : Int) : List<Int> {
    val sqrtPattern = mutableListOf<Int>()

    for(value in 2..(count-1)) {
        sqrtPattern.add(value*value)
    }

    return sqrtPattern
}

fun isSqrt(sum : Int, sqrtPattern : List<Int>) = sqrtPattern.contains(sum)

fun isAllSqrt(cutPattern : List<Int>, sqrtPattern : List<Int>) : Boolean {
    for(index in 0..(cutPattern.size-1)) {
        val nextIndex = if(index+1 < cutPattern.size) index+1 else 0
        if(!isSqrt(cutPattern[index] + cutPattern[nextIndex], sqrtPattern)) {
            return false
        }
    }
    return true
}