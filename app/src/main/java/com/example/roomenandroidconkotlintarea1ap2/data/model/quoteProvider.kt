package com.example.roomenandroidconkotlintarea1ap2.data.model

import javax.inject.Inject
import javax.inject.Singleton

@Singleton

class quoteProvider @Inject constructor() {
        var quotes:List<QuoteModel> = emptyList()
}
