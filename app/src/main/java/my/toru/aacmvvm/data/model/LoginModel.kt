package my.toru.aacmvvm.data.model

import android.databinding.BaseObservable
import android.databinding.Bindable
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
        notifyPropertyChanged(BR.emailAddress)
    }

    var passWord:String = ""
    @Bindable get
    set(pwd) {
        field = pwd
        notifyPropertyChanged(BR.passWord)
    }

}