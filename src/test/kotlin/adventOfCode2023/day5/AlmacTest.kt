package adventOfCode2023.day5

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class AlmacTest{
    private val almac = Almac()

    @Test
    fun `should return lowest location 35`() {
        assertEquals(35L, almac.findLowestLocation("src/test/kotlin/adventOfCode2023/day5/exampleInput.txt"))
    }

    @Test
    fun `should return lowest location`() {
        assertEquals(1181555926, almac.findLowestLocation("src/test/kotlin/adventOfCode2023/day5/programInput.txt"))
    }
}