package com.mx.mascotas.domain.usecase.registerdate

import androidx.lifecycle.LiveData
import com.mx.mascotas.data.database.entity.CatService
import com.mx.mascotas.data.database.entity.Pet
import com.mx.mascotas.data.database.entity.User
import com.mx.mascotas.domain.repository.PetRepository
import com.mx.mascotas.domain.repository.PreferenceRepository
import com.mx.mascotas.domain.repository.UserRepository
import com.mx.mascotas.domain.repository.VetRepository

class RegisterDateUseCaseImpl(val userRepository: UserRepository, val petRepository: PetRepository, val vetRepository: VetRepository, val preferenceRepository: PreferenceRepository) : RegisterDateUseCase {

    override fun getListPet(): LiveData<List<Pet>> {
        return petRepository.getListPetByName(preferenceRepository.getUserName())
    }

    override fun getListVet(): LiveData<List<User>> {
        return userRepository.getUserByIdRole(1)
    }

    override fun getListServices(): LiveData<List<CatService>> {
        return vetRepository.getListServices()
    }
}