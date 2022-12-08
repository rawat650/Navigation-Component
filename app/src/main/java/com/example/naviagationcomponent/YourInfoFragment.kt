package com.example.naviagationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.naviagationcomponent.model.Education


class YourInfoFragment : BaseFragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_your_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val eduAutoComplete = view.findViewById<AutoCompleteTextView>(R.id.eduAutoComplete)
        eduAutoComplete.setAdapter(
            ArrayAdapter<Education>(
                requireActivity(),
                com.google.android.material.R.layout.support_simple_spinner_dropdown_item,
                Education.values()
            )
        )
        val btnPrevious = view.findViewById<Button>(R.id.btnPrevious)
        btnPrevious.setOnClickListener {
            findNavController().apply {
                navigate(R.id.action_yourInfoFragment_to_registerFragment)
            }
        }
        val btnNxt = view.findViewById<Button>(R.id.btnNxt)
        btnNxt.setOnClickListener {
                findNavController().apply {
                    navigate(R.id.action_yourInfoFragment_to_addressInfoFragment)
                }


        }

    }
}

