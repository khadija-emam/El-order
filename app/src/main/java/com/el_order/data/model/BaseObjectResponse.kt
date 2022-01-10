package com.el_order.data.model

class BaseObjectResponse<T>(
    val error: Boolean,
    val errors: String,
    val message: String,
    val data: T,
)