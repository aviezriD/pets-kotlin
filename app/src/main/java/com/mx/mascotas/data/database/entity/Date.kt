package com.mx.mascotas.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "date")
class Date(@PrimaryKey(autoGenerate = false) var id: String, var idRol: Int, var idPet: Int, var idUser: String,  var namePet: String,
           var typeService: String, var typeSubservice: String,
           var nameVeterinarian: String, var locationVeterinarian: String,
           var date: Long, var hour: Long, var description: String, var estatus: Int) {

    fun toMap (): Map<String,Any>{
        val detailsDate = HashMap<String,Any>()
        detailsDate["namePet"] = namePet
        detailsDate["typeService"] = typeService
        detailsDate["typeSubservice"] = typeSubservice
        detailsDate["nameVeterinarian"] = nameVeterinarian
        detailsDate["locationVeterinarian"] = locationVeterinarian
        detailsDate["date"] = date
        detailsDate["hour"] = hour
        detailsDate["description"] = description
        detailsDate["estatus"] = estatus

        return  detailsDate
    }

}

