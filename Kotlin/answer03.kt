val cards = MutableList<Boolean>(100) {
    false
}

for(index in 0..cards.size-1) {
    val start = index + 1
    val offset = start + 1
    for(j in start..cards.size-1 step offset) {
        cards[j] = !cards[j]
    }
}

for((index, card) in cards.withIndex()) {
    if(!card) {
        println("${index+1},")
    }
}
