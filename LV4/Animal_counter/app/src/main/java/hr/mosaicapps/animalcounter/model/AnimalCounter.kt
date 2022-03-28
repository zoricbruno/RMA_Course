package hr.mosaicapps.animalcounter.model

class AnimalCounter {
    var dogsSeen: Int = 0
        private set
    var catsSeen: Int = 0
        private set
    val animalsSeen
        get() = dogsSeen + catsSeen

    fun seeDog() = dogsSeen++
    fun seeCat() = catsSeen++
}