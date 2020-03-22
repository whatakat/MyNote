package com.example.task.common

import android.content.Context
import androidx.core.content.ContextCompat
import com.example.task.R
import com.example.task.data.model.Note

fun Note.Color.getColorInt(context: Context) = ContextCompat.getColor(
    context, getColorRes()
)

fun Note.Color.getColorRes(): Int = when (this) {
    Note.Color.WHITE -> R.color.color_white
    Note.Color.YELLOW -> R.color.color_yellow
    Note.Color.GREEN -> R.color.color_green
    Note.Color.BLUE -> R.color.color_bluet
    Note.Color.RED -> R.color.color_red
    Note.Color.VIOLET -> R.color.color_violet
    Note.Color.PINK -> R.color.color_pink
}