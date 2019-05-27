package com.mx.mascotas.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.mx.mascotas.data.database.entity.Pet
@Dao
interface PetDao:BaseDao<Pet> {
    @Query("select * from Pet where owner =:user")
    fun getListPetByName(user : String): LiveData<List<Pet>>

    @Query("select * from pet where id =:id")
    fun getPetById(id: String): LiveData<Pet>
}