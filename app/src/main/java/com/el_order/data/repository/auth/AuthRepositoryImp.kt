package com.el_order.data.repository.auth

import com.el_order.data.model.User
import com.el_order.data.remote.auth.AuthRemoteDataSource
import javax.inject.Inject

class AuthRepositoryImp @Inject constructor(private val remoteDataSource: AuthRemoteDataSource) :
    AuthRepository {
    suspend fun signup(user: User): Result<User?> {
        return remoteDataSource.signup(user)
    }
}