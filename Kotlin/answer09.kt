fun main(args: Array<String>) {
    println(checkAllGroup(listOf(1, 1, -1, 1, -1, -1))) // false
    println(checkAllGroup(listOf(1, 1, -1, -1, 1, -1))) // true
}

fun generateOrder(manCount : Int, womanCount : Int) : List<List<Int>> {
  val orderList = listOf<List<Int>>()
  // TODO: 指定した男性、女性の並び順を全て生成する
  return orderList
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
