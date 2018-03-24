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