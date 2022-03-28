package hr.ferit.taskie.di

import android.app.Application
import hr.ferit.taskie.data.TaskDao
import hr.ferit.taskie.data.TaskRepository
import hr.ferit.taskie.data.TaskRepositoryImpl
import hr.ferit.taskie.data.room.TaskDatabase
import hr.ferit.taskie.ui.task_details.TaskDetailsViewModel
import hr.ferit.taskie.ui.task_list.TaskListViewModel
import hr.ferit.taskie.ui.task_new.TaskNewViewModel
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