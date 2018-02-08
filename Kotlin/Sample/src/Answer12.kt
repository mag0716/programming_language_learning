import kotlin.math.sqrt

fun main(args: Array<String>) {
    println("include integer : ${searchSqrtThatExistsAllDigits()}")
    println("only decimal : ${searchSqrtThatExistsAllDigits(true)}")
}

fun searchSqrtThatExistsAllDigits(onlyDecimal : Boolean = false) : Int {
    var value = 1
    while(true) {
        val sqrtString = sqrtString(value)
        val targetString = removeCommaAndMinimumLength(sqrtString, onlyDecimal)
        if(existsAllDigits(targetString)) {
            return value
        }
        value++
    }
}

fun sqrtString(value: Int) : String {
    if(value <= 0) {
        throw IllegalArgumentException("must be value > 0")
    }
    return Math.sqrt(value.toDouble()).toString()
}

/**
 * コンマを取り除き、最小文字数(10)に切り出す
 */
fun removeCommaAndMinimumLength(string: String, onlyDecimal: Boolean = false) : String {
    val removedCommaString = if(onlyDecimal) {
        val commaIndex = string.indexOf(".")
        string.substring(commaIndex+1)
    } else {
        string.replace(".", "")
    }

    return if(removedCommaString.length < 10) removedCommaString else removedCommaString.substring(0..9)
}

fun existsAllDigits(str: String) : Boolean {
    for(digit in 0..9) {
        if(!str.contains(digit.toString())) {
            return false
        }
    }
    return true
}