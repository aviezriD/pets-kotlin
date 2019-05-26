package com.mx.mascotas.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.mx.mascotas.data.database.entity.CatDateStatus
import com.mx.mascotas.data.database.entity.CatPetSize
@Dao
interface CatDateStatusDao: BaseDao <CatDateStatus> {
    @Query("select * from catdatestatus")
    fun getListCatDateStatus() : LiveData<List<CatDateStatus>>
}
