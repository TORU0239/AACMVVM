package my.toru.aacmvvm.ui

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import my.toru.aacmvvm.R
import my.toru.aacmvvm.data.model.LoginModel
import my.toru.aacmvvm.databinding.MainActivityBinding
import my.toru.aacmvvm.viewmodel.LoginViewModel

/**
 * Created by toruchoi on 07/12/2017.
 */
class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dataBinding : MainActivityBinding = DataBindingUtil.setContentView(MainActivity@this, R.layout.main_activity)
        val loginVM = ViewModelProviders.of(MainActivity@this).get(LoginViewModel::class.java)

        dataBinding.loginModel = LoginModel()
        dataBinding.executePendingBindings()

        dataBinding.btnLogin.setOnClickListener{
            loginVM.onLoginButtonClicked()
        }
    }
}