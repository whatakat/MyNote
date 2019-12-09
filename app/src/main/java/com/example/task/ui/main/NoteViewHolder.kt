package com.example.task.ui.main

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.task.R
import com.example.task.data.model.Note


class NoteViewHolder(itemView:View ) : RecyclerView.ViewHolder(itemView) {
    private val title = itemView.findViewById<TextView>(R.id.title)
    private val body = itemView.findViewById<TextView>(R.id.body)

    fun  bind(note: Note){
        title.text = note.title
        body.text = note.note
        itemView.setBackgroundColor(note.color)
    }

}