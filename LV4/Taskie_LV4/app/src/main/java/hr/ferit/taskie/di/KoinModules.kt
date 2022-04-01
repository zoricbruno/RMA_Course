package hr.ferit.taskie.di

import android.app.Application
import hr.ferit.taskie.data.TaskDao
import hr.ferit.taskie.data.repository.TaskRepository
import hr.ferit.taskie.data.repository.TaskRepositoryImpl
import hr.ferit.taskie.data.room.TaskDatabase
import hr.ferit.taskie.presentation.TaskDetailsViewModel
import hr.ferit.taskie.presentation.TaskListViewModel
import hr.ferit.taskie.presentation.TaskNewViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val databaseModule = module {
    fun provideDatabase(application: Application): TaskDatabase {
        return TaskDatabase.getDatabase(application)
    }
    fun provideTaskDao(database: TaskDatabase): TaskDao{
        return database.getTaskDao()
    }
    single<TaskDatabase> { provideDatabase(get()) }
    single<TaskDao> { provideTaskDao(get()) }
}

val repositoryModule = module {
    single<TaskRepository> { TaskRepositoryImpl(get()) }
}

val viewmodelModule = module {
    viewModel { TaskListViewModel(get())  }
    viewModel { TaskDetailsViewModel(get())  }
    viewModel { TaskNewViewModel(get())  }
}