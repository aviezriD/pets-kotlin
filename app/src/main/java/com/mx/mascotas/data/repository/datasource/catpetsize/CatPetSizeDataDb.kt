package com.mx.mascotas.data.repository.datasource.catpetsize

import androidx.lifecycle.LiveData
import com.mx.mascotas.data.database.dao.CatPetSizeDao
import com.mx.mascotas.data.database.entity.CatPetSize

class CatPetSizeDataDb(val catPetSizeDao: CatPetSizeDao): CatPetSizeData<Unit> {

    override fun getListCatPetSize(): LiveData<List<CatPetSize>> {
        return catPetSizeDao.getListCatPetSize()
    }

    override fun insert(obj: CatPetSize) {
        catPetSizeDao.insert(obj)
    }

    override fun update(obj: CatPetSize) {
        catPetSizeDao.update(obj)
    }

    override fun delete(obj: CatPetSize) {
        catPetSizeDao.delete(obj)
    }
}