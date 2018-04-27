fun main(args: Array<String>) {
    println("Hello Sample20")

    val list1 = sumPattern(1)
    // expect: 16
    println("$list1 : ${list1.size}")
    // expect: 1
    val list16 = sumPattern(16)
    println("$list16 : ${list16.size}")

    val allSumPattern = mutableListOf<Int>()
    allSumPattern(allSumPattern)
    // answer
    var max : Int = 0
    var count : Int = 0
    while(allSumPattern.isNotEmpty()) {
        val tmp = allSumPattern[0]
        val tmpCount = allSumPattern.filter { it == tmp }.size
        println("$tmp : $tmpCount")
        if(count < tmpCount) {
            count = tmpCount
            max = tmp
        }
        allSumPattern.remove(tmp)
    }
    println("answer = $max : $count")
}

val magicTeamIndex = setOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)
val magicTeam = listOf(1, 14, 14, 4, 11, 7, 6, 9, 8, 10, 10, 5, 13, 2, 3, 15)

fun allSumPattern(list: MutableList<Int>) {
    for(size in 1..magicTeam.size) {
        list.addAll(sumPattern(size))
    }
}

fun sumPattern(size: Int) : List<Int> {
    val list = mutableListOf<Int>()
    val combinations = magicTeamIndex.combinations(size)
    for (combination in combinations) {
        list.add(combination.map { magicTeam[it] }.sum())
    }
    return list
}