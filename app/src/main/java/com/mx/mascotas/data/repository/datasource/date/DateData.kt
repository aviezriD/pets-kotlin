package com.mx.mascotas.data.repository.datasource.date

import androidx.lifecycle.LiveData
import androidx.room.Query
import com.mx.mascotas.data.database.entity.Date
import com.mx.mascotas.data.repository.datasource.BaseData
import com.mx.mascotas.domain.entity.ItemDate

interface DateData<T,R>: BaseData<Date,R> {
    fun getListDatePending(id :String): T
    fun getListDateByIdUser(id :String): T
    fun getDateById(id : Int) : LiveData<Date>
}