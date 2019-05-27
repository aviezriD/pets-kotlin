package com.mx.mascotas.data.database.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "user", foreignKeys = [ForeignKey(entity = Role::class,parentColumns = ["id"],childColumns = ["idRole"])] )
data class User(var id : Int = 0,
                var idRole : Int = 0,
                @PrimaryKey var user : String = "",
                var name : String = "",
                var cedula : String = "",
                var lastName : String = "",
                var email : String = "",
                var password : String = "",
                var phone : String = "",
                var token : String = "",
                var status : Int = 0) {

    fun toMap () : Map<String, Any> {
        val result =  HashMap<String, Any>()
        result["user"]=user
        result["name"]=name
        result["cedula"]=cedula
        result["lastName"]=lastName
        result["email"]=email
        result["password"]=password
        result["phone"]= phone
        result["token"]= token
        result["status"]=status

        return  result
    }

    fun toMapSecurity() : Map<String, Any> {
        val result =  HashMap<String, Any>()
        result["user"] = user
        result["password"] = password
        return  result
    }

    override fun toString(): String {
        return name
    }
}