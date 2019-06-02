package com.mx.mascotas.data.repository

import androidx.lifecycle.LiveData
import com.mx.mascotas.data.database.entity.CatVetDia
import com.mx.mascotas.data.database.entity.CatVetHoras
import com.mx.mascotas.data.database.entity.Veterinary
import com.mx.mascotas.data.repository.datasource.catvetdia.CatVetDiaDataFactory
import com.mx.mascotas.data.repository.datasource.catvethoras.CatVetHorasDataFactory
import com.mx.mascotas.data.repository.datasource.veterinary.VeterinaryDataFactory
import com.mx.mascotas.domain.repository.VeterinaryRepository

class VeterinaryDataRepository: VeterinaryRepository {

    private val veterinaryDataFactory by lazy { VeterinaryDataFactory() }
    private val veterinaryDb by lazy { veterinaryDataFactory.createVeterinaryDataDb() }
    private val veterinaryDataFirebase by lazy {veterinaryDataFactory.createVeterinaryDataFireBase()}

    override fun registerVeterinary(veterinary: Veterinary) {
        veterinaryDb.insert(veterinary)

    }

    override fun updateVeterinary(veterinary: Veterinary) {
        veterinaryDb.update(veterinary)
    }


}