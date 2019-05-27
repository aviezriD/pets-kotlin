package com.mx.mascotas.domain.usecase.pet

import androidx.lifecycle.LiveData
import com.mx.mascotas.data.database.entity.CatPet
import com.mx.mascotas.data.database.entity.CatPetSize
import com.mx.mascotas.data.database.entity.Pet

interface PetUseCase {

    fun register(pet : Pet)
    fun getTypePet(): LiveData<List<CatPet>>
    fun getListCatPetSize() : LiveData<List<CatPetSize>>
    fun deletePet(id: String)
    fun getPetById(id: String): LiveData<Pet>

}