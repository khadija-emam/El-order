package com.el_order.screens.signup

sealed class SignupState {
    object Idle : SignupState()
    object Loading : SignupState()
    object Success : SignupState()
    data class Error(
        val userNameError: Int? = null,
        val phoneError: Int? = null,
        val passwordError: Int? = null,
        val responseError: String? = null
    ) : SignupState()

}
