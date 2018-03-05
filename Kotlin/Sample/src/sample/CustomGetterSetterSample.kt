package sample

fun main(args: Array<String>) {
    val sample1 = Sample1()
    println(sample1.title)
    sample1.title = "sample1"
    println(sample1.title)

    val sample2 = Sample2()
    println("${sample2.title} : ${sample2.isEmpty}")
    sample2.title = "sample2"
    println("${sample2.title} : ${sample2.isEmpty}")

    val sample3 = Sample3()
    println(sample3.title)
    sample3.title = "sample3"
    println(sample3.title)
    sample3.title = ""
    println(sample3.title)
}

/**
 * デフォルト
 */
class Sample1 {
    var title: String? = null
}

/**
 * カスタムゲッター
 */
class Sample2 {
    var title: String? = null
    // バッキングフィールドは生成されない
    val isEmpty: Boolean
        get() = title?.isEmpty() ?: true
}

/**
 * カスタムセッター
 * `field` でバッキングフィールドにアクセスできる
 */
class Sample3 {
    var title = "unddefine"
        set(value) {
            if(value.isNotEmpty()) {
                field = value
            }
        }
}