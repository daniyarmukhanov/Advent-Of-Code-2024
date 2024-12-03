import java.io.File

abstract class AdventDay {

    abstract fun getTestAnswer(input: List<String> = readInput("test_input")): String
    abstract fun getPart1(input: List<String> = readInput("real_input")): String
    abstract fun getPart2(input: List<String> = readInput("real_input")): String
}


private fun readInput(name: String) = File("src", "$name.txt")
    .readLines()

fun printAnswers(day: AdventDay) {
    try {
        print("Test Answer: ")
        println(day.getTestAnswer())

        print("Part 1: ")
        println(day.getPart1())

        print("Part 2: ")
        println(day.getPart2())
    } catch (e: NotImplementedError) {
        println("NOT YET IMPLEMENTED")
    }
}