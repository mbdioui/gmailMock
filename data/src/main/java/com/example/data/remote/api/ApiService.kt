package com.example.data.remote.api

import com.example.data.dto.EmailDetailDto
import com.example.data.dto.EmailListItemDto
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("api/v1/emailList")
    suspend fun getEmails(): Response<List<EmailListItemDto>>

    @GET("api/v1/emaildetails")
    suspend fun getEmailDetails(): Response<List<EmailDetailDto>>
}