package com.mx.mascotas.data.repository.datasource.catvetmonth

import androidx.lifecycle.LiveData
import com.mx.mascotas.data.database.entity.CatVetMonth
import com.mx.mascotas.data.repository.datasource.BaseData

interface CatVetMonthData<R>: BaseData<CatVetMonth, R> {
    fun getListCatVetMonth(): LiveData<List<CatVetMonth>>
}

