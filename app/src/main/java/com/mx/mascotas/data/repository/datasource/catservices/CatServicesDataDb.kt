package com.mx.mascotas.data.repository.datasource.catservices

import androidx.lifecycle.LiveData
import com.mx.mascotas.data.database.dao.CatServicesDao
import com.mx.mascotas.data.database.entity.CatService

class CatServicesDataDb (val catServicesDao: CatServicesDao): CatServicesData<Unit>{
    override fun getListCatServices(): LiveData<List<CatService>>{
        return catServicesDao.getListCatServices()
    }
    override fun insert(obj: CatService) {
        catServicesDao.insert(obj)
    }

    override fun update(obj: CatService) {
        catServicesDao.update(obj)
    }

    override fun delete(obj: CatService) {
        catServicesDao.delete(obj)
    }
}


