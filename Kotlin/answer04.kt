fun cutWhileOne(cutHistory: List<List<Int>>, personNumber: Int): List<List<Int>> {
    // 末尾取得
    val current = cutHistory[cutHistory.size - 1]
    val barSize = current.size
    val latest = mutableListOf<Int>()

    if(!isFinish(current)) {
        var cutCount = 0
        for (index in 0..barSize-1) {
            // 1本の棒を一度に切ることができるのは1人まで
            val bar = current[index]
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
