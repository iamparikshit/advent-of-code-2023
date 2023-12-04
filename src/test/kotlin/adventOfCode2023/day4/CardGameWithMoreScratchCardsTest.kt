package adventOfCode2023.day4

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CardGameWithMoreScratchCardsTest{
    val cardGameWithMoreScratchCards = CardGameWithMoreScratchCards()

    @Test
    fun `should return the card worth of 30`() {
        val expected =  30
        assertEquals(expected, cardGameWithMoreScratchCards.sumOfWorthPointsWithMoreScratchCards("src/test/kotlin/adventOfCode2023/day4/exampleInput.txt"))
    }

    @Test
    fun `should return the card worth`() {
        val expected =  8549735
        assertEquals(expected, cardGameWithMoreScratchCards.sumOfWorthPointsWithMoreScratchCards("src/test/kotlin/adventOfCode2023/day4/programInput.txt"))
    }
}