package com.example.task.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.task.R
import com.example.task.ui.note.NoteActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel
    lateinit var adapter: MainAdapter

    private fun openNoteScreen(note: Note?){
        val intent = NoteActivity.getStartIntent(this,note)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar as Toolbar?)//as Toolbar

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)


        adapter = MainAdapter(object : MainAdapter.onItemClickListener{
            override fun onItemClick(note: Note){
                openNoteScreen(note)
            }
        })


        viewModel.viewState().observe(this, Observer<MainViewState> {t ->
            t?.let { adapter.notes = it.notes }
        })
    }
}
