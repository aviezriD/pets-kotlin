package com.mx.mascotas.data.repository.datasource.catvaccination

import androidx.lifecycle.LiveData
import com.mx.mascotas.data.database.dao.CatVaccinationDao
import com.mx.mascotas.data.database.entity.CatVaccination

class CatVaccinationDataDb(val catVaccinationDao: CatVaccinationDao): CatVaccinationData<Unit> {

    override  fun getListCatVaccination(): LiveData<CatVaccination>{
        return  catVaccinationDao.getListCatVaccination()
    }

    override fun insert(obj: CatVaccination) {
        return catVaccinationDao.insert(obj)
    }

    override fun update(obj: CatVaccination) {
        return catVaccinationDao.update(obj)
    }

    override fun delete(obj: CatVaccination) {
       return catVaccinationDao.delete(obj)
    }
}

