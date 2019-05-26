package com.mx.mascotas.presentation.ui.main.owner

import com.mx.mascotas.domain.entity.ItemPet

interface OwnerContract {
    interface Navigator {
    }

    interface ViewModel{
        fun addPets(list: List<ItemPet>)
    }
}