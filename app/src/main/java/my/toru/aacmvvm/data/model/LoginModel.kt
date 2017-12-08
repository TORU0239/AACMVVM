package my.toru.aacmvvm.data.model

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import my.toru.aacmvvm.BR

/**
 * Created by toruchoi on 08/12/2017.
 */
class LoginModel : BaseObservable() {
    companion object {
        private val TAG = LoginModel::class.java.simpleName
    }
    // LoginModel has two entities

    var emailAddress:String = ""
    @Bindable get
    set(value){
        field = value
        Log.w(TAG, "email::$field")
        notifyPropertyChanged(BR.emailAddress)
    }

    var passWord:String = ""
    @Bindable get
    set(pwd) {
        field = pwd
        Log.w(TAG, "password::$field")
        notifyPropertyChanged(BR.passWord)
    }

    @Bindable
    fun getEmailTextWatcher():TextWatcher{
        return object:TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                emailAddress = s.toString()
                notifyChange()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        }
    }

    @Bindable
    fun getPasswordTextWatcher():TextWatcher{
        return object:TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                passWord = s.toString()
                notifyChange()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        }
    }
}