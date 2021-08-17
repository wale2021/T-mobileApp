package com.wale.tm_mobile.ui.viewmodel

import androidx.lifecycle.*
import com.wale.tm_mobile.data.repository.CardRepository
import com.wale.tm_mobile.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CardViewModel @Inject constructor(
    private val cardRepository: CardRepository
) : ViewModel() {

    val getCards = cardRepository.fetchCardData().asLiveData()

}