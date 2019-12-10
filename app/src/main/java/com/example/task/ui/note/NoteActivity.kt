package com.example.task.ui.note

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.task.R
import com.example.task.data.model.Note
import kotlinx.android.synthetic.main.activity_note.*
import java.text.SimpleDateFormat
import java.util.*

class NoteActivity: AppCompatActivity() {
    companion object{
        private val EXTRA_NOTE = NoteActivity::class.java.name+"extra.NOTE"

        fun getStartIntent(context: Context, note: Note?): Intent{
            val intent = Intent(context, NoteActivity::class.java)
            intent.putExtra(EXTRA_NOTE, note)
            return intent
        }
    }
    private var note: Note? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)

        note = intent.getParcelableExtra(EXTRA_NOTE)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        supportActionBar?.title = if(note != null){
            SimpleDateFormat(DATE_TIME_FORMAT,
                Locale.getDefault()).format(note!!.lastChanged)
        }else{
            getString(R.string.new_note_title)
        }
        initView()
    }
}