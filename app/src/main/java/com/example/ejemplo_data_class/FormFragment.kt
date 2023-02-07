package com.example.ejemplo_data_class

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.ejemplo_data_class.databinding.FragmentFormBinding
import com.example.ejemplo_data_class.model.User

class FormFragment : Fragment() {
    private var _binding: FragmentFormBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFormBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnJoin.setOnClickListener {
            if(!binding.name?.text.isNullOrEmpty() && !_binding?.lastname?.text.isNullOrEmpty() && !_binding?.age?.text.isNullOrEmpty()) {
                val name = _binding?.name?.text.toString()
                val lastName = _binding?.lastname?.text.toString()
                val age = _binding?.age?.text.toString().toInt()
                val user = User(name = name,lastname = lastName,age = age)
                val action = FormFragmentDirections.actionFormFragmentToResultFragment(user)
                findNavController().navigate(action)
                Log.e("tag","$user")
            } else {
                Toast.makeText(requireContext(), "Please add all the fields", Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}