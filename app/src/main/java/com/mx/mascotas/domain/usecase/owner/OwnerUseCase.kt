package com.mx.mascotas.domain.usecase.owner

import androidx.lifecycle.LiveData
import com.mx.mascotas.data.database.entity.Pet
import com.mx.mascotas.domain.entity.ItemPet

interface OwnerUseCase {
    fun getListPetBy(): LiveData<List<Pet>>
    fun getListPetByNameMinimal(): LiveData<List<ItemPet>>
    fun deletePet(id: String)
}