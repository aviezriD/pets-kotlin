package com.mx.mascotas.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.mx.mascotas.data.database.entity.Date
import com.mx.mascotas.domain.entity.ItemDate

@Dao
interface DateDao:BaseDao<Date>
{

    @Query("select a.idPet, a.namePet, a.typeService, a.typeSubservice, a.hour, a.date, a.idUser, a.estatus, u.name FROM date a inner join user u on u.id=a.idUser WHERE a.estatus = 0")
    fun datacitasusers(): LiveData<List<ItemDate>>



}