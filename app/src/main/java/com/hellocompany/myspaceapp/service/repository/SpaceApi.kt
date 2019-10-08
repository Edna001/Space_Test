package com.hellocompany.myspaceapp.service.repository

import com.hellocompany.myspaceapp.service.model.response.CategoriesResponse
import retrofit2.Call
import retrofit2.http.GET

interface SpaceApi {

    @GET("payments/categories")
    fun getAllItems(): Call<CategoriesResponse>

}