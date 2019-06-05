package com.mx.mascotas.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mx.mascotas.data.database.dao.*
import com.mx.mascotas.data.database.entity.*
import com.mx.mascotas.data.database.dao.DateDao
import com.mx.mascotas.data.database.dao.RoleDao
import com.mx.mascotas.data.database.dao.UserDao
import com.mx.mascotas.data.database.entity.Date
import com.mx.mascotas.data.database.entity.Role
import com.mx.mascotas.data.database.entity.User

@Database(
    entities = [
        Date::class,
        User::class,
        Role::class,
        CatPet::class,
        CatPetSize::class,
        CatDateStatus::class,
        CatService::class,
        CatSubService::class,
        CatVetMonth::class,
        CatDayLab::class,
        CatVaccination::class,
        Pet::class,
        CatVetHoras::class,
        CatVetDia::class,
        Veterinary::class,
        UserService::class
       // CalendarVet::class
        ],
    version = 1,
    exportSchema = false)
    abstract class AppDataBase: RoomDatabase() {
    abstract fun userDao() : UserDao
    abstract fun roleDao() : RoleDao
    abstract fun petDao() : PetDao
    abstract fun catPetDao() : CatPetDao
    abstract fun catPetSizeDao() : CatPetSizeDao
    abstract fun dateDao() : DateDao
    abstract fun catDateStatusDao() : CatDateStatusDao
    abstract fun catServicesDao() : CatServicesDao
    abstract fun veterinaryDao() :VeterinaryDao
    abstract fun catVetDiaDao() : CatVetDiaDao
    abstract fun catVetHorasDao() : CatVetHorasDao
    abstract fun catSubserviceDao() : CatSubserviceDao
    abstract fun catVetMonthDao() : CatVetMonthDao
    abstract fun userServiceDao() : UserServiceDao
    abstract fun catDayLabDao() : CatDayLabDao
    abstract fun catVaccinationDao(): CatVaccinationDao

    //abstract fun calendarVetDao() : CalendarVetDao

   // abstract fun catEstatusVacunaDao(): CatEstatusVacunaDao


}