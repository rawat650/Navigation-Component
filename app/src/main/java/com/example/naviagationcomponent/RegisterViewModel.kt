package com.example.naviagationcomponent

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.naviagationcomponent.Repository.RegisterRepository
import com.example.naviagationcomponent.model.Register
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegisterViewModel(val repository: RegisterRepository) : ViewModel() {

  /*  fun insertRegisterInfo(data: Register) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertAddress(data)
        }
    }*/
}