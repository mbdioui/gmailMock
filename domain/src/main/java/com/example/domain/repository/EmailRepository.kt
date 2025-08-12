package com.example.domain.repository

import com.example.core.ApiResponse
import com.example.domain.model.EmailDetailsModel
import com.example.domain.model.EmailListItemModel

interface EmailRepository {
    suspend fun getEmails(): ApiResponse<List<EmailListItemModel>>
    suspend fun getEmailDetails(): ApiResponse<List<EmailDetailsModel>>
}