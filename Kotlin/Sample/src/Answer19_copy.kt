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

    // expect : [2, 3, 5, 7, 11, 13]
    val primeNumbers = calculatePrimeNumbers(6)
    println(primeNumbers)

    // answer
    // 素数を小さい順番から掛ければ条件を満たす合成数が求められる
    // [ 4, 6, 15, 35, 77, 143, 169]
    // ただしこれは最小の数ではないので、最小の数を求めるため素数の順番を並び替えて求める
    var min = primeNumbers[primeNumbers.lastIndex] * primeNumbers[primeNumbers.lastIndex]
    val primePatterns = primeNumbers.permutation()
    for(primePattern in primePatterns) {
        val friends = mutableListOf<Int>()
        for(index in 0..primePattern.size) {
            if(index == 0) {
                friends.add(primePattern[0] * primePattern[0])
            } else if(index == primePattern.size) {
                friends.add(primePattern[primePattern.lastIndex] * primePattern[primePattern.lastIndex])
            } else {
                friends.add(primePattern[index-1] * primePattern[index])
            }
        }
        val maxFriend = friends.max() ?: 0
        if(min > maxFriend) {
            min = maxFriend
            println("min update : $min $friends")
        }
    }
    println("answer = $min")
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

fun calculatePrimeNumbers(n : Int) : List<Int> {
    val primeNumbers = mutableListOf<Int>()
    var number = 2
    while(primeNumbers.size < 6) {
        if(number.isPrime()) {
            primeNumbers.add(number)
        }
        number++
    }
    return primeNumbers
}