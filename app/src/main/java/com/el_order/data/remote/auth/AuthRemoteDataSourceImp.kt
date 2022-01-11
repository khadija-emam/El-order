package com.el_order.data.remote.auth

import com.el_order.data.model.BaseObjectResponse
import com.el_order.data.model.User
import retrofit2.Response
import javax.inject.Inject

class AuthRemoteDataSourceImp @Inject constructor(
    private val authApi: AuthApi

) : AuthRemoteDataSource {
    override suspend fun signup(user: User): Result<User?> =
        getResultFromResponse { authApi.signup(user) }


    private suspend fun <T> getResultFromResponse(getResponse: suspend () -> Response<BaseObjectResponse<T>>): Result<T?> {
        return try {
            val response = getResponse.invoke()
            if (response.isSuccessful) {
                Result.success(response.body()?.data)
            } else Result.failure(Exception(response.body()?.message))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

}