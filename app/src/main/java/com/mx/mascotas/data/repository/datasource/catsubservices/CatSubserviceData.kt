package com.mx.mascotas.data.repository.datasource.catsubservices

import androidx.lifecycle.LiveData
import com.mx.mascotas.data.database.entity.CatSubService
import com.mx.mascotas.data.repository.datasource.BaseData

interface CatSubserviceData<R>: BaseData<CatSubService, R>{
    fun getListCatSubservices(): LiveData<List<CatSubService>>
}

