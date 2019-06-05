package com.mx.mascotas.data.repository.datasource.catvethoras

import com.mx.mascotas.MascotasAplication


class CatVetHorasDataFactory {
    object Resourse{
        val petCatVetHorasDataBase = CatVetHorasDataDb(MascotasAplication.application.database.catVetHorasDao())
    }

    fun createCatVetHorasDataDb () = Resourse.petCatVetHorasDataBase
}

