fun main(args: Array<String>) {
    val validCalculation = MaskCalculation(1234567890)
    println("${validCalculation.valid()} : ${validCalculation.leftSide()} = ${validCalculation.rightSide()}")

    val invalidCalculation = MaskCalculation(1111111111)
    println("${invalidCalculation.valid()} : ${invalidCalculation.leftSide()} = ${invalidCalculation.rightSide()}")

    for(value in 1234056789..9876543210) {
        try {
            val calc = MaskCalculation(value)
            if(calc.valid() && calc.leftSide() == calc.rightSide()) {
                println(calc.toString())
            }
        } catch(e : IllegalArgumentException) {
        }
    }
    println("end")
}

/**
 * 覆面算
 *
 * READ + WRITE + TALK = SKILL
 * 最上位の文字には 0 はありえない
 */
class MaskCalculation(val value: Long) {
    val R: Int
    val W: Int
    val T: Int
    val S: Int
    val E: Int
    val A: Int
    val D: Int
    val I: Int
    val L: Int
    val K: Int

    init {
        if(value < 1000000000) {
            throw IllegalArgumentException("invalid argument : $value")
        }

        val str = value.toString()
        R = str[0].toString().toInt()
        W = str[1].toString().toInt()
        T = str[2].toString().toInt()
        S = str[3].toString().toInt()
        E = str[4].toString().toInt()
        A = str[5].toString().toInt()
        D = str[6].toString().toInt()
        I = str[7].toString().toInt()
        L = str[8].toString().toInt()
        K = str[9].toString().toInt()
    }

    fun valid() : Boolean {
        if(R == 0 || W == 0 || T == 0 || S == 0) {
            return false
        }
        return isAllDifferentDigit()
    }

    fun leftSide() : Int {
        return "$R$E$A$D".toInt() + "$W$R$I$T$E".toInt() + "$T$A$L$K".toInt()
    }

    fun rightSide() : Int {
        return "$S$K$I$L$L".toInt()
    }

    private fun isAllDifferentDigit() : Boolean {
        return value.toString()
                .toCharArray()
                .distinct()
                .count() == 10
    }

    override fun toString(): String {
        return "$R$E$A$D + $W$R$I$T$E+ $T$A$L$K = $S$K$I$L$L"
    }
}