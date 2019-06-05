package com.mx.mascotas.data.repository.datasource.date

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mx.mascotas.data.database.dao.DateDao
import com.mx.mascotas.data.database.entity.Date
import com.mx.mascotas.data.repository.datasource.BaseData
import com.mx.mascotas.data.repository.datasource.BaseDb
import com.mx.mascotas.domain.entity.ItemDate

class DateDataDb (var dateDao: DateDao) : DateData<LiveData<List<ItemDate>>,Unit>, BaseDb<Date>(dateDao)

{
    override fun getListDatePending(id: String): LiveData<List<ItemDate>> {
       // return dateDao.datacitasusers(id)
        return MutableLiveData<List<ItemDate>>()
    }

    override fun getListDateByIdUser(id: String): LiveData<List<ItemDate>> {
        //return dateDao.getListDateByIdUser(id)
        return MutableLiveData<List<ItemDate>>()
    }

    override fun getDateById(id: Int): LiveData<Date> {
        return dateDao.getDateById(id)
    }
}