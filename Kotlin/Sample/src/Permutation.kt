fun <T> List<T>.permutation():List<List<T>>{
    val list = this
    if(list.size==1) return listOf(list)
    val perms=mutableListOf<List <T>>()
    val sub=list[0]
    for(perm in list.drop(1).permutation())
        for (i in 0..perm.size){
            val newPerm=perm.toMutableList()
            newPerm.add(i,sub)
            perms.add(newPerm)
        }
    return perms.distinct()
}

fun <T> Collection<T>.powerset(): Set<Set<T>> = powerset(this, setOf(setOf()))

private tailrec fun <T> powerset(left: Collection<T>, acc: Set<Set<T>>): Set<Set<T>> = when {
    left.isEmpty() -> acc
    else ->powerset(left.drop(1), acc + acc.map { it + left.first() })
}

fun <T> Set<T>.combinations(combinationSize: Int): Set<Set<T>> = when {
    combinationSize < 0 -> throw IllegalArgumentException("invalid combinationSize : $combinationSize")
    combinationSize == 0 -> setOf(setOf())
    combinationSize >= size -> setOf(toSet())
    else -> powerset()
            .filter { it.size == combinationSize }
            .toSet()
}