package com.el_order.data.remote.auth

import com.el_order.data.model.User
import okhttp3.Response

interface AuthRemoteDataSource {
    suspend fun signup(user: User): Result<User?>
}