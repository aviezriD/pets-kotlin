package com.mx.mascotas.data.repository.datasource.date

import com.mx.mascotas.data.database.dao.DateDao
import com.mx.mascotas.data.database.entity.Date
import com.mx.mascotas.data.repository.datasource.BaseData
import com.mx.mascotas.data.repository.datasource.BaseDb

class DateDataDb (var dateData: DateDao) : DateData<Date,Unit>, BaseDb<Date>(dateData)
{
}