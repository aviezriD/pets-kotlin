package com.mx.mascotas.data.repository

import androidx.lifecycle.LiveData
import com.mx.mascotas.data.database.entity.Role
import com.mx.mascotas.data.database.entity.User
import com.mx.mascotas.data.repository.datasource.user.UserDataFactory
import com.mx.mascotas.domain.repository.UserRepository
import io.reactivex.Observable

class UserDataRepository: UserRepository {

    private val userDataFactory by lazy { UserDataFactory() }
    private val userDb by lazy { userDataFactory.createUserDataDb() }
    private val userDataFirebase by lazy { userDataFactory.createUserDataFireBase() }

    override fun login(user: String,type : Int, isConnect: Boolean): Observable<User> {
        return if( isConnect){
            userDataFirebase.login(user,type)
        }else
            userDb.login(user,type)
    }

    override fun register(user: User): Observable<Boolean> {
        return  userDataFirebase.insert(user)
    }

    override fun insert(user: User) {
        userDb.insert(user)
    }

    override fun getUserByIdRole(idRole: Int): LiveData<List<User>> {
        return userDb.getUserByIdRole(idRole)
    }
}