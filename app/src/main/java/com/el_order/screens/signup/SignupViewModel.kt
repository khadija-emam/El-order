package com.el_order.screens.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.el_order.R
import com.el_order.data.model.User
import com.el_order.data.repository.auth.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor(private val authRepository: AuthRepository) :
    ViewModel() {
    val user = User()
    private val _signupState = MutableStateFlow<SignupState>(SignupState.Idle)

    val signupState: Flow<SignupState>
        get() = _signupState

    fun signUp() {
        if (validation()) {
            viewModelScope.launch {
                val result = authRepository.signup(user)
                if (result.isSuccess) {
                    _signupState.value = SignupState.Success
                } else {
                    _signupState.value =
                        SignupState.Error(responseError = result.exceptionOrNull()?.message)
                }
            }
        }
    }

    private fun validation(): Boolean {
        return when {
            user.userName.isNullOrEmpty() -> {
                _signupState.value = SignupState.Error(userNameError = R.id.username_error)
                false
            }
            user.phoneNumber.isNullOrEmpty() -> {
                _signupState.value = SignupState.Error(phoneError = R.id.phone_error)
                false
            }
            user.password.isNullOrEmpty() -> {
                _signupState.value = SignupState.Error(passwordError = R.id.password_error)
                false
            }
            else -> true
        }
    }
}