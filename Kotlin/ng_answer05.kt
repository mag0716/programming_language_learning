/**
 * 両替
 *
 * @param source 両替元
 * @param destinationList 両替で使用される硬貨一覧
 * @param maxCount 両替時に1種類の硬貨の最大数
 *
 * @return 両替結果の全候補
 *         key: 硬貨の金額
 *         value: 枚数
 */
fun exchange(source : Int, destinationList : List<Int>, maxCount : Int) : List<Map<Int, Int>> {
    val resultList = mutableListOf<Map<Int, Int>>()

    // FIXME: ループ数を destinationList の size が変わっても対応できる様に修正する
    for(i in 0..calculateMaxCount(source, destinationList[0], maxCount)) {
        for(j in 0..calculateMaxCount(source, destinationList[1], maxCount)) {
            for(k in 0..calculateMaxCount(source, destinationList[2], maxCount)) {
                for(l in 0..calculateMaxCount(source, destinationList[3], maxCount)) {
                    val result = destinationList[0]*i + destinationList[1]*j + destinationList[2]*k + destinationList[3]*l
                    if(result == source) {
                        resultList.add(mapOf(destinationList[0] to i,
                                destinationList[1] to j,
                                destinationList[2] to k,
                                destinationList[3] to l))
                    }
                }
            }
        }
    }

    return resultList.toList()
}

/**
 * 両替時に1種類の硬貨で使える最大枚数を計算する
 *
 * @param source 両替元の金額
 * @param destination 両替に利用される硬貨
 * @param maxCount 最大枚数
 *
 * @return destination の最大枚数
 */
fun calculateMaxCount(source : Int, destination : Int, maxCount : Int) : Int {
    val count = source / destination
    if(count < maxCount) {
        return count
    } else {
        return maxCount
    }
}

println(exchange(1000, listOf(500, 100, 50, 10), 15))
