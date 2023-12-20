package com.example.practicalinterview.ui.di.core

import com.example.practicalinterview.ui.model.User

interface Session {
    var user:User?
    var userSession:String

    companion object{
        const val USER_JSON = "user_json"
        const val USER_SESSION ="user_session"
    }
}