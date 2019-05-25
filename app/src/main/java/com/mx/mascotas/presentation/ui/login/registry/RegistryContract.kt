package com.mx.mascotas.presentation.ui.login.registry

interface RegistryContract {
    interface Navigator {
    }

    interface ViewModel{
        fun register(user: String,email : String, pwd : String, pwd2 : String, name: String, lastName: String,phone : String, type : Int)
    }
}