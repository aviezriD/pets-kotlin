package com.mx.mascotas.data.repository.datasource.catvetdia

import androidx.lifecycle.LiveData
import com.mx.mascotas.data.database.dao.CatVetDiaDao
import com.mx.mascotas.data.database.entity.CatVetDia

class CatVetDiaDataDb(val catVetDiaDao: CatVetDiaDao): CatVetDiaData<Unit> {
    override fun getListCatVetDia(): LiveData<List<CatVetDia>> {
        return catVetDiaDao.getListCatVetDia()
    }
    override fun insert(obj: CatVetDia) {
        catVetDiaDao.insert(obj)
    }

    override fun update(obj: CatVetDia) {
        catVetDiaDao.update(obj)
    }

    override fun delete(obj: CatVetDia) {
        catVetDiaDao.delete(obj)
    }
}

