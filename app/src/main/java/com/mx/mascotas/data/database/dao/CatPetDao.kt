package com.mx.mascotas.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.mx.mascotas.data.database.entity.CatPet
@Dao
interface CatPetDao: BaseDao<CatPet> {
    @Query("select  * from catpet")
    fun getListCatPet () :LiveData<List<CatPet>>
}