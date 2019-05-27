package com.mx.mascotas.data.repository.datasource.catvetdia

import androidx.lifecycle.LiveData
import com.mx.mascotas.data.database.entity.CatVetDia
import com.mx.mascotas.data.repository.datasource.BaseData


interface CatVetDiaData<R>: BaseData<CatVetDia, R> {
    fun getListCatVetDia(): LiveData<List<CatVetDia>>
}
