package com.wale.tm_mobile.data.repository

import android.util.Log
import com.wale.tm_mobile.api.CardService
import com.wale.tm_mobile.data.model.Card
import com.wale.tm_mobile.data.model.CardWrapper
import com.wale.tm_mobile.utils.Resource
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CardRepository @Inject constructor(private val cardService: CardService) {

    fun fetchCardData() = flow {
        emit(Resource.Loading)
        try {
            val response = cardService.getCards()
            if (response.isSuccessful && response.body() != null) {
                emit(Resource.Success(response.body()?.page?.cards!!))
            } else {
                emit(Resource.Error("Error occurred while retrieving you info."))
            }
        } catch (ex: Exception) {
            emit(Resource.Error(ex.toString()))
            Log.d("Repo", ex.toString())
        }
    }

}