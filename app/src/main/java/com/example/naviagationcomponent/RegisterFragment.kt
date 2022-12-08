package com.example.naviagationcomponent

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.naviagationcomponent.Repository.RegisterRepository
import com.example.naviagationcomponent.db.RegisterDb
import com.example.naviagationcomponent.db.SharePrefrence
import com.example.naviagationcomponent.model.Register
import kotlinx.android.synthetic.main.fragment_register.*

class RegisterFragment : BaseFragment() {
//    lateinit var viewModel:RegisterViewModel
    lateinit var selectGender:String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var isAllFieldsChecked = false
        val btnNext = view?.findViewById<Button>(R.id.btnNext)
        btnNext?.setOnClickListener {
            isAllFieldsChecked = validation()
            if (isAllFieldsChecked) {
                findNavController().apply {
                    navigate(R.id.action_registerFragment_to_yourInfoFragment)
                }
            }
            createUser()
        }
    /*    val repository = RegisterRepository(RegisterDb(requireContext()))
        val viewModelProviderFactory = RegisterFactory(repository)
        viewModel  = ViewModelProvider(
            requireActivity(),
            viewModelProviderFactory
        ).get(RegisterViewModel::class.java)*/
    }
         fun createUser() {
            val radioId = radioGroupButton!!.checkedRadioButtonId
            when (radioId) {
                R.id.radioBtnMale -> selectGender = "M"
                R.id.radioBtnFemale -> selectGender = "F"
            }


            selectGender?.let {
                Log.d("Test", selectGender!!)
                SharePrefrence.getInstance(requireContext()).saveUser(Register(0,tvfirstname.text.toString(),txtInputLastName.text.toString(),txtPhoneNumber.text.toString().toInt(),email.text.toString(),it,txtpassword.text.toString(),txtCnfrmpassword.text.toString()))
            }

        }
    }


