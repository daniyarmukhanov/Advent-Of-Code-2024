import java.io.File

fun readInput(name: String) = File("src", "$name.txt")
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