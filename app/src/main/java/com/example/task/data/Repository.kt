package com.example.task.data
import com.example.task.data.model.entity.Note
import com.example.task.data.model.entity.Note.Color
import java.util.*

object Repository{
    private val notes: MutableList<Note> = mutableListOf(
        Note(
            id = UUID.randomUUID().toString(),
            title = "My first note",
            text = "Kotlin very brief, but expressive language",
            color = Color.WHITE
        ),
        Note(
            id = UUID.randomUUID().toString(),
            title = "My first note",
            text = "Kotlin very brief, but expressive language",
            color = Color.BLUE
        ),
        Note(
            id = UUID.randomUUID().toString(),
            title = "My first note",
            text = "Kotlin very brief, but expressive language",
            color = Color.GREEN
        ),
        Note(
            id = UUID.randomUUID().toString(),
            title = "My first note",
            text = "Kotlin very brief, but expressive language",
            color = Color.PINK
        ),
        Note(
            id = UUID.randomUUID().toString(),
            title = "My first note",
            text = "Kotlin very brief, but expressive language",
            color = Color.RED
        ),
        Note(
            id = UUID.randomUUID().toString(),
            title = "My first note",
            text = "Kotlin very brief, but expressive language",
            color = Color.YELLOW
        ), Note(
            id = UUID.randomUUID().toString(),
            title = "My first note",
            text = "Kotlin very brief, but expressive language",
            color = Color.VIOLET
        )

    )


    fun getNotes():List<Note>{
        return notes
    }

}
