package com.mx.mascotas.data.repository.datasource.catpet

import com.mx.mascotas.MascotasAplication

class CatPetDataFactory {

    object Resourse{
        val petCatDataBase = CatPetDataDb(MascotasAplication.application.database.catPetDao())
    }

    fun createCatPetDataDb() = Resourse.petCatDataBase
}