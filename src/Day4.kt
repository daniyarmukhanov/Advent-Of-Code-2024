const val x = 'X'
const val m = 'M'
const val a = 'A'
const val s = 'S'

class Day4 : AdventDay() {

    override fun getTestAnswer(input: List<String>): String {
        val array = Array(input.size + 2) { CharArray(input.first().length + 2) }
        val parsed = parseInput(input, array)
        return countMAS(parsed).toString()
    }


    override fun getPart1(input: List<String>): String {
        val array = Array(input.size + 2) { CharArray(input.first().length + 2) }
        val parsed = parseInput(input, array)
        return countXMAS(parsed).toString()
    }

    override fun getPart2(input: List<String>): String {
        val array = Array(input.size + 2) { CharArray(input.first().length + 2) }
        val parsed = parseInput(input, array)
        return countMAS(parsed).toString()
    }
}

private fun parseInput(input: List<String>, array: Array<CharArray>): Array<CharArray> {
    for (i in array.indices) {
        for (j in array.first().indices) {
            array[i][j] = '.'
        }
    }

    for (i in 1..<array.size - 1) {
        for (j in 1..<array.first().size - 1) {
            array[i][j] = input[i - 1].toCharArray()[j - 1]
        }
    }
    return array
}

private fun countMAS(array: Array<CharArray>): Int {
    var count = 0
    for (i in array.indices) {
        for (j in array.first().indices) {
            if (array[i][j] == a) {
                if (array[i - 1][j - 1] == m) {
                    if (array[i + 1][j + 1] == s) {
                        //check 2 cases
                        if (array[i - 1][j + 1] == m) {
                            if (array[i + 1][j - 1] == s) {
                                count++
                            }
                        }
                        if (array[i - 1][j + 1] == s) {
                            if (array[i + 1][j - 1] == m) {
                                count++
                            }
                        }

                    }
                }


                if (array[i - 1][j - 1] == s) {
                    if (array[i + 1][j + 1] == m) {
                        //check 2 cases
                        if (array[i - 1][j + 1] == m) {
                            if (array[i + 1][j - 1] == s) {
                                count++
                            }
                        }
                        if (array[i - 1][j + 1] == s) {
                            if (array[i + 1][j - 1] == m) {
                                count++
                            }
                        }

                    }
                }

            }
        }
    }

    return count
}


private fun countXMAS(array: Array<CharArray>): Int {
    var count = 0
    for (i in array.indices) {
        for (j in array.first().indices) {
            if (array[i][j] == x) {
                if (array[i + 1][j] == m) {
                    if (array[i + 2][j] == a) {
                        if (array[i + 3][j] == s) {

                            count++
                        }
                    }
                }


                if (array[i - 1][j] == m) {
                    if (array[i - 2][j] == a) {
                        if (array[i - 3][j] == s) {

                            count++
                        }
                    }
                }


                if (array[i][j + 1] == m) {
                    if (array[i][j + 2] == a) {
                        if (array[i][j + 3] == s) {

                            count++
                        }
                    }
                }


                if (array[i][j - 1] == m) {
                    if (array[i][j - 2] == a) {
                        if (array[i][j - 3] == s) {

                            count++
                        }
                    }
                }


                if (array[i + 1][j + 1] == m) {
                    if (array[i + 2][j + 2] == a) {
                        if (array[i + 3][j + 3] == s) {

                            count++
                        }
                    }
                }


                if (array[i + 1][j - 1] == m) {
                    if (array[i + 2][j - 2] == a) {
                        if (array[i + 3][j - 3] == s) {

                            count++
                        }
                    }
                }


                if (array[i - 1][j + 1] == m) {
                    if (array[i - 2][j + 2] == a) {
                        if (array[i - 3][j + 3] == s) {

                            count++
                        }
                    }
                }


                if (array[i - 1][j - 1] == m) {
                    if (array[i - 2][j - 2] == a) {
                        if (array[i - 3][j - 3] == s) {

                            count++
                        }
                    }
                }
            }
        }
    }


    return count
}


