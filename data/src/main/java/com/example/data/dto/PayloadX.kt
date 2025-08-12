package com.example.data.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PayloadX(
    @SerialName("attachments")
    val attachments: List<Attachment>,
    @SerialName("cc")
    val cc: List<Cc>,
    @SerialName("date")
    val date: String,
    @SerialName("from")
    val from: From,
    @SerialName("suject")
    val suject: String,
    @SerialName("to")
    val to: List<To>
)