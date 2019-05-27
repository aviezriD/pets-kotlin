package com.mx.mascotas.data.repository.datasource.pet

import androidx.lifecycle.LiveData
import com.mx.mascotas.data.database.dao.PetDao
import com.mx.mascotas.data.database.entity.Pet
import com.mx.mascotas.data.repository.datasource.BaseDb

class PetDataDb(private val daoPet: PetDao): BaseDb<Pet>(daoPet), PetData<LiveData<List<Pet>>,LiveData<Pet>,Unit> {
    override fun getListPetByName(user: String): LiveData<List<Pet>> {
        return daoPet.getListPetByName(user)
    }

    override fun getPetById(id: String): LiveData<Pet> {
        return daoPet.getPetById(id)
    }
}