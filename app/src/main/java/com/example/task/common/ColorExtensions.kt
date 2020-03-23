package com.example.task.common

import android.content.Context
import androidx.core.content.ContextCompat
import com.example.task.R
import com.example.task.data.entity.Note

fun Note.Color.getColorInt(context: Context) = ContextCompat.getColor(
    context, getColorRes()
)

fun Note.Color.getColorRes(): Int = when (this) {
    Note.Color.WHITE -> R.color.white
    Note.Color.YELLOW -> R.color.yellow
    Note.Color.GREEN -> R.color.green
    Note.Color.BLUE -> R.color.bluet
    Note.Color.RED -> R.color.red
    Note.Color.VIOLET -> R.color.violet
    Note.Color.PINK -> R.color.pink
}