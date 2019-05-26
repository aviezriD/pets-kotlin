package com.mx.mascotas.domain.repository

import androidx.lifecycle.LiveData
import com.mx.mascotas.data.database.entity.CatPet
import com.mx.mascotas.data.database.entity.CatPetSize
import com.mx.mascotas.data.database.entity.Pet
import io.reactivex.Observable

interface PetRepository {
    fun register(pet: Pet) : Observable<Boolean>
    fun insert(pet: Pet)
    fun getTypePet(): LiveData<List<CatPet>>
    fun getListPetByName(user : String): LiveData<List<Pet>>
    fun getListCatPetSize() : LiveData<List<CatPetSize>>
}