package com.mx.mascotas.domain.usecase.owner

import androidx.lifecycle.LiveData
import com.mx.mascotas.data.database.entity.Pet
import com.mx.mascotas.domain.entity.ItemPet
import com.mx.mascotas.domain.repository.PetRepository
import com.mx.mascotas.domain.repository.PreferenceRepository

class OwnerUseCaseImpl(val petRepository: PetRepository, val preference : PreferenceRepository): OwnerUseCase {
    override fun getListPetBy(): LiveData<List<Pet>> {
        return petRepository.getListPetByName(preference.getUserName())
    }

    override fun getListPetByNameMinimal(): LiveData<List<ItemPet>> {
        return petRepository.getListPetByNameMinimal(preference.getUserName())
    }

    override fun deletePet(id: String) {
        petRepository.deletePet(Pet(id = id))
    }
}