import kotlin.math.abs

class Day2 : AdventDay() {
    override fun getTestAnswer(input: List<String>): String {
        return input.count {
            it.dampenerSafe()
        }.toString()
    }

    override fun getPart1(input: List<String>): String {
        return input.count { it.isSafe() }.toString()
    }

    override fun getPart2(input: List<String>): String {
        return input.count { it.dampenerSafe() }.toString()
    }
}

private fun String.isSafe(): Boolean {
    val numbers = this.split(" ").map { it.toInt() }

    numbers.forEachIndexed { index, i ->
        if (index == numbers.lastIndex) {
            return@forEachIndexed
        }
        if (abs(i - numbers[index + 1]) !in 1..3)
            return false
    }

    var increasingCount = 0
    var decreasingCount = 0
    numbers.forEachIndexed { index, i ->
        if (index == numbers.lastIndex) {
            return@forEachIndexed
        }

        if (i < numbers[index + 1]) {
            increasingCount++
        }
        if (i > numbers[index + 1]) {
            decreasingCount++
        }
    }
    return !(increasingCount != 0 && decreasingCount != 0)
}

private fun String.dampenerSafe(): Boolean {
    val numbers = this.split(" ").map { it.toInt() }
    numbers.forEachIndexed { outerIndex, _ ->
        if (numbers.filterIndexed { index, _ ->
                outerIndex != index
            }.joinToString(" ").isSafe()) {
            return true
        }
    }

    return false
}