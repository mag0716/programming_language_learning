fun main(args: Array<String>) {
  var value = 10
  while (true) {
    if (value % 2 != 0
      && isKaibun(value.toString())
      && isKaibun(Integer.toOctalString(value))
      && isKaibun(Integer.toBinaryString(value))) {
      println("${value}")
      break
    }
    value++
  }
}

fun isKaibun(value:String) : Boolean {
  return value.equals(value.reversed())
}
