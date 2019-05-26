package com.mx.mascotas.data.repository.datasource.catdatestatus

import com.mx.mascotas.MascotasAplication

class CatDateStatusDataFactory {
    object Resource{
        val petCatDateStatusDataBase = CatDateStatusDataDb(MascotasAplication.application.database.catDateStatusDao())
    }

    fun createCatDateStatusDataDb () = Resource.petCatDateStatusDataBase
}

