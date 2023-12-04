package adventOfCode2023.day1

class SumOfDigits {

    fun sumOfAllDigits(input: String): Int {
        return input.split("\n")
            .sumOf { it.getSumOfExtremeDigits() }
    }

    private fun String.getSumOfExtremeDigits(): Int {
        val digits = this.filter { it.isDigit() }.map { it.digitToInt() }

        return if (digits.size > 1) (digits[0] * 10) + digits.last() else (digits[0] * 10) + digits[0]
    }

//    fun sumOfAllDigits(input: String): Int {
//        var sum  = 0
//        input.split("\n")
//            .map { it.getSumOfExtremeDigits() }
//            .forEach { sum += it }
//        return sum
//    }
//
//    private fun String.getSumOfExtremeDigits(): Int {
//        val map = HashMap<Int, Int>()
//        var count = 0
//
//        this.map { it }
//            .filter { it.isDigit() }
//            .map {
//                count++
//                map.put(count, it.digitToInt())
//            }
//
//        val number = if (count > 1) (map[1]!! * 10) + map[count]!! else  (map[1]!! * 10) + map[1]!!
//
//        return number
//    }

}