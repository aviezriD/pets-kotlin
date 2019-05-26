package com.mx.mascotas.data.repository.datasource.veterinary

import com.google.firebase.database.FirebaseDatabase
import com.mx.mascotas.MascotasAplication

class VeterinaryDataFactory {

    object Resourse{
        val veterinaryDataBase = VeterinaryDataDb(MascotasAplication.application.database.veterinaryDao())
        val veterinaryDataFirebase = VeterinaryDataFirebase(FirebaseDatabase.getInstance())

    }

    fun createVeterinaryDataDb() = Resourse.veterinaryDataBase
    fun createVeterinaryDataFireBase() = Resourse.veterinaryDataFirebase
}