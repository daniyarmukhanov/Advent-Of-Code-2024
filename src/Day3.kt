class Day3 : AdventDay() {

    private val regex = Regex("""mul\((\d{1,3}),(\d{1,3})\)""")
    private val doRegex = Regex("""do\(\)""")
    private val dontRegex = Regex("""don't\(\)""")

    private val allRegex = Regex("$doRegex|$dontRegex|$regex")

    override fun getTestAnswer(input: List<String>): String {
        return ""
    }


    override fun getPart1(input: List<String>): String {
        var sum = 0
        input.forEach {
            val matches = regex.findAll(it)
            matches.forEach { m ->
                val (x, y) = m.groupValues.subList(1, 3)
                sum += x.toInt() * y.toInt()
            }
        }
        return sum.toString()
    }

    override fun getPart2(input: List<String>): String {
        var sum = 0
        var enabled = true
        input.forEach {
            val matches = allRegex.findAll(it)
            matches.forEach { m ->
                when {
                    doRegex.matches(m.groupValues.first()) -> enabled = true
                    dontRegex.matches(m.groupValues.first()) -> enabled = false
                    regex.matches(m.groupValues.first()) -> {
                        if (enabled) {
                            val (x, y) = m.groupValues.subList(1, 3)
                            sum += x.toInt() * y.toInt()
                        }
                    }
                }

            }
        }

        return sum.toString()
    }
}