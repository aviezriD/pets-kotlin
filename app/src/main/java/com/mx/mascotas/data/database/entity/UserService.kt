package com.mx.mascotas.data.database.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName="userService", foreignKeys = [ForeignKey(entity = CatService::class, parentColumns = ["id"], childColumns = ["idCatService"])] )
data class UserService (var id: Int= 0,
                        @PrimaryKey var user : String = "",
                        var idCatService: Int = 0,
                        var typeService: String = ""
                        ){
    fun toMap () : Map<String, Any> {
        val result =  HashMap<String, Any>()
        result["user"]=user
        result["typeService"]=typeService


        return  result
    }

    override fun toString(): String {
        return typeService
    }
}