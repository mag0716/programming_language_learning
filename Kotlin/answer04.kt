fun cutWhileOne(cutHistory: List<List<Int>>, personNumber: Int): List<List<Int>> {
    // 末尾取得
    val current = cutHistory[cutHistory.size - 1]
    val barSize = current.size
    // 人がなるべく余らない様に長い棒から切っていく
    val sortedCurrent = current.sortedDescending()
    val latest = mutableListOf<Int>()

    var cutCount = 0
    for (index in 0..barSize-1) {
        val bar = sortedCurrent[index]
        if (cutCount < personNumber) {
            if (isCuttable(bar)) {
                val cutBar = bar / 2
                latest.add(cutBar)
                latest.add(bar-cutBar)
                cutCount++
            } else {
                latest.add(bar)
            }
        } else {
            latest.add(bar)
        }
    }

    val result = cutHistory.toMutableList()
    if (latest.isNotEmpty()) {
        result.add(latest)
    }

    if(isFinish(latest)) {
        return result.toList()
    } else {
        return cutWhileOne(result.toList(), personNumber)
    }
}

fun isCuttable(bar : Int) : Boolean {
    return bar != 1
}

fun isFinish(current : List<Int>) : Boolean {
    return current.stream()
            .allMatch { it == 1 }
}

println(cutWhileOne(listOf(listOf(8)), 3).size - 1)
println(cutWhileOne(listOf(listOf(20)), 3).size - 1)
println(cutWhileOne(listOf(listOf(100)), 5).size - 1)
