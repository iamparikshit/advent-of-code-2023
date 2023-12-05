package adventOfCode2023.day5

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class AlmacWithSeedRangeTest{
    private val almacWithSeedRange = AlmacWithSeedRange()
    @Test
    fun `should return lowest location 35`() {
        assertEquals(46, almacWithSeedRange.findLowestLocation("src/test/kotlin/adventOfCode2023/day5/exampleInput.txt"))
    }

    @Test
    fun `should return lowest location`() {
        assertEquals(1181555926, almacWithSeedRange.findLowestLocation("src/test/kotlin/adventOfCode2023/day5/programInput.txt"))
    }
}