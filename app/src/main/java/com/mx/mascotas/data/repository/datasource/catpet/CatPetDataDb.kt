package com.mx.mascotas.data.repository.datasource.catpet

import androidx.lifecycle.LiveData
import com.mx.mascotas.data.database.dao.CatPetDao
import com.mx.mascotas.data.database.entity.CatPet

class CatPetDataDb(var dao: CatPetDao): CatPetData<Unit,Unit> {
    override fun insert(obj: CatPet) {
        dao.insert(obj)
    }

    override fun update(obj: CatPet) {
        dao.update(obj)
    }

    override fun delete(obj: CatPet) {
        dao.delete(obj)
    }

    override fun getListCat(): LiveData<List<CatPet>> {
        return dao.getListCatPet()
    }
}