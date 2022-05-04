package com.example.roomenandroidconkotlintarea1ap2.ui.view.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomenandroidconkotlintarea1ap2.data.model.QuoteModel
import com.example.roomenandroidconkotlintarea1ap2.domain.GetQuotesUseCase
import com.example.roomenandroidconkotlintarea1ap2.domain.GetRandomQuoteUseCase
import com.example.roomenandroidconkotlintarea1ap2.domain.model.Quote
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class quoteViewModel @Inject constructor(
    private val getQuotesUseCase:GetQuotesUseCase,
    private val getRandomQuoteUseCase:GetRandomQuoteUseCase
) : ViewModel(){
    val quoteModel = MutableLiveData<Quote>()

    val isLoading = MutableLiveData<Boolean>()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getQuotesUseCase()
            if(!result.isNullOrEmpty()){
                quoteModel.postValue(result[0])
                isLoading.postValue(false)
            }
        }
    }

    fun randomQuote() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val quote = getRandomQuoteUseCase()
            if (quote != null) {
                quoteModel.postValue(quote)
            }
            isLoading.postValue(false)
        }
    }
}