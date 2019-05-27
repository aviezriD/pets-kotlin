package com.mx.mascotas.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.mx.mascotas.data.database.entity.Date
import com.mx.mascotas.domain.entity.ItemDate

@Dao
interface DateDao:BaseDao<Date>
{

    @Query("select a.id,a.idPet, a.namePet, a.typeService, a.typeSubservice, a.hour, a.date, a.idUser, a.estatus, u.name, a.nameVeterinarian, a.locationVeterinarian FROM date a inner join user u on u.user=a.idUser WHERE a.estatus = 0 and a.idUser =:id")
    fun datacitasusers(id :String): LiveData<List<ItemDate>>

    @Query("select a.id,a.idPet, a.namePet, a.typeService, a.typeSubservice, a.hour, a.date, a.idUser, a.estatus, u.name,a.nameVeterinarian, a.locationVeterinarian FROM date a inner join user u on u.user=a.idUser WHERE  a.idUser =:id")
    fun getListDateByIdUser(id :String): LiveData<List<ItemDate>>

    @Query("select * from date where id =:id")
    fun getDateById(id: Int): LiveData<Date>



}