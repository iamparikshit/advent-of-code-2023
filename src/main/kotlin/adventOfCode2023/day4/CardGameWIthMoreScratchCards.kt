package adventOfCode2023.day4

import java.io.File

class CardGameWithMoreScratchCards {
    fun sumOfWorthPointsWithMoreScratchCards(path: String): Int {
        val inputList = File(path).readLines()
        val hashMap = HashMap<Int, Int>()
        var count = 0
        inputList.asReversed().map { it.getCardGameDetail() }
            .map { card ->
                count = 0
                card.userSelectedCards.filter { card.winningList.contains(it) }.map { count++ }
                var prefixSum = 0
                if (count > 0) {
                    for (index in 1..count) {
                        prefixSum += hashMap[card.cardId + index]!!
                    }
                }
                hashMap.put(card.cardId, prefixSum + 1)
            }
        return hashMap.values.sum()

    }

    private fun String.getCardGameDetail(): Card {
        val winningCardsIndexPosition = 0
        val userSelectedCardsIndexPosition = 1

        val input = this.split(":")
        val cardId = input[0].split("Card")[1].trim()
        val winningListAndInputList = input[1]
        val list = winningListAndInputList.split("|")
        val winningCards = list.getCardPoints(winningCardsIndexPosition)
        val userSelectedCards = list.getCardPoints(userSelectedCardsIndexPosition)

        return Card(cardId.toInt(), winningCards, userSelectedCards)
    }

    private fun List<String>.getCardPoints(indexPosition: Int): List<String> {
        return this[indexPosition].trim().split(" ").filter { it.isNotBlank() }
    }
}

data class Card(
    val cardId: Int,
    val winningList: List<String>,
    val userSelectedCards: List<String>
)
