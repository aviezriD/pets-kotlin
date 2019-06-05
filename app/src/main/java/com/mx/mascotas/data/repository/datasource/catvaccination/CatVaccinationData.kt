package com.mx.mascotas.data.repository.datasource.catvaccination

import androidx.lifecycle.LiveData
import com.mx.mascotas.data.database.entity.CatVaccination
import com.mx.mascotas.data.repository.datasource.BaseData

interface CatVaccinationData<R>: BaseData<CatVaccination, R> {
    fun getListCatVaccination(): LiveData<CatVaccination>
}



