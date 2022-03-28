package hr.mosaicapps.animalcounter.di

import get
import hr.mosaicapps.animalcounter.model.AnimalCounter
import hr.mosaicapps.animalcounter.ui.animalcounting.viewmodels.AnimalCounterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModule = module {
    factory<AnimalCounter> { AnimalCounter() }
}

val viewModelModule = module {
    viewModel<AnimalCounterViewModel> { AnimalCounterViewModel(get()) }
}
