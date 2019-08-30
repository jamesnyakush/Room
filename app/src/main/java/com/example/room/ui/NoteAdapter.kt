package com.example.room.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.room.R
import com.example.room.db.Note
import kotlinx.android.synthetic.main.item.view.*

class NoteAdapter(val notes: List<Note>) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        )
    }
    override fun getItemCount() = notes.size
    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.view.titletv.text = notes[position].title
        holder.view.texttv.text = notes[position].note
    }
    class NoteViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}