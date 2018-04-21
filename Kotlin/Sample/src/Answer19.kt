fun main(args: Array<String>) {
    println("Hello Answer19")
    // expect : false
    println(1.isPrime())
    // expect : true
    println(2.isPrime())
    // expect : true
    println(3.isPrime())
    // expect : false
    println(15.isPrime())

    // expect : [4, 6, 8, 9, 10]
    println(calculateCompositeNumbers(10))
}

fun Int.isPrime() : Boolean {

    if(this == 1) return false
    if(this == 2) return true
    if(this % 2 == 0) return false

    if ((2..Math.sqrt(this.toDouble()).toInt()).any {this % it == 0}) {
        return false
    }
    return true
}

fun calculateCompositeNumbers(n : Int) : List<Int> {
    val compositeNumbers = mutableListOf<Int>()

    for(number in 2..n) {
        if(!number.isPrime()) {
            compositeNumbers.add(number)
        }
    }

    return compositeNumbers
}