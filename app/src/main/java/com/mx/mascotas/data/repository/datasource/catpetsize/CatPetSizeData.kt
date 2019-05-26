package com.mx.mascotas.data.repository.datasource.catpetsize

import androidx.lifecycle.LiveData
import com.mx.mascotas.data.database.entity.CatPetSize
import com.mx.mascotas.data.repository.datasource.BaseData

interface CatPetSizeData<R>: BaseData<CatPetSize, R> {
    fun getListCatPetSize() : LiveData<List<CatPetSize>>
}