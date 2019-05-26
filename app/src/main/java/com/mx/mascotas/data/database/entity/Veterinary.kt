package com.mx.mascotas.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.Gson

@Entity(tableName = "veterinary")
class Veterinary(

                @PrimaryKey var rfc: String,
                 var idRol: Int,
                 var nameVet: String,
                 var coordinate: String,
                 var address: String,
                 var telephoneVet: String)   {

    fun toMap () : Map <String,Any>{

        val result =  HashMap<String, Any>()
        result["idRol"] = idRol
        result["nameVet"] = nameVet
        result["coordinate"] = coordinate
        result["address"] = address
        result["telephoneVet"] = telephoneVet

        return  result
    }
}