package com.mx.mascotas.data.repository

import com.mx.mascotas.data.database.entity.User
import com.mx.mascotas.data.repository.datasource.user.UserDataFactory
import com.mx.mascotas.domain.repository.UserRepository
import io.reactivex.Observable

class UserDataRepository: UserRepository {

    private val userDataFactory by lazy { UserDataFactory() }
//    private val userDb by lazy { userDataFactory.createUserDataDb() }
    private val userDataFirebase by lazy { userDataFactory.createUserDataFireBase() }

    override fun login(user: String, password: String, isConnect: Boolean): Observable<User> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun register(user: User): Observable<Boolean> {
        return  userDataFirebase.insert(user)
    }
}