package com.mx.mascotas.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.mx.mascotas.data.database.entity.User
import io.reactivex.Single

@Dao
interface UserDao : BaseDao<User> {
    @Query("SELECT * FROM user WHERE email =:user AND password=:pass")
    fun getUser(user: String, pass: String): User

    @Query("SELECT * FROM user WHERE email =:user  AND idRole =:idRole")
    fun getUserSingle(user: String, idRole : Int): Single<User>

    @Insert
    fun insertUser(user: User) : Single<Long>
}