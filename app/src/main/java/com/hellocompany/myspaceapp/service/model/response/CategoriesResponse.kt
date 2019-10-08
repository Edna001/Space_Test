package com.hellocompany.myspaceapp.service.model.response

import com.hellocompany.myspaceapp.service.model.Data
import com.hellocompany.myspaceapp.service.model.Status

data class CategoriesResponse(
    val data: Data,
    val status: Status
)