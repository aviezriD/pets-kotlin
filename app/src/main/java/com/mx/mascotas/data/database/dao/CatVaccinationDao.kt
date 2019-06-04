package com.mx.mascotas.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.mx.mascotas.data.database.entity.CatVaccination

@Dao
interface CatVaccinationDao: BaseDao <CatVaccination> {
    @Query("select * from catvaccination")
    fun getListCatVaccination(): LiveData<CatVaccination>
}


