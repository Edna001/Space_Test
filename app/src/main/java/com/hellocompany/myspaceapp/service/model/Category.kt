package com.hellocompany.myspaceapp.service.model

data class Categories(
    val name: String?,
    val parentId: Int?,
    val order: Int?,
    val picture: Picture?,
    val categoryId: Int?,
    val subCategory: MutableList<Categories>? = null,
    val companyIds: MutableList<Int>? = null
)