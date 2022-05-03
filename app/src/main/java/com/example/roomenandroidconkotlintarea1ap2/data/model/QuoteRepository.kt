package com.example.roomenandroidconkotlintarea1ap2.data.model

import com.example.roomenandroidconkotlintarea1ap2.data.model.network.QuoteService

class QuoteRepository {
    private val api = QuoteService()
    suspend fun getAllQuotes():List<QuoteModel>{
        val response = api.getQuotes()
        quoteProvider.quotes = response
        return response
    }
}