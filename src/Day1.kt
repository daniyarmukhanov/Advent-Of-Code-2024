import kotlin.math.abs

class Day1 : AdventDay() {


    override fun getTestAnswer(input: List<String>): String {
        return ""
    }

    override fun getPart1(input: List<String>): String {
        var sum = 0
        val left = input.map { it.split(" ").first().trim().toInt() }.sorted()
        val right = input.map { it.split(" ").last().trim().toInt() }.sorted()

        left.forEachIndexed { index, i ->
            sum += abs(i - right[index])
        }
        return sum.toString()
    }

    override fun getPart2(input: List<String>): String {
        var sum = 0
        val left = input.map { it.split(" ").first().trim().toInt() }.sorted()
        val right = input.map { it.split(" ").last().trim().toInt() }.sorted()

        left.forEach { i ->
            sum += i * right.count { it == i }
        }
        return sum.toString()
    }


}