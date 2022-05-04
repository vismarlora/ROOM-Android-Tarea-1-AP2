package com.example.roomenandroidconkotlintarea1ap2.domain

import com.example.roomenandroidconkotlintarea1ap2.data.model.QuoteModel
import com.example.roomenandroidconkotlintarea1ap2.data.model.QuoteRepository
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(private val repository : QuoteRepository) {

    suspend operator fun invoke() = repository.getAllQuotes()

}