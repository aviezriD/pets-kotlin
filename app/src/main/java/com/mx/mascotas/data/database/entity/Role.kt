package com.mx.mascotas.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "role")
data class Role(@PrimaryKey var id : Int = 0,
                var name : String =  "") {
}