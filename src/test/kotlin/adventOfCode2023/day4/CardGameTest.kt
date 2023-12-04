
package adventOfCode2023.day4

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CardGameTest{
    private val cardGame = CardGame()

    @Test
    fun `should return the card worth of 13`() {
        val expected =  13
        assertEquals(expected, cardGame.sumOfWorthPoints("src/test/kotlin/adventOfCode2023/day4/exampleInput.txt"))
    }

    @Test
    fun `should return the card worth`() {
        val expected =  21213
        assertEquals(expected, cardGame.sumOfWorthPoints("src/test/kotlin/adventOfCode2023/day4/programInput.txt"))
    }
}