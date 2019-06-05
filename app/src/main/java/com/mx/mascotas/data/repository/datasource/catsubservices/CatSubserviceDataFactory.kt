package com.mx.mascotas.data.repository.datasource.catsubservices

import com.mx.mascotas.MascotasAplication

class CatSubserviceDataFactory {
    object Resource{
        val petCatSubserviceDataBase = CatSubserviceDataDb (MascotasAplication.application.database.catSubserviceDao())
    }
    fun createCatSubserviceDataDb () = Resource.petCatSubserviceDataBase
}


