package com.mx.mascotas.data.database.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName="userService", foreignKeys = [ForeignKey(entity = CatService::class, parentColumns = ["id"], childColumns = ["idCatService"])] )
data class UserService ( @PrimaryKey(autoGenerate = true) var id: Int= 0,
                        var user : String = "",
                        var idCatService: Int = 0
                        ){
    fun toMap () : Map<String, Any> {
        val result =  HashMap<String, Any>()
        result["user"]=user


        return  result
    }
    
}