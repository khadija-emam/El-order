package com.el_order.data.repository.auth

import com.el_order.data.model.User

interface AuthRepository {
    suspend fun signup(user: User): Result<User?>
}