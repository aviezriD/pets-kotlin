package com.mx.mascotas.data.repository.datasource.catvetdia

import com.mx.mascotas.MascotasAplication

class CatVetDiaDataFactory {
    object  Resourse{
        val vetcatdiaDataBase = CatVetDiaDataDb (MascotasAplication.application.database.catVetDiaDao())
    }
    fun createCatVetDiaDataDb() = Resourse.vetcatdiaDataBase
}

