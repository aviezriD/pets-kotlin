package com.mx.mascotas.data.repository.datasource.catvaccination

import com.mx.mascotas.MascotasAplication

class CatVaccinationDataFactory {
    object  Resourse{
        val vetCatVaccinationDataBase= CatVaccinationDataDb (MascotasAplication.application.database.catVaccinationDao())

    }
    fun createCatVaccinationDataDb() = Resourse.vetCatVaccinationDataBase
}
