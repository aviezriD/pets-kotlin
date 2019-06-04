package com.mx.mascotas.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.mx.mascotas.data.database.entity.CatDayLab

@Dao
interface CatDayLabDao: BaseDao<CatDayLab> {
    @Query("select * from catdaylab")
    fun getListCatDayLab() : LiveData<List<CatDayLab>>

}