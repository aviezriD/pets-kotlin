package com.mx.mascotas.presentation.ui.main.owner.pet

import com.mx.mascotas.data.database.entity.CatPet

interface PetContract {
    interface Navigator {
        fun showMessage(msg : String)
    }

    interface ViewModel{
        fun register(name: String,
                     race : String,
                     color : String,
                     weight : String,
                     sizeType : Int ,
                     type : Int,
                     sex : Boolean,
                     allergy : String,
                     dateBorn : String,
                     signs : String,
                     photo : String
                     )
        fun addCatType(list : List<CatPet>)

    }
}