package com.hellocompany.myspaceapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hellocompany.myspaceapp.service.model.Companies
import com.hellocompany.myspaceapp.service.model.response.CategoriesResponse
import com.hellocompany.myspaceapp.service.repository.CategoriesRepository

class PaymentsViewModel: ViewModel() {

    private val categoriesRepository: CategoriesRepository = CategoriesRepository()
    private val categoriesResponse: MutableLiveData<CategoriesResponse> = categoriesRepository.getCategories()
    private val companiesList: MutableLiveData<MutableList<Companies>> = MutableLiveData()

    fun setCompanies(items: MutableList<Companies>) {
        companiesList.value = items
    }

    fun getCompanies(): LiveData<MutableList<Companies>> {
        return companiesList
    }

    fun getResponse(): LiveData<CategoriesResponse>{
        return categoriesResponse
    }

}