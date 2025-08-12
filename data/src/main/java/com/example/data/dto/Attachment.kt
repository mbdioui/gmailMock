package com.example.data.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Attachment(
    @SerialName("downloadUrl")
    val downloadUrl: String,
    @SerialName("filename")
    val filename: String,
    @SerialName("mimeType")
    val mimeType: String,
    @SerialName("size")
    val size: Int
)