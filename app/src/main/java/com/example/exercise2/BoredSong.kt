package com.example.exercise2

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar

class BoredSong : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bored_song, container, false)

    }

    private lateinit var ring: View
    private lateinit var mediaPlayer: MediaPlayer

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ring = view.findViewById(R.id.play)
        mediaPlayer = MediaPlayer.create(requireContext(), R.raw.the_wall)

        ring.setOnClickListener {
            mediaPlayer.start()
        }


        view.findViewById<Button>(R.id.showAnswer).setOnClickListener {
            Snackbar.make(view, "The Wall by Pink Floyd", Snackbar.LENGTH_SHORT).show();
        }
        view.findViewById<TextView>(R.id.back).setOnClickListener {
            findNavController().navigateUp()
        }

    }

}

