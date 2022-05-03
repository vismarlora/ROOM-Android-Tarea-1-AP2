package com.example.roomenandroidconkotlintarea1ap2.data.model.network

import com.example.roomenandroidconkotlintarea1ap2.core.RetrofitHelper
import com.example.roomenandroidconkotlintarea1ap2.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class QuoteService {
    private val retrofit = RetrofitHelper.getRetrofit()
    suspend fun getQuotes(): List<QuoteModel> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(QuoteApiClient::class.java).getAllQuotes()
            response.body() ?: emptyList()
        }
    }
}