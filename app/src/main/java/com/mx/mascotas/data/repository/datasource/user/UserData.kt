package com.mx.mascotas.data.repository.datasource.user

import com.mx.mascotas.data.database.entity.User
import com.mx.mascotas.data.repository.datasource.BaseData
import io.reactivex.Observable

interface UserData<T,R>: BaseData<User,R> {
    fun login(user: String, password: String): Observable<T>
//    fun register(user: User) : Observable<T>
}