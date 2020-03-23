package com.example.task.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup



import androidx.recyclerview.widget.RecyclerView
import com.example.task.R
import com.example.task.common.getColorInt
import com.example.task.data.entity.Note
import kotlinx.android.extensions.LayoutContainer

class NotesRVAdapter(val onItemClick: ((Note)-> Unit)? = null) : RecyclerView.Adapter<NotesRVAdapter.ViewHolder>() {

    var notes: List<Note> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_note,
            parent,
            false
        )
    )

    override fun getItemCount() = notes.size

    override fun onBindViewHolder(vh: ViewHolder, pos: Int) = vh.bind(notes[pos])

    inner class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer {

        fun bind(note: Note) = with(itemView) {
            tv_title.text = note.title
            tv_text.text = note.text

            itemView.setBackgroundColor(note.color.getColorInt(context))
            itemView.setOnClickListener {
                onItemClick?.invoke(note)
            }
        }

    }

}