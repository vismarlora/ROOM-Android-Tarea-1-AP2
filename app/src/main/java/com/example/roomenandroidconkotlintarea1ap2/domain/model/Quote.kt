package com.example.roomenandroidconkotlintarea1ap2.domain.model

import com.example.roomenandroidconkotlintarea1ap2.data.model.QuoteModel
import com.example.roomenandroidconkotlintarea1ap2.data.model.database.entities.QuoteEntity

data class Quote (val quote:String, val author:String)

fun QuoteModel.toDomain() = Quote(quote, author)
fun QuoteEntity.toDomain() = Quote(quote, author)