package com.mx.mascotas.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Query
import com.mx.mascotas.data.database.entity.CatService

interface CatServicesDao: BaseDao <CatService> {
    @Query("select * from catservice")
    fun getListCatServices(): LiveData<List<CatService>>
}
