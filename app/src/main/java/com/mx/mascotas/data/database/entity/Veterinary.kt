package com.mx.mascotas.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.Gson

@Entity(tableName = "veterinary")
class Veterinary(

                @PrimaryKey var rfc: String,
                 var idRol: Int,
                 var nameVet: String,
                 var user: String,
                 var name:String,
                 var address: String,
                 var telephoneVet: String,
                 var start_time: String,
                 var end_time: String,
                 var start_day: String,
                 var end_day: String)   {

    fun toMap () : Map <String,Any>{

        val result =  HashMap<String, Any>()
        result["idRol"] = idRol
        result["nameVet"] = nameVet
        result["user"] = user
        result["name"] = name
        result["address"] = address
        result["telephoneVet"] = telephoneVet
        result["start_time"]= start_time
        result["end_time"] = end_time
        result["start_day"] = start_day
        result["end_day"] = end_day

        return  result
    }
}