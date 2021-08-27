package com.abcode.shoestore.screens.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    private val _email = MutableLiveData<String>()
    val email: LiveData<String>
        get() = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String>
        get() = _password

    private val _eventLogin = MutableLiveData<Boolean>()
    val eventLogin: LiveData<Boolean>
        get() = _eventLogin

    init {
        _email.value = ""
        _password.value = ""
    }

    /*
     * Login button is pressed, the user can login. I used ViewModel logic here even if I could have
     * placed a simple button click listener. I preferred this way since in a full Login Scenario you won't
     * just listen to the login, but you would have classes that can handle the call to the backend,
     * to check if the user can login.
     */
    fun onLogin(){
        _eventLogin.value = true
    }

    fun onLoggedIn(){
        _eventLogin.value = false
    }

}