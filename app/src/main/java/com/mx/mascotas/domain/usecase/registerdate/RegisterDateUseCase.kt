package com.mx.mascotas.domain.usecase.registerdate

import androidx.lifecycle.LiveData
import com.mx.mascotas.data.database.entity.CatService
import com.mx.mascotas.data.database.entity.Pet
import com.mx.mascotas.data.database.entity.User

interface RegisterDateUseCase {
    fun getListPet(): LiveData<List<Pet>>
    fun getListVet(): LiveData<List<User>>
    fun getListServices(): LiveData<List<CatService>>
}