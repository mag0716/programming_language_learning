fun collatz_loop(maxValue : Int) : List<Int> {
    val result = mutableListOf<Int>()

    for(value in 0..maxValue step 2) {
        if(collatz(value)) {
            result.add(value)
        }
    }

    return result.toList()
}

fun collatz(value : Int) : Boolean {
    var tmp = value * 3 + 1
    while(true) {
        if(tmp == 1) {
            return false
        } else if(tmp == value) {
            return true
        } else {
            if(tmp % 2 == 0) {
                tmp = tmp / 2
            } else {
                tmp = tmp * 3 + 1
            }
        }
    }
}

println(collatz_loop(10000).size)
