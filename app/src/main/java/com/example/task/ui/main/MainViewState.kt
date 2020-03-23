package com.example.task.ui.main

import com.example.task.data.entity.Note
import com.example.task.ui.base.BaseViewState

class MainViewState(val notes: List<Note>? = null, error: Throwable? = null) : BaseViewState<List<Note>?>(notes, error)