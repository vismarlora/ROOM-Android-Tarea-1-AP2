package com.example.roomenandroidconkotlintarea1ap2.ui.view.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.roomenandroidconkotlintarea1ap2.data.model.QuoteModel
import com.example.roomenandroidconkotlintarea1ap2.data.model.quoteProvider

class quoteViewModel : ViewModel(){
    val quoteModel = MutableLiveData<QuoteModel>()
    fun randomQuote() {
        val currentQuote = quoteProvider.random()
        quoteModel.postValue(currentQuote)
    }
}