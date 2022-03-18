package com.example.dhani_market.auth.signin

import com.example.dhani_market.base.BasePresenter
import com.example.dhani_market.base.BaseView
import com.example.dhani_market.login.LoginResponse

interface SigninContract {
    interface View : BaseView {

        fun onLoginSuccess(loginResponse: LoginResponse)
        fun onLoginFailed(message:String)
    }
    interface Presenter:SigninContract, BasePresenter {
        fun submitlogin(email:String, password:String)
    }
}