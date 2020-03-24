package com.example.task.ui.splash

import com.example.task.data.NotesRepository
import com.example.task.data.errors.NoAuthException
import com.example.task.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class SplashViewModel(val notesRepository: NotesRepository) : BaseViewModel<Boolean?>() {

    fun requestUser() {
        launch {
            notesRepository.getCurrentUser()?.let {
                setData(true)
            } ?: setError(NoAuthException())
        }
    }

}