package com.mx.mascotas.domain.usecase.sign

import android.util.Log
import com.mx.mascotas.domain.repository.PreferenceRepository
import com.mx.mascotas.domain.repository.UserRepository
import com.mx.mascotas.presentation.ui.utils.Utils
import io.reactivex.Observable
import java.util.concurrent.ExecutorService

class SignUseCaseImpl(private var userRepository: UserRepository,private val executor: ExecutorService,private val preference: PreferenceRepository): SignUseCase {

    override fun login(user: String, pwd: String, type: Int): Observable<Int> {
        val isConnect = Utils.isOnline()
        return userRepository.login(user,type,isConnect)
            .map {u ->
                Log.i("sign","$u")
                if (u.user.isEmpty()){
                    0 //no exits user
                }else{
                    if ( u.password == pwd){
                        if(isConnect){
                            executor.execute {
                                u.idRole = type
                                userRepository.insert(u)
                            }
                        }
                        preference.setRole(type)
                        preference.setUserName(u.user)
                        1 // succes login
                    }else
                        2 //  incorrect password
                }
            }
    }
}