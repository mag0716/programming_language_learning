import java.util.function.Predicate

fun main(args: Array<String>) {
    //println(searchMaxSum(europeanStyle, 3)) // 77
    //println(searchMaxSum(americanStyle, 3)) // 73

    var result = 0
    for(count in 2..36) {
        if(searchMaxSum(europeanStyle, count) < searchMaxSum(americanStyle, count)) {
            result++
        }
    }
    println("The number when european style's sum is smaller than american style's sum is = $result")
}

val europeanStyle = listOf(0, 32, 15, 19, 4, 21, 2, 25, 17, 34, 6, 27, 13, 36, 11, 30, 8, 23, 10, 5, 24, 16, 33, 1, 20, 14, 31, 9, 22, 18, 29, 7, 28, 12, 35, 3, 26)
val americanStyle = listOf(0, 28, 9, 26, 30, 11, 7, 20, 32, 17, 5, 22, 34, 15, 3, 24, 36, 13, 1, 0, 27, 10, 25, 29, 12, 8, 19, 31, 18, 6, 21, 33, 16, 4, 23, 35, 14, 2)

fun searchMaxSum(style : List<Int>, count : Int) : Int {
    var maxSum = 0
    for(startIndex in 0..style.size) {
        val tmp = searchMaxSum(style, count, startIndex)
        if(maxSum < tmp) {
            maxSum = tmp
        }
    }
    return maxSum
}

fun searchMaxSum(style : List<Int>, count : Int, startIndex : Int) : Int {
    if(count > 0) {
        // FIXME: startIndex から count 分だけ取り出す処理をもっとシンプルにしたい
        val list = style.stream()
                .skip(startIndex.toLong())
                .toArray()
                .take(count)
                .map { it as Int }
        return list.sum() + searchMaxSum(style, count-list.size, 0)
    }
    return 0
}