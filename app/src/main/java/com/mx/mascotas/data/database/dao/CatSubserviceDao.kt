package com.mx.mascotas.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.mx.mascotas.data.database.entity.CatSubService


@Dao
interface CatSubserviceDao: BaseDao<CatSubService> {
    @Query("select * from catsubservice")
    fun getListCatSubservice(): LiveData<List<CatSubService>>

}

