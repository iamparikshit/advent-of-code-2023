package adventOfCode2023.day5

import java.io.File

class Almac {
    fun findLowestLocation(path : String): Long {
        val inputList = File(path).readLines()
        val seed = inputList[0].split(":")[1].trim().split(" ").filter { it.isNotEmpty() }.map { it.toLong() }
        val seedToSoilInput = inputList.getMappingInList("seed-to-soil map")
        val soilToFertilizerInput = inputList.getMappingInList("soil-to-fertilizer map")
        val fertilizerToWaterInput = inputList.getMappingInList("fertilizer-to-water map")
        val waterToLightInput = inputList.getMappingInList("water-to-light map")
        val lightToTemperature = inputList.getMappingInList("light-to-temperature map")
        val temperatureToHumidity = inputList.getMappingInList("temperature-to-humidity map")
        val humidityToLocation = inputList.getMappingInList("humidity-to-location map")
//        val seedToSoilMap = seedToSoilInput.getMap()
//        val soilToFertilizerMap = soilToFertilizerInput.getMap()
//        val fertilizerToWaterMap = fertilizerToWaterInput.getMap()
//        val waterToLightMap = waterToLightInput.getMap()
//        val lightToTemperatureMap = lightToTemperature.getMap()
//        val temperatureToHumidityMap = temperatureToHumidity.getMap()
//        val humidityToLocationMap = humidityToLocation.getMap()
        var minCountOfLocation : Long = Long.MAX_VALUE

        seed.map { seed ->
            val soil = seedToSoilInput.getValue(seed)
            val fertilizer = soilToFertilizerInput.getValue(soil)
            val water = fertilizerToWaterInput.getValue(fertilizer)
            val light = waterToLightInput.getValue(water)
            val temperature = lightToTemperature.getValue(light)
            val humidity = temperatureToHumidity.getValue(temperature)
            val location = humidityToLocation.getValue(humidity)


            if(minCountOfLocation > location) minCountOfLocation = location
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

    private fun List<String>.getMap() : HashMap<Long, Long>{
        val map = HashMap<Long, Long>()
        this.map {
            val inputList = it.split(" ")
            val destination = inputList[0].toLong()
            val source = inputList[1].toLong()
            val range = inputList[2].toLong()

            for(index in 0..< range)
            {
                map.put(source+index, destination+index)
            }
        }
        return map
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

    private fun Long.getValue(map : HashMap<Long, Long>): Long {
        return if(map.containsKey(this)) map[this]!! else this
    }
}


//read
//seeds: 79 14 55 13
//
//seed-to-soil map:
//50 98 2
//52 50 48
//
//soil-to-fertilizer map:
//0 15 37
//37 52 2
//39 0 15
//
//fertilizer-to-water map:
//49 53 8
//0 11 42
//42 0 7
//57 7 4
//
//water-to-light map:
//88 18 7
//18 25 70
//
//light-to-temperature map:
//45 77 23
//81 45 19
//68 64 13
//
//temperature-to-humidity map:
//0 69 1
//1 0 69
//
//humidity-to-location map:
//60 56 37
//56 93 4