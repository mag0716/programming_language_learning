enum class Direction {
    FRONT,
    BACK,
    LEFT,
    RIGHT
}

class Position(val x : Int, val y : Int) {
    var previous : Position? = null
    val next : MutableList<Position> = mutableListOf<Position>()

    fun hasParent() : Boolean {
        return previous != null
    }

    fun hasChild() : Boolean {
        return !next.isEmpty()
    }

    fun searchMovePattern() {
        if(!hasChild()) {
            var nextPosition : Position? = null
            for(direction in Direction.values()) {
                if(direction == Direction.FRONT) {
                    nextPosition = Position(x, y+1)
                } else if(direction == Direction.BACK) {
                    nextPosition = Position(x, y-1)
                } else if(direction == Direction.LEFT) {
                    nextPosition = Position(x-1, y)
                } else if(direction == Direction.RIGHT) {
                    nextPosition = Position(x+1, y)
                }

                if(nextPosition != null && newPosition(nextPosition)) {
                    nextPosition.previous = this
                    next.add(nextPosition)
                }
            }
        }
    }

    fun countChild(depth : Int) : Int {
        var count = 0
        for(child in next) {
            if(child.hasChild()) {
                count += child.countChild(depth-1)
            } else {
                if(depth == 1) {
                    count++
                }
            }
        }
        return count
    }

    fun newPosition(position : Position) : Boolean {
        if(previous != null) {
            return (previous!!.x != position.x || previous!!.y != position.y)
                    && previous!!.newPosition(position)
        }
        return true
    }
}

fun searchMovePattern(position : Position, count : Int) {
    if(count > 0) {
        position.searchMovePattern()
        if(position.hasChild()) {
            for(nextPosition in position.next) {
                searchMovePattern(nextPosition, count - 1)
            }
        }
    }
}

val position = Position(0, 0)
searchMovePattern(position, 12)
println(position.countChild(12)) // 32493
