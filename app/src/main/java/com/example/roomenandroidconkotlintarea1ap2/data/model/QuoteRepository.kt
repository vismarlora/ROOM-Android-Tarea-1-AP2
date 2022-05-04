package com.example.roomenandroidconkotlintarea1ap2.data.model

import com.example.roomenandroidconkotlintarea1ap2.data.model.network.QuoteService
import javax.inject.Inject

class QuoteRepository @Inject constructor(private val api : QuoteService, private val quoteProvider: quoteProvider) {
    suspend fun getAllQuotes():List<QuoteModel>{
        val response = api.getQuotes()
        quoteProvider.quotes = response
        return response
    }
}