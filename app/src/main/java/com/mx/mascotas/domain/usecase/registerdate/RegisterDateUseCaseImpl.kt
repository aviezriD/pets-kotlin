package com.mx.mascotas.domain.usecase.registerdate

import androidx.lifecycle.LiveData
import com.mx.mascotas.data.database.entity.*
import com.mx.mascotas.domain.repository.*

class RegisterDateUseCaseImpl(val userRepository: UserRepository, val petRepository: PetRepository, val vetRepository: VetRepository, val preferenceRepository: PreferenceRepository,val dateRepository : DateRepository) : RegisterDateUseCase {

    override fun getListPet(): LiveData<List<Pet>> {
        return petRepository.getListPetByName(preferenceRepository.getUserName())
    }

    override fun getListVet(): LiveData<List<User>> {
        return userRepository.getUserByIdRole(1)
    }

    override fun getListServices(): LiveData<List<CatService>> {
        return vetRepository.getListServices()
    }

    override fun getListCatVetHoras(): LiveData<List<CatVetHoras>> {
        return vetRepository.getListCatVetHoras()
    }

    override fun getListCatVetDia(): LiveData<List<CatVetDia>> {
        return vetRepository.getListCatVetDia()
    }

    override fun insert(date: Date) {
        val userId = preferenceRepository.getUserName()
        date.idRol = preferenceRepository.getRole()
        date.idUser = userId
        date.id = userId.plus("-").plus(date.idPet)
        dateRepository.insert(date)
    }
}