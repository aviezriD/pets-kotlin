package com.mx.mascotas.domain.repository

import com.mx.mascotas.data.database.entity.Veterinary

interface VeterinaryRepository {

    fun registerVeterinary (veterinary : Veterinary)
    fun updateVeterinary(veterinary: Veterinary)
}