package com.example.dhani_market.auth.signin

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.dhani_market.MainActivity
import com.example.dhani_market.R
import com.example.dhani_market.login.LoginResponse
import com.google.gson.Gson


class SigninFragment : Fragment(), SigninContract.View {
    lateinit var presenter:SigninPresenter
    var progreessDialog: Dialog? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter=SigninPresenter(this)
        if(!FoodMarket.getApp().getToken().isNullOrEmpty()){
            val home = Intent(activity, MainActivity::class.java)
            startActivity(home)
            activity?.finish()
        }
        initDummy()
        initView()
        btnSignup.setOnClickListener{
            var email = etEmail.text.toString()
            var password = etPassword.text.toString()
            if(email.isNullOrEmpty()){
                etEmail.error="Silahkan Masukkan Emailnya"
                etEmail.requestFocus()
            }else if (password.isNullOrEmpty()){
                etPassword.error="Silahkan Masukkan Passwordnya"
                etPassword.requestFocus()
            }else{
                presenter.submit:Login(email, password)
            }
        }
    }

    override fun onLoginSuccess(loginResponse: LoginResponse) {
        FoodMarket.getApp().setToken(loginResponse.access_token)
        val gson=Gson()
        val gson=gson.toJson(loginResponse.user)
        FoodMarket.getApp().setUser(json)

        val home = Intent(activity, MainActivity::class.java)
        startActivity(home)
        activity.finish()
    }

    override fun onLoginFailed(message: String) {
        Toast.makeText(activity,message,Toast.LENGTH_SHORT).show()
    }

    override fun initDummy(){
        etEmail.setText("dhanifauzi48@gmail.com")
        etPassword.setText("123456")
    }

    override fun initView(){
        progreessDialog= Dialog(requireContext())
        val DialogLayout=layoutInflater.inflate(R.layout.dialog_loader, null)
        progreessDialog?.let{
            it.setContextView(dialogLayout)
            it.setCancelable(false)
            it.window?.setBackgroundDrawableResource(android.R.color.transparent)
        }
    }

    override fun showLoading() {
        progreessDialog?.show()
    }

    override fun dismissLoading() {
        progreessDialog?.dismiss()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

}
