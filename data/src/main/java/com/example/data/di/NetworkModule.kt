package com.example.data.di

import com.example.data.remote.EmailsRepositoryImpl
import com.example.data.remote.api.ApiService
import com.example.domain.repository.EmailRepository
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

val NetworkModule = module {

    single<Json> {
        Json { ignoreUnknownKeys = true }
    }

    val baseUrlQualifier = named("BaseUrl")

    // Equivalent to: @Singleton @Provides fun provideHttpLoggingInterceptor()
    single<HttpLoggingInterceptor> {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    single<String>(qualifier = baseUrlQualifier) {
        "https://6895ea0d039a1a2b2890c897.mockapi.io"
    }

    // Equivalent to: @Singleton @Provides fun provideRetrofit(...)
    single<Retrofit> {
        val loggingInterceptor: HttpLoggingInterceptor = get() // Get HttpLoggingInterceptor
        val json: Json = get() // Get the Json instance
        val baseUrl: String = get(qualifier = baseUrlQualifier)
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(loggingInterceptor)
                    .build()
            )
            .build()
    }

    single<ApiService> {
        val retrofit: Retrofit = get()
        retrofit.create(ApiService::class.java)
    }

    single<EmailRepository> {
        EmailsRepositoryImpl(get())
    }

}
