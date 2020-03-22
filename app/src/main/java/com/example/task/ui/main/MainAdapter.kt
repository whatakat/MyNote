package com.example.task.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


import androidx.recyclerview.widget.RecyclerView
import com.example.task.R
import com.example.task.data.entity.Note

class MainAdapter(private val onItemClickListener: OnItemClickListener): RecyclerView.Adapter<MainAdapter.NoteViewHolder>() {
    var notes:List<Note> = listOf()
    set(value){
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view  = inflater.inflate(R.layout.item_note,parent, false)
        return NoteViewHolder(view)
    }

    override fun getItemCount() = notes.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) =holder.bind(notes[position])

    inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val title = itemView.findViewById<TextView>(R.id.title)
        private val body = itemView.findViewById<TextView>(R.id.body)

        fun  bind(note: Note)= with(itemView){
            title.text = note.title
            body.text = note.text
            //itemView.setBackgroundColor(note.color)
            val color = when(note.color){
                Note.Color.WHITE -> R.color.color_white
                Note.Color.VIOLET -> R.color.color_violet
                Note.Color.YELLOW -> R.color.color_yellow
                Note.Color.RED -> R.color.color_red
                Note.Color.PINK -> R.color.color_pink
                Note.Color.GREEN -> R.color.color_green
                Note.Color.BLUE -> R.color.color_bluet
            }
            itemView.setBackgroundColor(itemView.context.resources.getColor(color))
            itemView.setOnClickListener { onItemClickListener.onItemClick(note) }
        }

    }

}
interface OnItemClickListener{
    fun onItemClick(note: Note)
}
