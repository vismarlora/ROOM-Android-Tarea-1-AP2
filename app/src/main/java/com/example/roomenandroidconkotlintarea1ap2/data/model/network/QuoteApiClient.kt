package com.example.roomenandroidconkotlintarea1ap2.data.model.network

import com.example.roomenandroidconkotlintarea1ap2.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiClient {
    @GET("/.json")
    suspend fun getAllQuotes(): Response<List<QuoteModel>>
}