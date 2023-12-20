package com.example.practicalinterview.ui.di.core

import android.content.Context
import com.example.practicalinterview.ui.model.User
import com.google.gson.Gson
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppSession @Inject constructor(
    private val appPreferences: AppPreferences,
    private val context: Context
) : Session {
    private val gson = Gson()

    override var user: User? = null
        get() {
            if (field == null) {
                val userJSON = appPreferences.getString(Session.USER_JSON)
                field = gson.fromJson(userJSON, User::class.java)
            }
            return field
        }
        set(value) {
            field = value
            val userJSON = gson.toJson(value)
            if (userJSON != null)
                appPreferences.putString(Session.USER_JSON, userJSON)
        }


    override var userSession: String
        get() = appPreferences.getString(Session.USER_SESSION)
        set(value) = appPreferences.putString(Session.USER_SESSION, value)

}