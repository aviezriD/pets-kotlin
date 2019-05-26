package com.mx.mascotas.data.repository.datasource.catdatestatus

import androidx.lifecycle.LiveData
import com.mx.mascotas.data.database.dao.CatDateStatusDao
import com.mx.mascotas.data.database.entity.CatDateStatus

class CatDateStatusDataDb (val catDateStatusDao: CatDateStatusDao): CatDateStatusData<Unit>{
    override fun getListCatDateStatus(): LiveData<List<CatDateStatus>>{
        return catDateStatusDao.getListCatDateStatus()
    }

    override fun insert(obj: CatDateStatus){
        catDateStatusDao.insert(obj)
    }

    override fun update(obj: CatDateStatus) {
        catDateStatusDao.update(obj)
    }

    override fun delete(obj: CatDateStatus) {
        catDateStatusDao.delete(obj)
    }

}
