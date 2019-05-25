package com.mx.mascotas.data.database.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "user", foreignKeys = [ForeignKey(entity = Role::class,parentColumns = ["id"],childColumns = ["idRole"])] )
data class User(var id : Int = 0,
                var idRole : Int = 0,
                @PrimaryKey var user : String = "",
                var name : String = "",
                var lastName : String = "",
                var email : String = "",
                var password : String = "",
                var phone : String = "",
                var token : String = "",
                var status : Int = 0) {

    fun toMap () : Map<String, Any> {
        val result =  HashMap<String, Any>()
        result["user"] = user
        result["email"] = email
        result["name"] = name
        result["lastName"] = lastName
        result["phone"] = phone
        result["password"] = password
        result["token"] = token

        return  result
    }

    fun toMapSecurity() : Map<String, Any> {
        val result =  HashMap<String, Any>()
        result["user"] = user
        result["password"] = password
        return  result
    }
}