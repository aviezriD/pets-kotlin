package com.mx.mascotas.domain.usecase.date

import androidx.lifecycle.LiveData
import com.mx.mascotas.domain.entity.ItemDate

interface DateUseCase{
    fun datadetails(): LiveData<List<ItemDate>>



}