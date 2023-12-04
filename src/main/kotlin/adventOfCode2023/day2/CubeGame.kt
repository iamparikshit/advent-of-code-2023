package adventOfCode2023.day2

import java.io.File

class CubeGame {
    fun sumOfIdForPossibleGames(filePath: String): Int {
        val inputList = File(filePath).readLines()
        return inputList.sumOf { it.getGameDetail() }

    }

    private fun String.getGameDetail() : Int{
        val gameDetail = this.split(":")
        val id = gameDetail[0].substring("GAME".length+1).toInt()
        val gameTurn = gameDetail[1]

        val isNotPossible = gameTurn.isGameNotPossible()
        println("game $id : possible : $isNotPossible")
        return if(isNotPossible) 0 else id
    }

    private fun String.isGameNotPossible(): Boolean {
        val input = this.trim()
        val list = mutableListOf<Colors>()

        var red = 0
        var blue = 0
        var green = 0
        for(index in input.indices){

            if (input[index] == ' ') continue
            else if (input[index].isDigit() && input[index + 1].isDigit()) {
                when (input[index + 3]) {
                    'r' -> red = input[index].digitToInt()*10 + input[index+1].digitToInt()
                    'b' -> blue = input[index].digitToInt()*10+input[index+1].digitToInt()
                    else -> green = input[index].digitToInt()*10+input[index+1].digitToInt()
                }
            } else if (input[index].isDigit()) {
                if(index!=0 && input[index-1].isDigit()) continue
                else {
                when (input[index + 2]) {
                    'r' -> red = input[index].digitToInt()
                    'b' -> blue = input[index].digitToInt()
                    else -> green = input[index].digitToInt()
                }}
            } else if (input[index] == ';') {
                list.add(Colors(red, blue, green))
                red = 0
                blue = 0
                green = 0
            } else if (index == input.lastIndex) {
                list.add(Colors(red, blue, green))
                red = 0
                blue = 0
                green = 0
            }
        }

        return list.any { it.red > 12 || it.blue > 14 || it.green > 13 }
    }
    data class Colors(
        val red: Int = 0,
        val blue: Int = 0,
        val green: Int = 0,
    )


}
