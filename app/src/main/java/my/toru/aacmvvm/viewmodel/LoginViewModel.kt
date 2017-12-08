package my.toru.aacmvvm.viewmodel

import android.arch.lifecycle.ViewModel
import android.util.Log

/**
 * Created by toruchoi on 08/12/2017.
 */
class LoginViewModel :ViewModel() {
    companion object {
        private val TAG = LoginViewModel::class.java.simpleName
    }

    override fun onCleared() {
        super.onCleared()
        Log.w(TAG, "onCleared!!")
    }
}