package com.mx.mascotas.data.repository.datasource.user

import androidx.lifecycle.LiveData
import com.google.firebase.database.FirebaseDatabase
import com.mx.mascotas.data.database.entity.User
import com.mx.mascotas.data.utils.Constants
import com.mx.mascotas.data.utils.RxFirebaseUtils
import io.reactivex.Observable

class UserDataFireBase(private var firebaseDatabase: FirebaseDatabase): UserData<User,Observable<Boolean>> {
    override fun login(user: String, type : Int): Observable<User> {
        val (data, pwd) = getNodoByIdRole(type,user)
        return  RxFirebaseUtils.observeValueEvent(firebaseDatabase.reference.child(data))
            .map { dataSnapshot ->
            if (dataSnapshot.exists()) {
                val temp = dataSnapshot.getValue(User::class.java) as User
                temp
            } else {
                User()
            }
        }
    }

    private fun getNodoByIdRole(idRole : Int, user: String): Pair<String,String>{
        val data : String
        val pwd : String
        if (idRole == 0){
            data = Constants.FireBasePaths.PATH_OWNER_DATA.plus(user)
            pwd = Constants.FireBasePaths.PATH_OWNER_PWD.plus(user)
        }else{
            data = Constants.FireBasePaths.PATH_VET_DATA.plus(user)
            pwd = Constants.FireBasePaths.PATH_VET_PWD.plus(user)
        }
        return Pair(data,pwd)
    }

    override fun insert(obj: User): Observable<Boolean> {
        val (data, pwd) = getNodoByIdRole(obj.idRole,obj.user)

        return RxFirebaseUtils.observeValueEvent(firebaseDatabase.reference.child(data))
            .flatMap { dataSnapshot ->
                if (dataSnapshot.exists()) {
                    Observable.just(false)
                } else {
                    RxFirebaseUtils.apply(firebaseDatabase.reference.child(data).updateChildren(obj.toMap()))
                        .flatMap { RxFirebaseUtils.apply(firebaseDatabase.reference.child(pwd).updateChildren(obj.toMapSecurity())) }
                }
            }
    }

    override fun update(obj: User): Observable<Boolean> {
        val (data, pwd) = getNodoByIdRole(obj.idRole,obj.user)
        return RxFirebaseUtils.apply(firebaseDatabase.reference.child(data).updateChildren(obj.toMap()))
            .flatMap { RxFirebaseUtils.apply(firebaseDatabase.reference.child(pwd).updateChildren(obj.toMapSecurity())) }
    }

    override fun delete(obj: User): Observable<Boolean> {
        val (data, pwd) = getNodoByIdRole(obj.idRole,obj.user)
        return RxFirebaseUtils.apply(firebaseDatabase.reference.child(data).removeValue())
            .flatMap { RxFirebaseUtils.apply(firebaseDatabase.reference.child(pwd).removeValue()) }
    }

    override fun getUserByIdRole(idRole: Int): LiveData<List<User>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}