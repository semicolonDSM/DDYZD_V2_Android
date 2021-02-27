package com.semicolon.ddyzd_android.ul.activity

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.semicolon.ddyzd_android.databinding.ActivityLoginBinding
import com.semicolon.ddyzd_android.viewmodel.LoginViewModel
import com.semicolon.dsm_sdk_v1.DsmSdk

class LoginActivity : AppCompatActivity() {
    lateinit var binding:ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        val sharedPreference= getSharedPreferences("device", Context.MODE_PRIVATE)
        val deviceToken=sharedPreference.getString("device_token","").toString()
        super.onCreate(savedInstanceState)
        val instance= DsmSdk.instance
        instance.initSDK("qwer","qwer","http://www.google.com")
        val viewModel=LoginViewModel(instance,this,deviceToken)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        binding.vm=viewModel
        binding.loginWebView.settings.javaScriptEnabled=true
        binding.loginWebView.loadUrl("https://semicolondsm.xyz/mobile/loginslide")
        setContentView(binding.root)
    }

    fun finish(logined:Boolean,name:String,email:String,gcn:String,accessToken:String,refreshToken:String){
        intent.putExtra("get_name",name)
        intent.putExtra("get_email",email)
        intent.putExtra("get_gcn",gcn)
        intent.putExtra("get_access_token",accessToken)
        intent.putExtra("get_refresh_token",refreshToken)
        intent.putExtra("logined",logined)
        setResult(Activity.RESULT_OK,intent)
        finish()
    }
}