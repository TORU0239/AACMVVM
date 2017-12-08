package my.toru.aacmvvm.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import android.view.View

/**
 * Created by toruchoi on 08/12/2017.
 */
class LoginViewModel : ViewModel() {
    companion object {
        private val TAG = LoginViewModel::class.java.simpleName
    }

    private var loginEmail : MutableLiveData<String> = MutableLiveData()
    private var loginPassword : MutableLiveData<String> = MutableLiveData()

    fun onLoginButtonClicked(){
        Log.w(TAG, "onLoginButtonClicked")
    }

    override fun onCleared() {
        super.onCleared()
        Log.w(TAG, "onCleared!!")
    }
}