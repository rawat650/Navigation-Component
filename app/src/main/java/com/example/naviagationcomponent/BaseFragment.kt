package com.example.naviagationcomponent

import android.util.Patterns
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_register.*
import java.util.regex.Pattern

open class BaseFragment : Fragment() {
    fun fReplace(id: Int, fragment: Fragment) {
        requireActivity().supportFragmentManager.beginTransaction().replace(id, fragment)
    }

    fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }


    fun validation(): Boolean {
        val regex = ("[a-zA-Z]+").toRegex()
        if (!txtInputFirstName.text!!.toString().matches(regex)) {
            txtInputFirstName.apply {
                error = "editText contain only more than 3 three character  "
            }
            return false
        }
        if (!txtInputLastName.text!!.toString()
                .matches(regex)
        ) {
            txtInputLastName.apply {
                error = "editText contain only more than 3 three character  "
            }
            return false
        }
        if (txtPhoneNumber.text!!.toString().isEmpty()) {
            txtPhoneNumber.apply {
                error = "no should be not empty"
            }
            return false
        }
        if (email.text.toString()
                .isEmpty() && !Patterns.EMAIL_ADDRESS.matcher(email.text.toString()).matches()
        ) {
            email.apply {
                error = "field cannot be blank"
            }
            return false
        }
        if (passWordValidate()) {
            return true
        }
        if (confirmedPasswordValidate()) {
            return true
        }
        return true
    }

    fun passWordValidate(): Boolean {
        val passwordPattern = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$"
        val mPassWord = txtpassword.text.toString()
        if (txtpassword.text.toString().isEmpty()) {
            txtpassword.apply {
                error = "Field cannot be blank"
                requestFocus()
            }
            return false
        } else if (Pattern.compile(passwordPattern).matcher(mPassWord)
                .matches() && mPassWord.length >= 8
        ) {
            txtpassword.apply {
                error = null
            }
            txtpassword.requestFocus()
            return true
        } else {

            txtpassword.apply {
                error = "Password should be alphanumeric and 8 character long"
                requestFocus()
            }
            return false
        }
    }

    private fun confirmedPasswordValidate(): Boolean {
        if (txtCnfrmpassword.text.toString().isEmpty()) {
            txtCnfrmpassword.apply {
                error = "Field cannot be blank"
                requestFocus()
            }
            return false
        } else if (txtCnfrmpassword.text.toString() == txtCnfrmpassword.text.toString()) {
            txtCnfrmpassword.apply {
                error = null

            }
            txtCnfrmpassword.requestFocus()
            return true
        } else {
            txtCnfrmpassword.apply {
                error = "Confirmed password does not match"
                requestFocus()
            }
            return false
        }
    }
}


