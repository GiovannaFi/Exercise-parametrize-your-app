package com.example.exercise2

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Button
import android.widget.Toast
import androidx.navigation.fragment.findNavController

class FirstFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)

        view.findViewById<Button>(R.id.bored).setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_boredFragment)
        }
        view.findViewById<Button>(R.id.sad).setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_sadFragment)
        }
        view.findViewById<Button>(R.id.angry).setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_angryFragment)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, menuinflater: MenuInflater) {
        menuinflater.inflate(R.menu.app_bar_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.miSettings -> {
                Toast.makeText(requireActivity().applicationContext, "Settings chosen", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.miFavorites -> {
                Toast.makeText(requireActivity().applicationContext, "Favorites chosen", Toast.LENGTH_SHORT).show()
                true
            }
            else -> {
                Toast.makeText(requireActivity().applicationContext, "Logout chosen", Toast.LENGTH_SHORT).show()
                true
            }
        }
    }


}