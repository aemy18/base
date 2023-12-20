package com.example.practicalinterview.ui.di.repository

import androidx.lifecycle.MutableLiveData
import com.example.practicalinterview.ui.SafeApiCall
import com.example.practicalinterview.ui.model.User
import com.example.practicalinterview.ui.model.requests.LoginRequest
import com.example.practicalinterview.ui.model.response.NetworkResult
import javax.inject.Inject


class UserRepository @Inject constructor(private val apiService: ApiService) {

    var _user = MutableLiveData<User?>()

    suspend fun login(request: LoginRequest) {
        val result = SafeApiCall.safeApiCall {
            apiService.login(request)
        }
        when (result) {
            is NetworkResult.Success -> {
                if (result.data.isSuccessful && result.data.body() != null) {
                    _user.postValue(result.data.body())
                }

            }

            else -> {
                _user.postValue(null)
            }
        }
    }
}