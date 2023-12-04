package adventOfCode2023.day2

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CubeGameWithoutConfigurationTest{
    private val cubeGameWithoutConfiguration = CubeGameWithoutConfiguration()

    @Test
    fun `should return 2286`() {
        val expected = 2286
        assertEquals(expected, cubeGameWithoutConfiguration.sumOfIdForPossibleGames("src/test/kotlin/adventOfCode2023/day2/input1.txt"))
    }

    @Test
    fun `should return sum`() {
        val expected = 62811
        assertEquals(expected, cubeGameWithoutConfiguration.sumOfIdForPossibleGames("src/test/kotlin/adventOfCode2023/day2/input.txt"))
    }
}