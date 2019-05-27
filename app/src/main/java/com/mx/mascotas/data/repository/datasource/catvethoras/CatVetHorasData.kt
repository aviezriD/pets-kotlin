package com.mx.mascotas.data.repository.datasource.catvethoras

import androidx.lifecycle.LiveData
import com.mx.mascotas.data.database.entity.CatVetHoras
import com.mx.mascotas.data.repository.datasource.BaseData

interface CatVetHorasData<R>: BaseData<CatVetHoras, R> {
        fun getListCatVetHoras(): LiveData<List<CatVetHoras>>
    }
