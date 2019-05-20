package com.mx.mascotas.presentation.ui.login.registry

interface RegistryContract {
    interface Navigator {
    }

    interface ViewModel{
        fun register(email : String, pwd : String, name: String)
    }
}