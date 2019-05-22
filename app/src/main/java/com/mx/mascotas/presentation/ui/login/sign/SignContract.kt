package com.mx.mascotas.presentation.ui.login.sign

interface SignContract {
    interface Navigator {
    }

    interface ViewModel{
        fun login(user : String, pwd : String, type : Int)
    }
}