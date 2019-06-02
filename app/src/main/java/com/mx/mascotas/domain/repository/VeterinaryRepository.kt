package com.mx.mascotas.domain.repository

import androidx.lifecycle.LiveData
import com.mx.mascotas.data.database.entity.CatVetDia
import com.mx.mascotas.data.database.entity.CatVetHoras
import com.mx.mascotas.data.database.entity.Veterinary

interface VeterinaryRepository {

    fun registerVeterinary (veterinary : Veterinary)
    fun updateVeterinary(veterinary: Veterinary)

}