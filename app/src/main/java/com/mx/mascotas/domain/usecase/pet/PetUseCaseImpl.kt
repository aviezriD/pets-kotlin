package com.mx.mascotas.domain.usecase.pet

import androidx.lifecycle.LiveData
import com.mx.mascotas.data.database.entity.CatPet
import com.mx.mascotas.data.database.entity.CatPetSize
import com.mx.mascotas.data.database.entity.Pet
import com.mx.mascotas.domain.repository.PetRepository
import com.mx.mascotas.domain.repository.PreferenceRepository

class PetUseCaseImpl(private val petRepository: PetRepository,val preference : PreferenceRepository): PetUseCase {
    override fun register(pet: Pet) {
        val user = preference.getUserName()
        pet.id = user.plus("-").plus(pet.name)
        pet.owner = user
        petRepository.insert(pet)
    }

    override fun getTypePet(): LiveData<List<CatPet>> {
        return petRepository.getTypePet()
    }

    override fun getListCatPetSize(): LiveData<List<CatPetSize>> {
        return petRepository.getListCatPetSize()
    }
}