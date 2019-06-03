package com.mx.mascotas.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.mx.mascotas.data.database.entity.CatVetMonth

@Dao
interface CatVetMonthDao : BaseDao<CatVetMonth> {
    @Query( "select * from catvetmonth ")
    fun getListCatVetMonth (): LiveData<List<CatVetMonth>>
}