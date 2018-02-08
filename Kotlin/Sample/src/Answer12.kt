import kotlin.math.sqrt

fun main(args: Array<String>) {
    println(searchSqrtThatExistsAllDigits())
    println(searchSqrtThatExistsAllDigits(true))
}

fun searchSqrtThatExistsAllDigits(onlyDecimal : Boolean = false) : Int {
    var value = 1
    while(true) {
        if(existsAllDigits(sqrtString(value, onlyDecimal))) {
            return value
        }
        value++
    }
}

fun sqrtString(value: Int, onlyDecimal : Boolean = false) : String {
    if(value <= 0) {
        throw IllegalArgumentException("must be value > 0")
    }
    val sqrtString = Math.sqrt(value.toDouble()).toString()
    return if(onlyDecimal) sqrtString.substring(2) else sqrtString
}

fun existsAllDigits(str: String) : Boolean {
    for(digit in 0..9) {
        if(!str.contains(digit.toString())) {
            return false
        }
    }
    return true
}