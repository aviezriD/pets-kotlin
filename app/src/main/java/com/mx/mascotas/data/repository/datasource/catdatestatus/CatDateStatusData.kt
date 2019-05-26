package com.mx.mascotas.data.repository.datasource.catdatestatus

import androidx.lifecycle.LiveData
import com.mx.mascotas.data.database.entity.CatDateStatus
import com.mx.mascotas.data.repository.datasource.BaseData

interface CatDateStatusData<R>: BaseData<CatDateStatus,R>  {
    fun getListCatDateStatus() : LiveData<List<CatDateStatus>>
}

