package com.example.task.di

import com.example.task.data.NotesRepository
import com.example.task.data.provider.FireStoreProvider
import com.example.task.ui.main.MainViewModel
import com.example.task.ui.note.NoteViewModel
import com.example.task.ui.splash.SplashViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val appModule = module {
    single { FirebaseAuth.getInstance() }
    single { FirebaseFirestore.getInstance() }
    single { FireStoreProvider(get(), get()) }
    single { NotesRepository(get<FireStoreProvider>()) }
}

val splashModule = module {
    viewModel { SplashViewModel(get()) }
}

val mainModule = module {
    viewModel { MainViewModel(get()) }
}

val noteModule = module {
    viewModel { NoteViewModel(get()) }
}