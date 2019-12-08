package com.example.task.data

import com.example.task.data.model.Note

object Repositiry{
    private val notes: List<Note>
    init {
        notes = listOf(
            Note("My first note",
                "Kotlin very thin, but expressive language",
                0xfff06292.toInt()),
            Note("My first note",
                "Kotlin very thin, but expressive language",
                0xff9575cd.toInt()),
            Note("My first note",
                "Kotlin very thin, but expressive language",
                0xfff64b5f6.toInt()),
            Note("My first note",
                "Kotlin very thin, but expressive language",
                0xfff4db6ac.toInt()),
            Note("My first note",
                "Kotlin very thin, but expressive language",
                0xffb2ff59.toInt()),
            Note("My first note",
                "Kotlin very thin, but expressive language",
                0xffffeb3b.toInt())

        )
    }
    fun getNotes():List<Note>{
        return notes
    }

}
