package adventOfCode2023.day2

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CubeGameTest{
    private val cubeGame = CubeGame()

    @Test
    fun `should return the sum`() {
        val expected = 2551
        assertEquals(expected, cubeGame.sumOfIdForPossibleGames("src/test/kotlin/adventOfCode2023/day2/input.txt"))
    }

    @Test
    fun `should return the 8`() {
        val expected = 8
        assertEquals(expected, cubeGame.sumOfIdForPossibleGames("src/test/kotlin/adventOfCode2023/day2/input1.txt"))
    }
}