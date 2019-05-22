package com.mx.mascotas.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mx.mascotas.data.database.dao.RoleDao
import com.mx.mascotas.data.database.dao.UserDao
import com.mx.mascotas.data.database.entity.Role
import com.mx.mascotas.data.database.entity.User

@Database(
    entities = [
        User::class,
        Role::class],
    version = 1,
    exportSchema = false)
abstract class AppDataBase: RoomDatabase() {
    abstract fun userDao() : UserDao
    abstract fun roleDao() : RoleDao
}