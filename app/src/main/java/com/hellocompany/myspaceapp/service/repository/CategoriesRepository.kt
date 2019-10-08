package com.hellocompany.myspaceapp.service.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.hellocompany.myspaceapp.service.model.response.CategoriesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CategoriesRepository {

    private var categoriesRepository: CategoriesRepository? = null
    private val retrofit = Retrofit.Builder().baseUrl("https://testapi.spacebank.ge/api/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val spaceApi: SpaceApi = retrofit.create(SpaceApi::class.java)

    fun getCategories(): MutableLiveData<CategoriesResponse> {
        val liveData = MutableLiveData<CategoriesResponse>()
        val call = spaceApi.getAllItems()

        call.enqueue(object : Callback<CategoriesResponse> {
            override fun onFailure(call: Call<CategoriesResponse>, t: Throwable) {
                Log.e("Ui", "Sorry!")
            }
            override fun onResponse(call: Call<CategoriesResponse>, response: Response<CategoriesResponse>) {
                liveData.value = response.body()
            }
        })
        return liveData
    }
}