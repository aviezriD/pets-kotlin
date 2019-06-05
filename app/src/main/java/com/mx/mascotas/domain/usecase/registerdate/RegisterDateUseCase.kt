package com.mx.mascotas.domain.usecase.registerdate

import androidx.lifecycle.LiveData
import com.mx.mascotas.data.database.entity.*

interface RegisterDateUseCase {
    fun getListPet(): LiveData<List<Pet>>
    fun getListVet(): LiveData<List<User>>
    fun getListServices(): LiveData<List<CatService>>
    fun getListCatVetHoras(): LiveData<List<CatVetHoras>>
    fun getListCatVetHorasDispo(): LiveData<List<CatVetHoras>>
    fun getListCatVetMonth() : LiveData<List<CatVetMonth>>
    fun getListCatVetDia(): LiveData<List<CatVetDia>>
    fun insert(date: Date)
}