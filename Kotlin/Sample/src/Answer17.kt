fun main(args: Array<String>) {
    println("Hello Answer17")

    // expect BBBB
    println(listOf("B", "B", "B", "B").permutation())

    // expect GBBB, BGBB, BBGB, BBBG
    println(listOf("G", "B", "B", "B").permutation())

    // expect : 8
    val allPattern = calculatePattern(4)
    println(allPattern)
    println(filterContinuousGirl(allPattern))

    // Answer
    println(filterContinuousGirl(calculatePattern(30)).size)
}

fun calculatePattern(numberOfPeople : Int) : List<List<String>> {
    val allPattern = mutableListOf<List<String>>()

    // 女の子が連続しない並びを持つ可能性をあるのは、numberOfPeople/2 まで
    for(numberOfGirl in 0..numberOfPeople/2) {
        val pattern = mutableListOf<String>()

        while(pattern.size < numberOfPeople) {
            if(pattern.size < numberOfGirl) {
                pattern.add("G")
            } else {
                pattern.add("B")
            }
        }

        allPattern.addAll(pattern.permutation())
    }

    return allPattern
}

/**
 * 女の子が連続するパターンを除外する
 */
fun filterContinuousGirl(allPattern : List<List<String>>) : List<List<String>> {
    return allPattern
            .filter { isContinuousGirl(it).not() }
}

fun isContinuousGirl(pattern : List<String>) : Boolean {
    return pattern.joinToString("").contains("GG")
}