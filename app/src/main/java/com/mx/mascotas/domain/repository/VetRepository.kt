package com.mx.mascotas.domain.repository

import androidx.lifecycle.LiveData
import com.mx.mascotas.data.database.entity.CatService

interface VetRepository {
    fun getListServices(): LiveData<List<CatService>>
}