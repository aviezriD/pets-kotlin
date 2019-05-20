package com.mx.mascotas.domain.usecase.registry

import com.mx.mascotas.data.database.entity.User
import io.reactivex.Observable

interface RegistryUseCase {
    fun register(user: User): Observable<Boolean>
}