package com.mx.mascotas.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.mx.mascotas.data.database.entity.CatService
@Dao
interface CatServicesDao: BaseDao <CatService> {
    @Query("select * from catservice")
    fun getListCatServices(): LiveData<List<CatService>>
}
