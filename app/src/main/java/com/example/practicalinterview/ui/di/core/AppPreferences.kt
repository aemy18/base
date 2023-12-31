package com.example.practicalinterview.ui.di.core

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppPreferences @Inject constructor(context: Context) {
    companion object {
        const val SHARED_PREF_NAME = "app_preference"
    }

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)

    @SuppressLint("CommitPrefEdits")
    fun putString(name: String, value: String) {
        val editor = sharedPreferences.edit()
        editor.putString(name, value)
        editor.apply()
    }

    fun getString(name: String): String {
        return sharedPreferences.getString(name, "") ?: ""
    }

    @SuppressLint("CommitPrefEdits")
    fun putBoolean(name: String, value: Boolean) {
        val editor = sharedPreferences.edit()
        editor.putBoolean(name, value)
        editor.apply()
    }

    fun getBoolean(name: String): Boolean {
        return sharedPreferences.getBoolean(name, false)
    }

    @SuppressLint("CommitPrefEdits")
    fun putFloat(name: String, value: Float) {
        val editor = sharedPreferences.edit()
        editor.putFloat(name, value)
        editor.apply()
    }

    fun getFloat(name: String): Float {
        return sharedPreferences.getFloat(name, 0F)
    }

    @SuppressLint("CommitPrefEdits")
    fun putInt(name: String, value: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt(name, value)
        editor.apply()
    }

    fun getInt(name: String): Int {
        return sharedPreferences.getInt(name, 0)
    }

    fun clearAll() {
        sharedPreferences.edit().clear().apply()
    }

}