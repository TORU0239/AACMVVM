package my.toru.aacmvvm.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import android.util.Log
import android.view.View

/**
 * Created by toruchoi on 08/12/2017.
 */
class LoginViewModel : ViewModel() {
    companion object {
        private val TAG = LoginViewModel::class.java.simpleName
    }

    var emailData = ObservableField<String>()
    var passwordData = ObservableField<String>()

    var observedData = MutableLiveData<String>()

    init {
        emailData.set("")
        passwordData.set("")
    }

    fun onLoginButtonClicked(v:View){
        Log.w(TAG, "onLoginButtonClicked")
        Log.w(TAG, "${emailData.get()} + ${passwordData.get()}")

        if(checkLoginStatus()){
            // let's say we are using login api, and get preload data from api
            observedData.postValue("check Login Status Success!!")
        }
        else{
            observedData.postValue("Failed!")
        }
    }

    private fun checkLoginStatus():Boolean = (!emailData.get().equals("") && !passwordData.get().equals(""))

    override fun onCleared() {
        super.onCleared()
        Log.w(TAG, "onCleared!!")
    }
}
