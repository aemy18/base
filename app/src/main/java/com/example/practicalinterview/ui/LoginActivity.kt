package com.example.practicalinterview.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.practicalinterview.databinding.LoginActivityBinding
import com.example.practicalinterview.ui.di.components.DaggerApplicationComponent
import com.example.practicalinterview.ui.di.viewmodels.AuthenticationViewModel
import com.example.practicalinterview.ui.model.requests.LoginRequest
import javax.inject.Inject

class LoginActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModeFactory: ViewModelFactory

    private lateinit var authenticationViewModel: AuthenticationViewModel

    private lateinit var binding: LoginActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        DaggerApplicationComponent.factory().create(this).inject(this)

        authenticationViewModel =
            ViewModelProvider(this, viewModeFactory)[AuthenticationViewModel::class.java]
        getObserverData()

        loadLogin()
    }

    private fun loadLogin() {
        authenticationViewModel.loadLogin(LoginRequest("eve.holt@reqres.in", "cityslicka"))
    }

    private fun getObserverData() {
        authenticationViewModel.user.observe(this) {
            Log.d("TEST", "User is :${it?.token}")
        }
    }
}