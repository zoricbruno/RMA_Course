package hr.mosaicapps.animalcounter.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData

class AnimalCounterAlternative {
    private val _dogsSeen: MutableLiveData<Int> = MutableLiveData<Int>(0)
    val dogsSeen: LiveData<Int> = _dogsSeen
    private val _catsSeen: MutableLiveData<Int> = MutableLiveData<Int>(0)
    val catsSeen: LiveData<Int> = _catsSeen
    val animalsSeen: MediatorLiveData<Int> = MediatorLiveData<Int>().apply {
        fun update() =  postValue((_catsSeen.value ?: 0) + (_dogsSeen.value ?: 0))
        addSource(_dogsSeen) { update() }
        addSource(_catsSeen) { update() }
    }

    fun seeDog() = _dogsSeen.value?.let { _dogsSeen.postValue(it + 1) }
    fun seeCat() = _catsSeen.value?.let { _catsSeen.postValue(it + 1) }
}