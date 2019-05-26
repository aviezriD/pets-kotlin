package com.mx.mascotas.data.repository.datasource.catpetsize

import com.mx.mascotas.MascotasAplication

class CatPetSizeDataFactory {

    object Resourse{
        val petCatSizeDataBase = CatPetSizeDataDb(MascotasAplication.application.database.catPetSizeDao())
    }

    fun createCatPetSizeDataDb() = Resourse.petCatSizeDataBase
}