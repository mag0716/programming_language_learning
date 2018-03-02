import org.jetbrains.annotations.Mutable
import kotlin.math.min

fun main(args: Array<String>) {
    println("Hello Answer15")

    // for debug
//    val upStepPattern = mutableListOf<List<Int>>()
//    generateUpStepPattern(upStepPattern, listOf(0), 4)
//    println(upStepPattern)
//
//    val downStepPattern = mutableListOf<List<Int>>()
//    generateDownStepPattern(downStepPattern, listOf(4), 4)
//    println(downStepPattern)
//
//    println(checkSameStepPattern(upStepPattern, downStepPattern))

    val upStepPattern = mutableListOf<List<Int>>()
    generateUpStepPattern(upStepPattern, listOf(0), 10)
    println(upStepPattern)

    val downStepPattern = mutableListOf<List<Int>>()
    generateDownStepPattern(downStepPattern, listOf(10), 10)
    println(downStepPattern)

    println(checkSameStepPattern(upStepPattern, downStepPattern).size)
}

private val MAX_STEP = 4

private fun generateUpStepPattern(allPattern : MutableList<List<Int>>, pattern : List<Int>, leftSteps : Int) {
    for(nextSteps in 1..MAX_STEP) {
        val tmp = mutableListOf<Int>().apply {
            addAll(pattern)
            val preSteps = this[lastIndex]
            add(preSteps + nextSteps)
        }
        val nextLeftSteps = leftSteps - nextSteps
        if(nextLeftSteps > 0) {
            generateUpStepPattern(allPattern, tmp, nextLeftSteps)
        } else if(nextLeftSteps == 0) {
            allPattern.add(tmp)
        }
    }
}

private fun generateDownStepPattern(allPattern : MutableList<List<Int>>, pattern : List<Int>, leftSteps : Int) {
    for(nextSteps in 1..MAX_STEP) {
        val nextLeftSteps = leftSteps - nextSteps
        val tmp = mutableListOf<Int>().apply {
            addAll(pattern)
            val preSteps = this[lastIndex]
            add(nextLeftSteps)
        }
        if(nextLeftSteps > 0) {
            generateDownStepPattern(allPattern, tmp, nextLeftSteps)
        } else if(nextLeftSteps == 0) {
            allPattern.add(tmp)
        }
    }
}

private fun checkSameStepPattern(upStepPatternList: List<List<Int>>, downStepPatternList: List<List<Int>>) : List<Pair<List<Int>, List<Int>>> {
    val sameStepPattern = mutableListOf<Pair<List<Int>, List<Int>>>()

    upStepPatternList.forEach {
        upStepPattern -> downStepPatternList.forEach {
            downStepPattern -> checkSameStepPattern(upStepPattern, downStepPattern)?.let { sameStepPattern.add(it) }
        }
    }

    return sameStepPattern.distinct()
}

private fun checkSameStepPattern(upStepPattern: List<Int>, downStepPattern: List<Int>) : Pair<List<Int>, List<Int>>? {
    val minIndex = min(upStepPattern.lastIndex, downStepPattern.lastIndex)
    val tmpUpStepPattern = mutableListOf<Int>()
    val tmpDownStepPattern = mutableListOf<Int>()

    for(index in 0..minIndex) {
        tmpUpStepPattern.add(upStepPattern[index])
        tmpDownStepPattern.add(downStepPattern[index])
        if(upStepPattern[index] == downStepPattern[index]) {
            return tmpUpStepPattern to tmpDownStepPattern
        } else if(upStepPattern[index] > downStepPattern[index]) {
            break
        }
    }

    return null
}