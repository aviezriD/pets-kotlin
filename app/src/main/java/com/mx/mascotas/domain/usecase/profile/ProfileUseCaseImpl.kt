package com.mx.mascotas.domain.usecase.profile

import com.mx.mascotas.data.database.entity.User
import com.mx.mascotas.domain.repository.PreferenceRepository
import com.mx.mascotas.domain.repository.UserRepository
import io.reactivex.Observable

class ProfileUseCaseImpl(var userRepositiry: UserRepository, var preferenceRepository: PreferenceRepository)  : ProfileUseCase {

    override fun getUserProfile(): Observable<User> {

        return userRepositiry.login(preferenceRepository.getUserName(), preferenceRepository.getRole(),false)
    }


}