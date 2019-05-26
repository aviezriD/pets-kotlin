package com.mx.mascotas.data.repository.datasource.pet

import com.google.firebase.database.FirebaseDatabase
import com.mx.mascotas.MascotasAplication

class PetDataFactory {
    object Resourse{
        val petDataBase = PetDataDb(MascotasAplication.application.database.petDao())
        val petDataFirebase = PetDataFireBase(FirebaseDatabase.getInstance())
    }

    fun createPetDataDb() = Resourse.petDataBase
    fun createPetDataFireBase() = Resourse.petDataFirebase
}