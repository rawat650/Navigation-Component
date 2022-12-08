package com.example.naviagationcomponent

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.naviagationcomponent.Repository.RegisterRepository

class RegisterFactory(val repo: RegisterRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return RegisterViewModel(repo) as T
    }
}