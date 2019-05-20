package com.mx.mascotas.domain.repository

import com.mx.mascotas.data.database.entity.User
import io.reactivex.Observable

interface UserRepository {
    fun login(user: String, password: String, isConnect: Boolean): Observable<User>
    fun register(user: User) : Observable<Boolean>
}