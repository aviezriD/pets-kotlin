package com.mx.mascotas.data.repository.datasource.user

import androidx.lifecycle.LiveData
import com.mx.mascotas.data.database.dao.UserDao
import com.mx.mascotas.data.database.entity.User
import com.mx.mascotas.data.repository.datasource.BaseDb
import io.reactivex.Observable

class UserDataDb(private val daoUser: UserDao) : BaseDb<User>(daoUser), UserData<User,Unit> {
    override fun login(user: String,  type: Int): Observable<User> {
        return daoUser.getUserSingle(user,type).toObservable()
    }

    override fun getUserByIdRole(idRole: Int): LiveData<List<User>> {
        return daoUser.getListUserByIdRole(idRole)
    }
}