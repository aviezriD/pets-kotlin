package com.mx.mascotas.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.mx.mascotas.data.database.entity.User
import com.mx.mascotas.data.database.entity.UserService
import rx.Single

@Dao
interface UserServiceDao : BaseDao<UserService> {
    //Query que traerá todos los  servicios que ofrezca un usuario
    @Query ("select * from userService Where user=:user")
    fun getListServiceByUser(user: String): LiveData<List<UserService>>

    //Inserta un nuevo registro a la tabla, cuando un usuario de de alta un servicio
    @Insert
    fun insertServicebyUser(userService:UserService) : Single<Long>

    //Query que traerá todos los usuarios que ofrezcan un servicio en específico
    @Query("select * from userService Where idCatService=:idCatService")
    fun getListUser(idCatService: Int): LiveData<List<UserService>>


}

