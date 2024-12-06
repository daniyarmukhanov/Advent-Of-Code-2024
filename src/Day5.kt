class Day5 : AdventDay() {
    override fun getTestAnswer(input: List<String>): String {
        val rulesInput = input.takeWhile { it.isNotBlank() }
        val updatesInput = input.takeLast(input.size - rulesInput.size - 1)

        val rules = rulesInput.map { line ->
            val (x, y) = line.split("|").map { it.toInt() }
            x to y
        }

        val incorrectMiddleSum = updatesInput.map { it.split(",").map { p -> p.trim().toInt() } }
            .filterNot { isUpdateInCorrectOrder(it, rules) } // Take only incorrect updates
            .sumOf { update ->
                val correctOrder = correctOrdering(update, rules)
                val midIndex = correctOrder.size / 2
                correctOrder[midIndex]
            }

        return incorrectMiddleSum.toString()
    }

    override fun getPart1(input: List<String>): String {
        val rulesInput = input.takeWhile { it.isNotBlank() }
        val updatesInput = input.takeLast(input.size - rulesInput.size - 1)

        val rules = rulesInput.map { line ->
            val (x, y) = line.split("|").map { it.toInt() }
            x to y
        }

        var sumOfMiddles = 0
        for (updateLine in updatesInput) {
            val pages = updateLine.split(",").map { it.trim().toInt() }
            if (isUpdateInCorrectOrder(pages, rules)) {
                val middleIndex = pages.size / 2
                sumOfMiddles += pages[middleIndex]
            }
        }

        return sumOfMiddles.toString()
    }

    override fun getPart2(input: List<String>): String {
        val rulesInput = input.takeWhile { it.isNotBlank() }
        val updatesInput = input.takeLast(input.size - rulesInput.size - 1)

        val rules = rulesInput.map { line ->
            val (x, y) = line.split("|").map { it.toInt() }
            x to y
        }

        val incorrectMiddleSum = updatesInput.map { it.split(",").map { p -> p.trim().toInt() } }
            .filterNot { isUpdateInCorrectOrder(it, rules) } // Take only incorrect updates
            .sumOf { update ->
                val correctOrder = correctOrdering(update, rules)
                val midIndex = correctOrder.size / 2
                correctOrder[midIndex]
            }

        return incorrectMiddleSum.toString()
    }
}

fun isUpdateInCorrectOrder(pages: List<Int>, rules: List<Pair<Int, Int>>): Boolean {
    val indexMap = pages.withIndex().associate { it.value to it.index }

    for ((x, y) in rules) {
        if (x in indexMap && y in indexMap) {
            if (indexMap[x]!! >= indexMap[y]!!) {
                return false
            }
        }
    }
    return true
}


// this is function made by AI
fun correctOrdering(pages: List<Int>, rules: List<Pair<Int, Int>>): List<Int> {
    val pageSet = pages.toSet()
    // Filter rules to only those that apply to these pages
    val applicableRules = rules.filter { pageSet.contains(it.first) && pageSet.contains(it.second) }

    // Build adjacency list and in-degree map
    val adjacency = mutableMapOf<Int, MutableList<Int>>()
    val inDegree = mutableMapOf<Int, Int>()

    // Initialize in-degree and adjacency for all pages in update
    for (p in pages) {
        adjacency[p] = mutableListOf()
        inDegree[p] = 0
    }

    // Fill adjacency and in-degree from rules
    for ((x, y) in applicableRules) {
        adjacency[x]!!.add(y)
        inDegree[y] = inDegree[y]!! + 1
    }

    // Topological sort
    val queue = ArrayDeque<Int>()
    // Start with all nodes that have 0 in-degree
    for ((node, deg) in inDegree) {
        if (deg == 0) {
            queue.add(node)
        }
    }

    val sorted = mutableListOf<Int>()
    while (queue.isNotEmpty()) {
        val current = queue.removeFirst()
        sorted.add(current)

        // Decrease in-degree of neighbors
        for (nbr in adjacency[current]!!) {
            inDegree[nbr] = inDegree[nbr]!! - 1
            if (inDegree[nbr] == 0) {
                queue.add(nbr)
            }
        }
    }

    // After topological sort, `sorted` should hold a valid order
    return sorted
}

