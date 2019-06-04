package com.mx.mascotas.data.repository.datasource.catdaylab

import androidx.lifecycle.LiveData
import com.mx.mascotas.data.database.dao.CatDayLabDao
import com.mx.mascotas.data.database.entity.CatDayLab

class CatDayLabDataDb(val catDayLabDao: CatDayLabDao): CatDayLabData<Unit> {
    override  fun getListCatDayLab(): LiveData<List<CatDayLab>>{
        return catDayLabDao.getListCatDayLab()
    }

    override fun insert(obj: CatDayLab) {
        catDayLabDao.insert(obj)
    }

    override fun update(obj: CatDayLab) {
        catDayLabDao.update(obj)
    }

    override fun delete(obj: CatDayLab) {
        catDayLabDao.delete(obj)
    }
}

