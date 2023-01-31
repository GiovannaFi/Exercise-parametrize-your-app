package com.example.exercise2

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar

class BoredFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bored_fragment, container, false)
    }

   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       setHasOptionsMenu(true)
        view.findViewById<Button>(R.id.showAnswer).setOnClickListener {
            Snackbar.make(view, "Amedeo Modigliani", Snackbar.LENGTH_SHORT).show();
        }
       view.findViewById<TextView>(R.id.back).setOnClickListener {
           findNavController().navigateUp()
       }
    }

    override fun onCreateOptionsMenu(menu: Menu, menuinflater: MenuInflater) {
        menuinflater.inflate(R.menu.games_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.miGames -> {
                Toast.makeText(requireActivity().applicationContext, "Chose game!", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.miMusic -> {
                findNavController().navigate(R.id.action_boredFragment_to_boredSong)
                true
            }
            else -> {
                Toast.makeText(requireActivity().applicationContext, "Error", Toast.LENGTH_SHORT).show()
                true
            }
        }
    }

}