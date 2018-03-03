import org.jetbrains.annotations.Mutable
import java.util.*
import kotlin.math.min

fun main(args: Array<String>) {
    println("Hello Answer15")

    // debug
    // extra : 4通り
    //println(calculateSameStepPattern(4, MAX_STEP))

    println(calculateSameStepPattern(10 , MAX_STEP))
}

private val MAX_STEP = 4

// 動的計画法
//   対象となる問題を複数の部分問題に分割し、部分問題の計算結果を記録しながら解していく手法
//
// t回の移動でどこの段まで移動できるかのパターンを求める
// 「2人が同じ段になる」を「1人が偶数回の移動で逆の位置に着く」とみまし、偶数回の移動で0段目につくパターンを合計する
fun calculateSameStepPattern(stairs: Int, maxSteps: Int) : Int {
    val pattern = mutableListOf<Int>().apply {
        for(i in 0..stairs) {
                add(0)
        }
        set(lastIndex, 1)
    }

    var count = 0

    for(i in 0 until stairs) {
        for(j in 0..stairs) { // 今いる段数から
            for(k in 1..maxSteps) { // 次に進む数でどこまで行くのかをカウントしていく
                if(k > j) {
                    break
                }
                pattern[j-k] = pattern[j-k] + pattern[j]
            }
            pattern[j] = 0
        }
        println("${i+1}ターンで到達できる段数 -> $pattern")
        if(i % 2 == 1) {
            count += pattern[0]
        }
    }

    return count
}