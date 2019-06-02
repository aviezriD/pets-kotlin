package com.mx.mascotas.data.repository

import androidx.lifecycle.LiveData
import com.mx.mascotas.data.database.entity.CatService
import com.mx.mascotas.data.database.entity.CatVetDia
import com.mx.mascotas.data.database.entity.CatVetHoras
import com.mx.mascotas.data.repository.datasource.catservices.CatServicesDataFactory
import com.mx.mascotas.data.repository.datasource.catvetdia.CatVetDiaDataFactory
import com.mx.mascotas.data.repository.datasource.catvethoras.CatVetHorasDataFactory
import com.mx.mascotas.domain.repository.VetRepository

class VetDataRepository: VetRepository {
    private val serviceFactory by lazy { CatServicesDataFactory() }
    private val serviceBd by lazy { serviceFactory.createCatServicesDataDb() }


    private val catVetDayFactory by lazy { CatVetDiaDataFactory() }
    private val catVetDayDb by lazy { catVetDayFactory.createCatVetDiaDataDb() }

    private val catVetHourFactory by lazy { CatVetHorasDataFactory() }
    private val catVetHourDb by lazy { catVetHourFactory.createCatVetHorasDataDb() }


    override fun getListServices(): LiveData<List<CatService>> {
        return serviceBd.getListCatServices()
    }

    override fun getListCatVetHoras(): LiveData<List<CatVetHoras>> {
        return catVetHourDb.getListCatVetHoras()
    }

    override fun getListCatVetDia(): LiveData<List<CatVetDia>> {
        return catVetDayDb.getListCatVetDia()
    }
}