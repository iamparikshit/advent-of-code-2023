package adventOfCode2023.day1

class SumOfDigitsAndWords {
    fun sumOfAllDigitsAndWords(input: String): Int {
        return input.split("\n")
            .sumOf { it.getSumOfDigitAndWords() }
    }

    private fun String.getSumOfDigitAndWords(): Int {
        val map = HashMap<Int, Data>()
        var count = 0

        val word = StringBuilder()
        for (index in this.indices) {
            word.append(this[index])

            if (this[index].isDigit()) {
                map[count] = Data(this[index].digitToInt(), index)
                word.delete(0, word.length)
            } else if (word.toString().contains("one")) {
                map[count] = Data(1, index - "one".length + 1)
                word.delete(0, word.length)
            } else if (word.toString().contains("two")) {
                map[count] = Data(2, index - "two".length + 1)
                word.delete(0, word.length)
            } else if (word.toString().contains("three")) {
                map[count] = Data(3, index - "three".length + 1)
                word.delete(0, word.length)
            } else if (word.toString().contains("four")) {
                map[count] = Data(4, index - "four".length + 1)
                word.delete(0, word.length)
            } else if (word.toString().contains("five")) {
                map[count] = Data(5, index - "five".length + 1)
                word.delete(0, word.length)
            } else if (word.toString().contains("six")) {
                map[count] = Data(6, index - "six".length + 1)
                word.delete(0, word.length)
            } else if (word.toString().contains("seven")) {
                map[count] = Data(7, index - "seven".length + 1)
                word.delete(0, word.length)
            } else if (word.toString().contains("eight")) {
                map[count] = Data(8, index - "eight".length + 1)
                word.delete(0, word.length)
            } else if (word.toString().contains("nine")) {
                map[count] = Data(9, index - "nine".length + 1)
                word.delete(0, word.length)
            }
            count++
        }

        if (this.contains("one")) {
            map[count] = Data(1, this.lastIndexOf("one"))
            count++
        }
        if (this.contains("two")) {
            map[count] = Data(2, this.lastIndexOf("two"))
            count++
        }
        if (this.contains("three")) {
            map[count] = Data(3, this.lastIndexOf("three"))
            count++
        }
        if (this.contains("four")) {
            map[count] = Data(4, this.lastIndexOf("four"))
            count++
        }
        if (this.contains("five")) {
            map[count] = Data(5, this.lastIndexOf("five"))
            count++
        }
        if (this.contains("six")) {
            map[count] = Data(6, this.lastIndexOf("six"))
            count++
        }
        if (this.contains("seven")) {
            map[count] = Data(7, this.lastIndexOf("seven"))
            count++
        }
        if (this.contains("eight")) {
            map[count] = Data(8, this.lastIndexOf("eight"))
            count++
        }
        if (this.contains("nine")) {
            map[count] = Data(9, this.lastIndexOf("nine"))
            count++
        }


        val list = map.values.sortedBy { it.index }
        val number =
            if (list.size > 1) (list[0].digit * 10) + list.last().digit else (list[0].digit * 10) + list[0].digit
        println("my number is $number and my value is $this")
        return number
    }

}

data class Data(
    val digit: Int,
    val index: Int
)

