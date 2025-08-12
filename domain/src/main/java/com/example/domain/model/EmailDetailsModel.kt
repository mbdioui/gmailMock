package com.example.domain.model


data class EmailDetailsModel(
    val id: String,
    val from: From,
    val to: List<To>,
    val cc: List<Cc>,
    val subject: String,
    val htmBody: String? = null,
    val plainBody: String,
    val date: String,
    val isImportant: Boolean,
    val isStarred: Boolean,
    val isPromotional: Boolean,
    val fileInfo: List<FileInfo>,
    val labels: List<String>
)

data class From(
    val email: String,
    val name: String
)

data class To(
    val email: String,
    val name: String
)

data class Cc(
    val email: String,
    val name: String
)


data class FileInfo(
    val createdAt: String
)