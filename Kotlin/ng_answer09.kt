fun main(args: Array<String>) {
    println(checkAllGroup(listOf(1, 1, -1, 1, -1, -1))) // false
    println(checkAllGroup(listOf(1, 1, -1, -1, 1, -1))) // true

    val orderPattern : List<List<Int>> = generateOrderPattern()
    println("pattern count = ${orderPattern.size}")
    var count = 0
    for(order in orderPattern) {
      if(checkAllGroup(order)) {
          count++
      }
    }
    println(count)
}

fun generateOrderPattern() : List<List<Int>> {
    val min = 1048575 // "000000000011111111111111111111"
    val max = 1073740800 // "111111111111111111110000000000"

    val orderPattern = mutableListOf<List<Int>>()
    for(value in min..max) {
        val binStr = Integer.toBinaryString(value)
        val order = mutableListOf<Int>()
        var manCount = 0
        for(index in 0..binStr.length-1) {
            val char = binStr[index]
            var people = -1
            if(char.equals('1')) {
                people = 1
                manCount++
            }
            order.add(0, people)
        }
        if(manCount == 20) {
            for(index in order.size+1..30) {
                order.add(0, -1)
            }
            orderPattern.add(order)
        } else {
            continue
        }
    }
    return orderPattern
}

/**
 * 1:男性、-1:女性の列
 * 2つに区切っていずれかのグループが男性、女性の数が同じになるかどうかをチェックする
 */
fun checkAllGroup(order : List<Int>) : Boolean {
    val size = order.size
    for(index in 2..size-2) {
        if(checkGroup(order.subList(0, index))
           || checkGroup(order.subList(index, size))) {
            return true
        }
    }
    return false
}

/**
 * 男女の数が同じかどうかをチェックする
 */
fun checkGroup(order : List<Int>) : Boolean {
    var count = 0

    for(people in order) {
        count += people
    }

    return count == 0
}
