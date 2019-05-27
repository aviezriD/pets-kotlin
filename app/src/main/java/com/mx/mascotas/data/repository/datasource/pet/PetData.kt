package com.mx.mascotas.data.repository.datasource.pet

import androidx.lifecycle.LiveData
import com.mx.mascotas.data.database.entity.Pet
import com.mx.mascotas.data.repository.datasource.BaseData

interface PetData<T,P,R>: BaseData<Pet,R> {
    fun getListPetByName(user : String): T
    fun getPetById(id : String) : P
}