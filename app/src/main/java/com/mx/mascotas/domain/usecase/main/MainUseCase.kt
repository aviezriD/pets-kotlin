package com.mx.mascotas.domain.usecase.main

import com.mx.mascotas.data.database.entity.User
import io.reactivex.Observable

interface MainUseCase {
    fun getUser(): Observable<User>

}