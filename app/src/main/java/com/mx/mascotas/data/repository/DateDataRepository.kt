package com.mx.mascotas.data.repository

import androidx.lifecycle.LiveData
import com.mx.mascotas.data.database.entity.Date
import com.mx.mascotas.data.repository.datasource.date.DateDataFactory
import com.mx.mascotas.domain.entity.ItemDate
import com.mx.mascotas.domain.repository.DateRepository

class DateDataRepository: DateRepository {

    private val dateFactory by lazy { DateDataFactory() }
    private val dataDb by lazy { dateFactory.datebaseReturn() }
    private val dataFire by lazy { dateFactory.databaseReturnFirebase()}

    override fun getListDatebyUser(id: String): LiveData<List<ItemDate>> {
        return dataDb.getListDateByIdUser(id)
    }

    override fun getListDateendingPbyUser(id: String): LiveData<List<ItemDate>> {
        return dataDb.getListDatePending(id)
    }

    override fun getInfoDateById(id: Int): LiveData<Date> {
        return dataDb.getDateById(id)
    }

    override fun insert(date: Date) {
        dataDb.insert(date)
    }
}