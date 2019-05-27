package com.mx.mascotas.data.repository

import androidx.lifecycle.LiveData
import com.mx.mascotas.data.database.entity.CatService
import com.mx.mascotas.data.repository.datasource.catservices.CatServicesDataFactory
import com.mx.mascotas.domain.repository.VetRepository

class VetDataRepository: VetRepository {
    private val serviceFactory by lazy { CatServicesDataFactory() }
    private val serviceBd by lazy { serviceFactory.createCatServicesDataDb() }

    override fun getListServices(): LiveData<List<CatService>> {
        return serviceBd.getListCatServices()
    }
}