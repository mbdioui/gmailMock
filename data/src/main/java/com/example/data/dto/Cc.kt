package com.example.data.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Cc(
    @SerialName("email")
    val email: String,
    @SerialName("name")
    val name: String
)