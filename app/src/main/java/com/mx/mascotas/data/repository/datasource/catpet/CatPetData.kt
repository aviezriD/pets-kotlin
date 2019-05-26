package com.mx.mascotas.data.repository.datasource.catpet

import androidx.lifecycle.LiveData
import com.mx.mascotas.data.database.entity.CatPet
import com.mx.mascotas.data.repository.datasource.BaseData

interface CatPetData<T,R>: BaseData<CatPet, R> {
    fun getListCat() : LiveData<List<CatPet>>
}