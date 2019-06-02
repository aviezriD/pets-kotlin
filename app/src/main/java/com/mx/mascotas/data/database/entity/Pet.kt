package com.mx.mascotas.data.database.entity

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
@Entity
data class Pet(@PrimaryKey var id : String = "",
               var name :String = "",
               var race: String = "",
               var weight: Float = 0f,
//               var size : Int = 0,
               var type : Int = 0,
               var sex : Boolean = true,
               var typeSize : Int = 0,
               var allergy :String = "",
               var dateBorn: Long = 0L,
               var signs: String = "",
//               var description: String = "",
               var photo : String = "",
                var owner : String = ""){
    fun toMap() : Map<String, Any>{
        val result =  HashMap<String, Any>()

        result["name"] = name
        result["race"] = race
//        result["color"] = color
        result["weight"] = weight
//        result["size"] = size
        result["type"] = type
        result["sex"] = sex
        result["typeSize"] = typeSize
        result["allergy"] = allergy
        result["dateBorn"] = dateBorn
        result["signs"] = signs
//        result["description"] = description
        result["photo"] = photo
        return result
    }

    override fun toString(): String {
        return name
    }
}