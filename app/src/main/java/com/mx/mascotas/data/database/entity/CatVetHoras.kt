package com.mx.mascotas.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class CatVetHoras (@PrimaryKey var id : Int, var name : String, var estatus: Boolean= true) {
    override fun toString(): String {
        return name
    }
}


