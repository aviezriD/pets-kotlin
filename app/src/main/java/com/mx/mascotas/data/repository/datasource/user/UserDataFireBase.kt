package com.mx.mascotas.data.repository.datasource.user

import android.util.Log
import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.FirebaseDatabase
import com.mx.mascotas.data.database.entity.User
import com.mx.mascotas.data.utils.Constants
import com.mx.mascotas.data.utils.RxFirebaseUtils
import io.reactivex.Observable

class UserDataFireBase(private var firebaseDatabase: FirebaseDatabase): UserData<DataSnapshot,Observable<Boolean>> {
    override fun login(user: String, password: String): Observable<DataSnapshot> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun insert(obj: User): Observable<Boolean> {
        val data : String
        val pwd : String
        if (obj.idRole == 0){
            data = Constants.FireBasePaths.PATH_OWNER_DATA.plus(obj.email)
            pwd = Constants.FireBasePaths.PATH_OWNER_PWD.plus(obj.email)
        }else{
            data = Constants.FireBasePaths.PATH_VET_DATA.plus(obj.email)
            pwd = Constants.FireBasePaths.PATH_VET_PWD.plus(obj.email)
        }
        return RxFirebaseUtils.observeValueEvent(firebaseDatabase.reference.child(data))
            .flatMap { dataSnapshot ->
                var task: Task<Void>
                if (dataSnapshot.exists()) {
                    Log.i("FirebaseNode", "Existe")
                    Observable.just(true)
                } else {
                    Log.i("FirebaseNode", "No Existe")
                    RxFirebaseUtils.apply(firebaseDatabase.reference.child(data).updateChildren(obj.toMap()))
                        .flatMap { RxFirebaseUtils.apply(firebaseDatabase.reference.child(pwd).updateChildren(obj.toMapSecurity())) }
                }
            }
    }

    override fun update(obj: User): Observable<Boolean> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(obj: User): Observable<Boolean> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}