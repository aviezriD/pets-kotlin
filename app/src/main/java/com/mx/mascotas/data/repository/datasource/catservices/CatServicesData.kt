package com.mx.mascotas.data.repository.datasource.catservices

import androidx.lifecycle.LiveData
import com.mx.mascotas.data.database.entity.CatService
import com.mx.mascotas.data.repository.datasource.BaseData

interface CatServicesData<R>: BaseData<CatService, R> {
    fun getListCatServices(): LiveData<List<CatService>>
}
