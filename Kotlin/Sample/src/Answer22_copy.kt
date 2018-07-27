fun main(args: Array<String>) {
    println("Hello Answer22")

    println("n=2 : ${calculatePairPattern(2)}")
    println("n=6 : ${calculatePairPattern(6)}")
    println("n=16 : ${calculatePairPattern(16)}")
}

fun calculatePairPattern(n : Int) : Int {
    if(n % 2 == 0) {
        val pair = mutableListOf<Int>()
        pair.add(1)
        for(i in 1..n/2) {
            pair.add(0)
            (0 until i).forEach {
                    pair[i] += pair[it] * pair[i - it - 1]
            }
        }
        return pair[n/2]
    } else {
        return 0
    }
}