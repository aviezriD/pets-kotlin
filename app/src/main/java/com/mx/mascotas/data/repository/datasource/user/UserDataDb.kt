package com.mx.mascotas.data.repository.datasource.user

import com.mx.mascotas.data.database.dao.UserDao
import com.mx.mascotas.data.database.entity.User
import com.mx.mascotas.data.repository.datasource.BaseDb
import io.reactivex.Observable

class UserDataDb(private val daoUser: UserDao) : BaseDb<User>(daoUser), UserData<User,Unit> {
    override fun login(user: String, password: String): Observable<User> {
        return daoUser.getUserSingle(user,password).toObservable()
    }

/*    override fun register(user: User): Observable<User> {
        return daoUser.insertUser(user)
            .map { user }
            .toObservable()
    }*/
}