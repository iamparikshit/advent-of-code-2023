package adventOfCode2023.day3

import java.io.File

class EngineSchematicWithGearRatio {
    fun sumOfEngineSchematic(path: String): Int {
        val inputList = File(path).readLines()
        val twoDimensionalArray = Array(inputList.size) { CharArray(inputList[0].length) }
        val map = HashMap<Pair<Int, Int>, Pair<Int, Int>>()
        val digit = StringBuilder()
        var sum = 0
        for (index in inputList.indices) {
            twoDimensionalArray[index] = inputList[index].getArray()
        }

        for (rowIndex in twoDimensionalArray.indices) {
            for (columnIndex in twoDimensionalArray[rowIndex].indices) {

                if (twoDimensionalArray[rowIndex][columnIndex].isDigit()) digit.append(twoDimensionalArray[rowIndex][columnIndex])
                else {
                    if (digit.isNotEmpty()) {
                        val starPosition = twoDimensionalArray.getPositionOfStarIfPresent(
                            columnIndex - digit.length,
                            columnIndex - 1,
                            rowIndex
                        )
                        updateResultMap(map, starPosition, digit)
                        digit.delete()
                    } else {
                        digit.delete()
                    }
                }
            }
            if (digit.isNotEmpty()) {
                val starPosition = twoDimensionalArray.getPositionOfStarIfPresent(
                    twoDimensionalArray[rowIndex].size - digit.length,
                    twoDimensionalArray[rowIndex].size - 1,
                    rowIndex
                )
                updateResultMap(map, starPosition, digit)
                digit.delete()
            }
        }

        map.filter { it.value.second == 2 }.map { sum += it.value.first }
        return sum
    }

    private fun updateResultMap(
        map: HashMap<Pair<Int, Int>, Pair<Int, Int>>,
        starPosition: Pair<Int, Int>,
        digit: StringBuilder
    ) {
        if (map.containsKey(starPosition)) {
            val initialValue = map[starPosition]!!
            map[starPosition] = Pair(initialValue.first * digit.toString().toInt(), initialValue.second + 1)
        } else map.put(starPosition, Pair(digit.toString().toInt(), 1))
    }

    private fun StringBuilder.delete() {
        this.delete(0, this.length)
    }

    private fun String.getArray(): CharArray {
        val array = CharArray(this.length)
        this.mapIndexed { index, char -> array[index] = char }
        return array
    }


    private fun Array<CharArray>.getPositionOfStarIfPresent(start: Int, end: Int, row: Int): Pair<Int, Int> {
        val rowIndex = if (row > 0) row - 1 else row
        val startIndex = if (start > 0) start - 1 else start
        val endIndex = if (end < this[0].size - 1) end + 1 else end
        val rowEndIndex = if (row < this.size - 1) row + 1 else row

        for (firstIndex in rowIndex..rowEndIndex) {
            for (secondIndex in startIndex..endIndex) {
                if (this[firstIndex][secondIndex] == '*') {
                    return Pair(firstIndex, secondIndex)
                }
            }
        }
        return Pair(-1, -1)
    }
}