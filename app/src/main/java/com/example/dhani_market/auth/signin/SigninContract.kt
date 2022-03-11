package com.example.dhani_market.auth.signin

import com.example.dhani_market.base.BasePresenter
import com.example.dhani_market.model.LoginResponse

interface SigninContract {
    interface BaseView{ //cek disini klo salah (di pak rosid ada tulisan view nya)
        fun onLoginSuccess(loginResponse: LoginResponse)
        fun onLoginFailed(message:String)
    }
    interface Presenter:SigninContract, BasePresenter {
        fun submitlogin(email:String, password:String)
    }
}