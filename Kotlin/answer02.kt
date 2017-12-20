fun generateExpressionPattern(value: Int) : Array<String> {
    val v1 = value % 1000 % 100 % 10
    val v2 = value % 1000 % 100 / 10
    val v3 = value % 1000 / 100
    val v4 = value / 1000

    return arrayOf(
        "${v4}*${v3}${v2}${v1}",
        "${v4}${v3}*${v2}${v1}",
        "${v4}${v3}${v2}*${v1}",
        "${v4}*${v3}*${v2}${v1}",
        "${v4}*${v3}${v2}*${v1}",
        "${v4}${v3}*${v2}*${v1}",
        "${v4}*${v3}*${v2}*${v1}"
    )
}

for(source in 1000..9999) {
    val expressions = generateExpressionPattern(source)
    for(expression in expressions) {
        if(source.toString().equals(eval(expression).toString().reversed())) {
            println("${expression}=${source}")
            break
        }
    }
}
