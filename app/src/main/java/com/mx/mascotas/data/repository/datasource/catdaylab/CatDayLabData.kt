package com.mx.mascotas.data.repository.datasource.catdaylab

import androidx.lifecycle.LiveData
import com.mx.mascotas.data.database.entity.CatDayLab
import com.mx.mascotas.data.repository.datasource.BaseData

interface CatDayLabData<R>: BaseData<CatDayLab, R> {
    fun getListCatDayLab() : LiveData<List<CatDayLab>>

}