package com.el_order.screens.signup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.el_order.R
import com.el_order.databinding.FragmentSignupBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SignupFragment : Fragment() {
    private lateinit var binding: FragmentSignupBinding
    private val signUpViewModel: SignupViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        FragmentSignupBinding.inflate(inflater, container, false).apply {
            viewModel = signUpViewModel
        }
        observeSignupState(signUpViewModel.signupState)
        return binding.root
    }

    private fun observeSignupState(signupState: Flow<SignupState>) {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                signupState.collect {
                    when (it) {
                        is SignupState.Error -> showErrorMessage(it)
                        is SignupState.Loading -> showLoadingDialog()
                    }
                }
            }
        }
    }

    private fun showLoadingDialog() {
        //Todo
    }

    private fun showErrorMessage(error: SignupState.Error) {
        when {
            error.userNameError != null -> {
                binding.username.error = getString(error.userNameError)
            }
            error.phoneError != null -> {
                binding.phone.error = getString(error.phoneError)
            }
            error.passwordError != null -> {
                binding.password.error = getString(error.passwordError)
            }
        }
    }

}