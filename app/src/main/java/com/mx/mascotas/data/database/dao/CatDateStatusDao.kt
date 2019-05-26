package com.mx.mascotas.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Query
import com.mx.mascotas.data.database.entity.CatDateStatus
import com.mx.mascotas.data.database.entity.CatPetSize

interface CatDateStatusDao: BaseDao <CatDateStatus> {
    @Query("select * from catdatestatus")
    fun getListCatDateStatus() : LiveData<List<CatDateStatus>>
}
