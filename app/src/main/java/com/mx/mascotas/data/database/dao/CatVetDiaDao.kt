package com.mx.mascotas.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.mx.mascotas.data.database.entity.CatVetDia

@Dao
interface CatVetDiaDao: BaseDao <CatVetDia>{
    @Query("select * from catvetdia")
    fun getListCatVetDia() : LiveData<List<CatVetDia>>
}

