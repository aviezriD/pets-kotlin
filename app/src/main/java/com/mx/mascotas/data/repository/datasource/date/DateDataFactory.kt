package com.mx.mascotas.data.repository.datasource.date

import com.google.firebase.database.FirebaseDatabase
import com.mx.mascotas.MascotasAplication

class DateDataFactory  {
    object Resource{
        val databaseDate = DateDataDb (MascotasAplication.application.database.dateDao())
        val databaseFirebase = DateDataFirebase (FirebaseDatabase.getInstance())
    }
    fun datebaseReturn () = Resource.databaseDate
    fun databaseReturnFirebase () = Resource.databaseFirebase

}