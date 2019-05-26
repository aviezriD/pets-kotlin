package com.mx.mascotas.domain.usecase.owner

import androidx.lifecycle.LiveData
import com.mx.mascotas.data.database.entity.Pet

interface OwnerUseCase {

    fun getListPetBy(): LiveData<List<Pet>>
}