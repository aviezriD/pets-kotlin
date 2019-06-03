package com.mx.mascotas.data.repository.datasource.catsubservices

import androidx.lifecycle.LiveData
import com.mx.mascotas.data.database.dao.CatSubserviceDao
import com.mx.mascotas.data.database.entity.CatSubService

class CatSubserviceDataDb (val catSubserviceDao: CatSubserviceDao): CatSubserviceData<Unit>{
    override fun getListCatSubservices(): LiveData<List<CatSubService>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return catSubserviceDao.getListCatSubservice()
    }

    override fun insert(obj: CatSubService) {
        catSubserviceDao.insert(obj)
    }

    override fun update(obj: CatSubService) {
        catSubserviceDao.update(obj)
    }

    override fun delete(obj: CatSubService) {
        catSubserviceDao.delete(obj)
    }
}

