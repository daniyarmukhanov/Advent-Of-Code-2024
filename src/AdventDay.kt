private const val TEST_INPUT = "test_input"
private const val REAL_INPUT = "real_input"

abstract class AdventDay {

    private val testInput = readInput(TEST_INPUT)
    private val realInput = readInput(REAL_INPUT)

    abstract fun getTestAnswer(input: List<String> = testInput): String
    abstract fun getPart1(input: List<String> = realInput): String
    abstract fun getPart2(input: List<String> = realInput): String
}