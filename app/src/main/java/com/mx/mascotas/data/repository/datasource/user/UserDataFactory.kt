package com.mx.mascotas.data.repository.datasource.user

import com.google.firebase.database.FirebaseDatabase
import com.mx.mascotas.MascotasAplication

class UserDataFactory {

    object Resourse{
        val userDataBase = UserDataDb(MascotasAplication.application.database.userDao())
        val userDataFirebase = UserDataFireBase(FirebaseDatabase.getInstance())
    }

    fun createUserDataDb() = Resourse.userDataBase
    fun createUserDataFireBase() = Resourse.userDataFirebase
}