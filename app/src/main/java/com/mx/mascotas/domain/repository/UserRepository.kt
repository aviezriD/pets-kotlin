package com.mx.mascotas.domain.repository

import androidx.lifecycle.LiveData
import com.mx.mascotas.data.database.entity.Role
import com.mx.mascotas.data.database.entity.User
import io.reactivex.Observable

interface UserRepository {
    fun login(user: String, type : Int , isConnect: Boolean): Observable<User>
    fun register(user: User) : Observable<Boolean>
    fun insert(user: User)
    fun getUserByIdRole(idRole: Int): LiveData<List<User>>
}