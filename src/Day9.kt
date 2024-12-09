class Day9 : AdventDay() {
    override fun getTestAnswer(input: List<String>): String {
        val step1 = jazu(input.first())

        val step2 = nukteler(step1)
        val step3 = checkSum(step2)
        return step3
    }

    override fun getPart1(input: List<String>): String {
        val step1 = jazu(input.first())

        val step2 = nukteler(step1)
        val step3 = checkSum(step2)
        return step3
    }

    override fun getPart2(input: List<String>): String {
        TODO("Not yet implemented")
    }

    private fun jazu(numbers: String): Array<Long> {
        val result = mutableListOf<Long>()
        var isDot = false
        var index = 0L
        numbers.forEach { char ->
            repeat(char.digitToInt()) {
                result.add(
                    if (isDot) {
                        -1L
                    } else {
                        index
                    }
                )
            }
            if (isDot.not()) {
                index++
            }
            isDot = isDot.not()
        }
        return result.toTypedArray()
    }

    private fun nukteler(array: Array<Long>): Array<Long> {

        fun swapWithLastDigit(index: Int) {
            val temp = array[index]
            val indexOfLastDigit = array.indexOfLast { it >= 0 }
            if (indexOfLastDigit < index) {
                return
            }
            array[index] = array[indexOfLastDigit]
            array[indexOfLastDigit] = temp
        }

        array.forEachIndexed { index, number ->
            if (number == -1L) {
                swapWithLastDigit(index)
            }
        }

        return array
    }

    private fun checkSum(array: Array<Long>): String {
        var sum = 0L
        array.forEachIndexed { index, number ->
            if (number >= 0) {
                sum += number * index
            }
        }
        return sum.toString()
    }
}