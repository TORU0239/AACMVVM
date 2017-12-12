package my.toru.aacmvvm.viewmodel

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.util.Log
import my.toru.aacmvvm.BR
import my.toru.aacmvvm.data.model.StackOverFlowItemModel

/**
 * Created by toruchoi on 12/12/2017.
 */

class DetailDatabindingModel : BaseObservable() {

    var itemModel:StackOverFlowItemModel? = null
    @Bindable get
    set(value) {
        field = value
        Log.w("DetailDatabindingModel", "updated!!!")
        notifyPropertyChanged(BR.itemModel)
    }
}