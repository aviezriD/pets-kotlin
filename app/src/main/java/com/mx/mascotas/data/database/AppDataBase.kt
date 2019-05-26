package com.mx.mascotas.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mx.mascotas.data.database.dao.*
import com.mx.mascotas.data.database.entity.*

@Database(
    entities = [
        User::class,
        Role::class,
        CatPet::class,
        CatPetSize::class,
        Pet::class],
    version = 1,
    exportSchema = false)
abstract class AppDataBase: RoomDatabase() {
    abstract fun userDao() : UserDao
    abstract fun roleDao() : RoleDao
    abstract fun petDao() : PetDao
    abstract fun catPetDao() : CatPetDao
    abstract fun catPetSizeDao() : CatPetSizeDao
}