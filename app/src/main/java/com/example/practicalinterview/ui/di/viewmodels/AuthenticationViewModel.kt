package com.example.practicalinterview.ui.di.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practicalinterview.ui.di.repository.UserRepository
import com.example.practicalinterview.ui.model.User
import com.example.practicalinterview.ui.model.requests.LoginRequest
import kotlinx.coroutines.launch
import javax.inject.Inject

class AuthenticationViewModel @Inject constructor(private val userRepository: UserRepository) :
    ViewModel() {

    val user: LiveData<User?>
        get() {
            return userRepository._user
        }

    fun loadLogin(request: LoginRequest) {
        viewModelScope.launch {
            userRepository.login(request)
        }
    }
}