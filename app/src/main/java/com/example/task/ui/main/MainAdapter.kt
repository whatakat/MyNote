package com.example.task.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup



import androidx.recyclerview.widget.RecyclerView
import com.example.task.R
import com.example.task.data.model.Note

class MainAdapter: RecyclerView.Adapter<NoteViewHolder>() {
    var notes:List<Note> = listOf()
    set(value){
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view  = inflater.inflate(R.layout.activity_main,parent, false) //item_note?
        return NoteViewHolder(view)
    }

    override fun getItemCount() = notes.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) : Unit {
        holder.bind(notes[position])
    }
}
interface OnItemClickListener{
    fun onItemClick(note:Note)
}