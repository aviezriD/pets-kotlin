package com.mx.mascotas.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.mx.mascotas.data.database.entity.CatVetHoras

@Dao
interface CatVetHorasDao: BaseDao<CatVetHoras> {
    //Query que trae todas las horas
    @Query("select * from catvethoras")
    fun getListCatVetHoras(): LiveData<List<CatVetHoras>>

    //Query que traerá todas las horas siempre y cuando el horario esté disponible
    @Query("select * from catvethoras Where estatus =:estatus")
    fun getListCatVetHorasDispo(estatus: Boolean) : LiveData<List<CatVetHoras>>
}

