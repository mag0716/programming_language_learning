fun main(args: Array<String>) {
    println("Hello Answer16")

    // for debug
    // expect: empty
    println(createRectangle(1))
    // expect: 1*9, 2*8, 3*7, 4*6
    println(createRectangle(20))

    // expect: null
    println(createSquare(1))
    // expect: 5*5
    println(createSquare(20))

    // expect: false
    println(RectanglePattern(Rectangle(1, 9), Rectangle(3, 7), Rectangle(5, 5)).match())
    // expect: true
    println(RectanglePattern(Rectangle(1, 9), Rectangle(2, 8), Rectangle(5, 5)).match())

    // expect: 1*8 * 2*8 = 5*5
    println(searchMatchRectanglePattern(20))

    println(searchMatchRectanglePattern().size)
}

fun searchMatchRectanglePattern() : List<RectanglePattern> {
    val pattern = mutableListOf<RectanglePattern>()

    for(length in 1..500) {
        pattern.addAll(searchMatchRectanglePattern(length))
    }

    return pattern
}

fun searchMatchRectanglePattern(length: Int) : List<RectanglePattern> {
    val pattern = mutableListOf<RectanglePattern>()

    val rectangleList = createRectangle(length)
    val square = createSquare(length)

    if(rectangleList.isNotEmpty() && square != null) {
        for (rectangle1 in rectangleList) {
            for(rectangle2 in rectangleList) {
                val rectanglePattern = RectanglePattern(rectangle1, rectangle2, square)
                if(rectanglePattern.match()) {
                    pattern.add(rectanglePattern)
                }
            }
        }
    }

    return pattern
}

fun createRectangle(length: Int) : List<Rectangle> {
    val rectangleList = mutableListOf<Rectangle>()
    if(length % 2 == 0) {
        val halfLength = length / 2
        for(width in 1..halfLength/2) {
            val height = halfLength-width
            if(width != height) {
                rectangleList.add(Rectangle(width, height))
            }
        }
    }
    return rectangleList
}

fun createSquare(length: Int) : Rectangle? {
    if(length % 4 == 0) {
        val line = length / 4
        return Rectangle(line, line)
    } else {
        return null
    }
}

data class Rectangle(val width: Int, val height: Int) {
    fun area() : Int = width * height
}

data class RectanglePattern(val rect1: Rectangle, val rect2: Rectangle, val square: Rectangle) {
    fun match() = rect1.area() + rect2.area() == square.area()
}