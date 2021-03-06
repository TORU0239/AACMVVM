package my.toru.aacmvvm.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import my.toru.aacmvvm.R
import my.toru.aacmvvm.databinding.MainActivityBinding
import my.toru.aacmvvm.viewmodel.LoginViewModel

/**
 * Created by toruchoi on 07/12/2017.
 */
class MainActivity: AppCompatActivity() {
    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dataBinding : MainActivityBinding = DataBindingUtil.setContentView(MainActivity@this, R.layout.main_activity)
        val loginViewModel = ViewModelProviders.of(MainActivity@this).get(LoginViewModel::class.java)
        dataBinding.loginVM = loginViewModel
        loginViewModel.observedData.observe(MainActivity@this, Observer<String>{
            t -> Log.w(TAG, "message:: $t")
            when(t){
                "check Login Status Success!!" -> {
                    startActivity(Intent(MainActivity@this, StackOverFlowActivity::class.java))
                    finish()
                }
                else -> Toast.makeText(MainActivity@this, "Failed to Sign In!", Toast.LENGTH_SHORT).show()
            }
        })
    }
}