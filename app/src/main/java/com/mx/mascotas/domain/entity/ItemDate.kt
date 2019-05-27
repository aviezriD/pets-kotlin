package com.mx.mascotas.domain.entity

import com.mx.mascotas.data.database.entity.CatSubService

data class ItemDate( var idPet: Int,
                     var namePet : String,
                    var hour : String,
                    var date : String,
                    var typeService : String,
                    var typeSubservice: String,
                    var idUser: Int,
                    var name: String,
                    var estatus :Int) {

}