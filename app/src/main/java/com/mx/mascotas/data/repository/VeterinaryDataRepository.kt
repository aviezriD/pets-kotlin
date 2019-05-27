package com.mx.mascotas.data.repository

import com.mx.mascotas.data.database.entity.Veterinary
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