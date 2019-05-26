package com.mx.mascotas.data.repository.datasource.pet

import com.mx.mascotas.data.database.entity.Pet
import com.mx.mascotas.data.repository.datasource.BaseData

interface PetData<T,R>: BaseData<Pet,R> {
    fun getListPetByName(user : String): T
}