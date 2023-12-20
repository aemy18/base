package com.example.practicalinterview.ui.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("token")
    val token: String
)
