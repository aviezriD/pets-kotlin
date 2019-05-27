package com.mx.mascotas.domain.repository

import androidx.lifecycle.LiveData
import com.mx.mascotas.data.database.entity.CatService
import com.mx.mascotas.data.database.entity.CatVetDia
import com.mx.mascotas.data.database.entity.CatVetHoras

interface VetRepository {
    fun getListServices(): LiveData<List<CatService>>
    fun getListCatVetHoras(): LiveData<List<CatVetHoras>>
    fun getListCatVetDia(): LiveData<List<CatVetDia>>
}