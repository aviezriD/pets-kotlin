package com.mx.mascotas.data.repository.datasource.catdaylab

import com.mx.mascotas.MascotasAplication

class CatDayLabDataFactory {
    object Resource{
        val vetCatDayLabDataBase = CatDayLabDataDb(MascotasAplication.application.database.catDayLabDao())
    }

    fun createCatDayLabDataDb () = Resource.vetCatDayLabDataBase

}