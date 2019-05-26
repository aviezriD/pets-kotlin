package com.mx.mascotas.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.mx.mascotas.data.database.entity.CatPetSize

@Dao
interface CatPetSizeDao: BaseDao<CatPetSize> {
    @Query("select * from catpetsize")
    fun getListCatPetSize() : LiveData<List<CatPetSize>>

}