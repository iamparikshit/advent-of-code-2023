package adventOfCode2023.day4

import java.io.File

class CardGame {
    fun sumOfWorthPoints(path: String): Int {
        val inputList = File(path).readLines()
        var sum = 0
        inputList.map { it.getWinnningAndInputList() }
            .map { pair ->
                var cardValue = 0
                pair.second.filter { pair.first.contains(it) }.map {
                    if (cardValue == 0) cardValue++
                    else cardValue *= 2
                    cardValue
                }
                println("card value is $cardValue for ${pair.first}")
                sum += cardValue
            }
        return sum
    }

    private fun String.getWinnningAndInputList(): Pair<List<String>, List<String>> {
        val winningCardsIndexPosition = 0
        val userSelectedCardsIndexPosition = 1
        val winningAndInputList = this.split(":")[1]
        val list = winningAndInputList.split("|")
        val winningCards = list.getCards(winningCardsIndexPosition)
        val userSelectedCards = list.getCards(userSelectedCardsIndexPosition)

        return Pair(winningCards, userSelectedCards)
    }

    private fun List<String>.getCards(indexPosition: Int): List<String> {
        return this[indexPosition].trim().split(" ").filter {  it.isNotBlank() }
    }
}