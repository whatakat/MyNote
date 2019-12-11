package com.example.task.ui.main

import android.content.res.Resources
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
        val color = when(note.color){
            Color.WHITE ->R.color.color_white
            Color.VIOLET -> R.color.color_violet
            Color.YELLOW -> R.color.color_yellow
            Color.RED -> R.color.color_red
            Color.PINK -> R.color.color_pink
            Color.GREEN -> R.color.color_green
            Color.BLUE -> R.color.color_bluet
        }
        itemView.setBackgroundColor(itemView.context.resources.getColor(color))
    }

}