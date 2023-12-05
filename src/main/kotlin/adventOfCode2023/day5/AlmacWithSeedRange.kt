package adventOfCode2023.day5

import java.io.File

class AlmacWithSeedRange {
    fun findLowestLocation(path : String): Long {
        val inputList = File(path).readLines()
        val seedList = inputList[0].split(":")[1].trim().split(" ").filter { it.isNotEmpty() }.map { it.toLong() }

        val seedToSoilInput = inputList.getMappingInList("seed-to-soil map")
        val soilToFertilizerInput = inputList.getMappingInList("soil-to-fertilizer map")
        val fertilizerToWaterInput = inputList.getMappingInList("fertilizer-to-water map")
        val waterToLightInput = inputList.getMappingInList("water-to-light map")
        val lightToTemperature = inputList.getMappingInList("light-to-temperature map")
        val temperatureToHumidity = inputList.getMappingInList("temperature-to-humidity map")
        val humidityToLocation = inputList.getMappingInList("humidity-to-location map")
        var minCountOfLocation : Long = Long.MAX_VALUE

        var index = 0
        while(index < seedList.lastIndex-1){
            val start = seedList[index]
            val end = seedList[index] + seedList[index+1] -1

            for(seed in start..end){
                val soil = seedToSoilInput.getValue(seed)
                val fertilizer = soilToFertilizerInput.getValue(soil)
                val water = fertilizerToWaterInput.getValue(fertilizer)
                val light = waterToLightInput.getValue(water)
                val temperature = lightToTemperature.getValue(light)
                val humidity = temperatureToHumidity.getValue(temperature)
                val location = humidityToLocation.getValue(humidity)


                if(minCountOfLocation > location) minCountOfLocation = location
            }
            index += 2
        }
        return minCountOfLocation
    }

    private fun List<String>.getMappingInList( nameToFind : String) : List<String> {
        val list = mutableListOf<String>()
        for(index in this.indexOf("$nameToFind:")+1..this.lastIndex){
            if(this[index].isEmpty() ) break
            list.add(this[index])
        }
        return list
    }
    private fun List<String>.getValue(number : Long): Long {
        var value = -1L
        var inputList : List<String>
        var destination : Long
        var source : Long
        var range : Long
        this.map {
            inputList = it.split(" ")
            destination = inputList[0].toLong()
            source = inputList[1].toLong()
            range = inputList[2].toLong()

            if(number in source..source+range){
                if(source==number) return destination
                value = destination + number-source
            }
        }
        return if(value == -1L) number else value
    }
}