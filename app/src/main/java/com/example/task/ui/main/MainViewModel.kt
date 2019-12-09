package com.example.task.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.task.data.Repositiry

class MainViewModel:ViewModel() {
    private val viewStateLiveData:MutableLiveData<MainViewState> =
            MutableLiveData()
           init {
               viewStateLiveData.value = MainViewState(Repositiry.getNotes())
           }
    fun viewState(): LiveData<MainViewState> = viewStateLiveData
}