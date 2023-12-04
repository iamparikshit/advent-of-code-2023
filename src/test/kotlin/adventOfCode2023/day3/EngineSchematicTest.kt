package adventOfCode2023.day3

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class EngineSchematicTest{
    private val engineSchematic = EngineSchematic()

    @Test
    fun `should return 4361`() {
        val expected = 4361
        assertEquals(expected, engineSchematic.sumOfEngineSchematic("src/test/kotlin/adventOfCode2023/day3/exampleInput.txt"))
    }

    @Test
    fun `should return sum`() {
        val expected = 539590
        assertEquals(expected, engineSchematic.sumOfEngineSchematic("src/test/kotlin/adventOfCode2023/day3/programInput.txt"))
    }
}