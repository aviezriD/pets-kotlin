package com.mx.mascotas.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class CatVaccination (@PrimaryKey var id: Int, var RFC: String, var lote: String, var validacion: Boolean){
    fun toMap () : Map<String, Any> {
        val result =  HashMap<String, Any>()
        result["RFC"]=RFC
        result["lote"]=lote
        result["validacion"]=validacion

        return  result
    }
}

