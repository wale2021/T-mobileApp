package com.wale.tm_mobile.api

import com.wale.tm_mobile.data.model.Page
import retrofit2.Response
import retrofit2.http.GET

interface CardService {

    //https://private-8ce77c-tmobiletest.apiary-mock.com/test/home
    @GET("/test/home")
    suspend fun getCards(): Response<Page>

}