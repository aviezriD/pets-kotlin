package com.mx.mascotas.data.repository.datasource.catvethoras

import androidx.lifecycle.LiveData
import com.mx.mascotas.data.database.dao.CatVetHorasDao
import com.mx.mascotas.data.database.entity.CatVetHoras


class CatVetHorasDataDb (val catVetHorasDao:CatVetHorasDao): CatVetHorasData<Unit>{
    override fun getListCatVetHoras(): LiveData<List<CatVetHoras>> {
        return catVetHorasDao.getListCatVetHoras()
    }
    override fun insert(obj: CatVetHoras) {
        catVetHorasDao.insert(obj)
    }

    override fun update(obj: CatVetHoras) {
        catVetHorasDao.update(obj)
    }

    override fun delete(obj: CatVetHoras) {
        catVetHorasDao.delete(obj)
    }
}
