package com.mx.mascotas.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.mx.mascotas.data.database.entity.CatVetHoras

@Dao
interface CatVetHorasDao: BaseDao<CatVetHoras> {
    @Query("select * from catvethoras")
    fun getListCatVetHoras(): LiveData<List<CatVetHoras>>
}

