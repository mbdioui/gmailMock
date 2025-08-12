package com.example.data.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EmailDetailDto(
    @SerialName("body")
    val body: Body,
    @SerialName("id")
    val id: String,
    @SerialName("payload")
    val payload: PayloadX,
    @SerialName("snippet")
    val snippet: String,
    @SerialName("threadId")
    val threadId: String
)