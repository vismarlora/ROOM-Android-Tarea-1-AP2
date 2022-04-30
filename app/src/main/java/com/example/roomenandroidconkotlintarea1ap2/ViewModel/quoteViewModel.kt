package com.example.roomenandroidconkotlintarea1ap2.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.roomenandroidconkotlintarea1ap2.model.QuoteModel
import com.example.roomenandroidconkotlintarea1ap2.model.quoteProvider

class quoteViewModel : ViewModel(){
    val quoteModel = MutableLiveData<QuoteModel>()
    fun randomQuote() {
        val currentQuote = quoteProvider.random()
        quoteModel.postValue(currentQuote)
    }
}