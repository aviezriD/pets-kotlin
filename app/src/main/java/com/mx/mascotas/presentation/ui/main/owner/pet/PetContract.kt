package com.mx.mascotas.presentation.ui.main.owner.pet

import com.mx.mascotas.data.database.entity.CatPet
import com.mx.mascotas.data.database.entity.CatPetSize

interface PetContract {
    interface Navigator {
        fun showMessage(msg : String)
        fun success()
    }

    interface ViewModel{
        fun register(name: String,
                     race : String,
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
        fun addCatTypeSize(list : List<CatPetSize>)
        fun getPetById(id: String)
        fun setIndices(index : Int , index2: Int)


    }
}