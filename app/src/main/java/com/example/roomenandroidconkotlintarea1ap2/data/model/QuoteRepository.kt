package com.example.roomenandroidconkotlintarea1ap2.data.model

import com.example.roomenandroidconkotlintarea1ap2.data.model.database.entities.QuoteEntity
import com.example.roomenandroidconkotlintarea1ap2.data.model.database.entities.dao.QuoteDao
import com.example.roomenandroidconkotlintarea1ap2.data.model.network.QuoteService
import com.example.roomenandroidconkotlintarea1ap2.domain.model.Quote
import com.example.roomenandroidconkotlintarea1ap2.domain.model.toDomain
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api : QuoteService,
    private val quoteDao: QuoteDao) {

    suspend fun getAllQuotesFromApi():List<Quote>{
        val response: List<QuoteModel> = api.getQuotes()
        return response.map{it.toDomain()}
    }

    suspend fun getAllQuotesFromDatabase():List<Quote>{
        val response = quoteDao.getAllQuote()
        return  response.map{it.toDomain()}
    }

    suspend fun insertQuotes(quotes:List<QuoteEntity>){
        quoteDao.insertAll(quotes)
    }

    suspend fun clearQuotes(){
        quoteDao.deleteAllQuotes()
    }
}