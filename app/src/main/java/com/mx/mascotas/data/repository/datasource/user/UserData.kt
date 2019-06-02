package com.mx.mascotas.data.repository.datasource.user

import androidx.lifecycle.LiveData
import com.mx.mascotas.data.database.entity.User
import com.mx.mascotas.data.repository.datasource.BaseData
import io.reactivex.Observable

interface UserData<T,R>: BaseData<User,R> {
    fun login(user: String,type : Int): Observable<T>
    fun getUserByIdRole(idRole : Int) : LiveData<List<T>>
}