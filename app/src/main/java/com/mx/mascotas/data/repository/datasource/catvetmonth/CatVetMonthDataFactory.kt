package com.mx.mascotas.data.repository.datasource.catvetmonth

import android.content.pm.ResolveInfo
import com.mx.mascotas.MascotasAplication

class CatVetMonthDataFactory {
    object  Resource {
        val vetMonthDataBase = CatVetMonthDataDb (MascotasAplication.application.database.catVetMonthDao())
    }
    fun createCatVetMonthDataDb () = Resource.vetMonthDataBase
}