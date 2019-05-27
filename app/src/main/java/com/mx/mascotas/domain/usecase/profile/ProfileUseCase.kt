package com.mx.mascotas.domain.usecase.profile

import com.mx.mascotas.data.database.entity.User
import io.reactivex.Observable

interface ProfileUseCase {

    fun getUserProfile() : Observable<User>

}