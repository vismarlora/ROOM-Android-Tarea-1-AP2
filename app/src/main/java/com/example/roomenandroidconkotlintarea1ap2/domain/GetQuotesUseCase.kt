package com.example.roomenandroidconkotlintarea1ap2.domain

import com.example.roomenandroidconkotlintarea1ap2.data.model.QuoteModel
import com.example.roomenandroidconkotlintarea1ap2.data.model.QuoteRepository
import com.example.roomenandroidconkotlintarea1ap2.data.model.database.entities.toDatabase
import com.example.roomenandroidconkotlintarea1ap2.domain.model.Quote
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(private val repository : QuoteRepository) {

    suspend operator fun invoke():List<Quote>{
        val quotes = repository.getAllQuotesFromApi()

        return if(quotes.isNotEmpty()) {
            repository.clearQuotes()
            repository.insertQuotes(quotes.map{it.toDatabase()})
            quotes
        }else{
            repository.getAllQuotesFromDatabase()
        }
    }

}