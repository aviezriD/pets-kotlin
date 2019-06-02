package com.mx.mascotas.domain.repository

import androidx.lifecycle.LiveData
import com.mx.mascotas.data.database.entity.Date
import com.mx.mascotas.domain.entity.ItemDate

interface DateRepository {
    fun getListDatebyUser(id: String):LiveData<List<ItemDate>>
    fun getListDateendingPbyUser(id: String):LiveData<List<ItemDate>>
    fun getInfoDateById(id: Int): LiveData<Date>
    fun insert(date: Date)
}