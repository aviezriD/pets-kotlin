package com.mx.mascotas.domain.usecase.sign

import io.reactivex.Observable


interface SignUseCase {
    fun login(user: String, pwd : String , type: Int) : Observable<Int>
}