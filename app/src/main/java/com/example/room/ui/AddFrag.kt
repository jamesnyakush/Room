package com.example.room.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.example.room.R
import com.example.room.db.Note
import com.example.room.db.NoteDatabase
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.coroutines.launch

class AddFrag : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        save.setOnClickListener {
            val title = title.text.toString().trim()
            val noti = notify.text.toString().trim()

            if (title.isEmpty() && noti.isEmpty()) {
                Toast.makeText(context, "all fields required", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            launch {
                val note = Note(title, noti)

                context?.let {
                    NoteDatabase(it).getNoteDao().addNote(note)
                    Toast.makeText(context,"saved",Toast.LENGTH_LONG).show()
                }
            }


        }
    }
}
