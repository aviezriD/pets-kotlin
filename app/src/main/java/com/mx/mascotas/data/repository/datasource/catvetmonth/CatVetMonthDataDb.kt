package com.mx.mascotas.data.repository.datasource.catvetmonth

import androidx.lifecycle.LiveData
import com.mx.mascotas.data.database.dao.CatVetMonthDao
import com.mx.mascotas.data.database.entity.CatVetMonth

class CatVetMonthDataDb (val catVetMonthDao:CatVetMonthDao): CatVetMonthData<Unit>{
    override fun getListCatVetMonth(): LiveData<List<CatVetMonth>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return catVetMonthDao.getListCatVetMonth()
    }

    override fun insert(obj: CatVetMonth) {
        catVetMonthDao.insert(obj)
    }

    override fun update(obj: CatVetMonth) {
        catVetMonthDao.update(obj)
    }

    override fun delete(obj: CatVetMonth) {
        catVetMonthDao.delete(obj)
    }
}

