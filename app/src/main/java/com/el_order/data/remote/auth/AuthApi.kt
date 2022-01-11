package com.el_order.data.remote.auth


import com.el_order.data.model.BaseObjectResponse
import com.el_order.data.model.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST


interface AuthApi {
    @POST(SIGNUP_URL)
    suspend fun signup(@Body user: User): Response<BaseObjectResponse<User>>
}