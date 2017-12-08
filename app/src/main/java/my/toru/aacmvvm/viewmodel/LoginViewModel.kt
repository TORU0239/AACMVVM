package my.toru.aacmvvm.viewmodel

import android.arch.lifecycle.ViewModel
import android.util.Log
import android.view.View
import my.toru.aacmvvm.data.model.LoginModel

/**
 * Created by toruchoi on 08/12/2017.
 */
class LoginViewModel() : ViewModel() {
    companion object {
        private val TAG = LoginViewModel::class.java.simpleName
    }

    fun onLoginButtonClicked(v:View){
        Log.w(TAG, "onLoginButtonClicked")
    }

    override fun onCleared() {
        super.onCleared()
        Log.w(TAG, "onCleared!!")
    }
}