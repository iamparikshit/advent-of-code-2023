package adventOfCode2023.day3

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class EngineSchematicWithGearRatioTest{
    private val engineSchematicWithGearRatio = EngineSchematicWithGearRatio()

    @Test
    fun `should return 467835`() {
        val expected = 467835
        assertEquals(expected, engineSchematicWithGearRatio.sumOfEngineSchematic("src/test/kotlin/adventOfCode2023/day3/exampleInput.txt"))
    }

    @Test
    fun `should return sum`() {
        val expected = 80703636
        assertEquals(expected, engineSchematicWithGearRatio.sumOfEngineSchematic("src/test/kotlin/adventOfCode2023/day3/programInput.txt"))
    }
}