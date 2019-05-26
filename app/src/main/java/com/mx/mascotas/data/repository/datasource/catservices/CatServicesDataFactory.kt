package com.mx.mascotas.data.repository.datasource.catservices

import com.mx.mascotas.MascotasAplication


class CatServicesDataFactory {
    object Resource{
        val petCatServiceDataBase = CatServicesDataDb(MascotasAplication.application.database.catServicesDao())
    }

    fun createCatServicesDataDb () = Resource.petCatServiceDataBase
}
