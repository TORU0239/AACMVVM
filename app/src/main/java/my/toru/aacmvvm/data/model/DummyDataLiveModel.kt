package my.toru.aacmvvm.data.model

import android.arch.lifecycle.LiveData
import android.util.Log

/**
 * Created by toruchoi on 29/10/2017.
 */
class DummyDataLiveModel : LiveData<List<DummyData>>() {
    companion object {
        val TAG = DummyDataLiveModel::class.java.simpleName
    }
    override fun onActive() {
        super.onActive()
        Log.w(TAG, "onActive")
    }

    override fun onInactive() {
        super.onInactive()
        Log.w(TAG, "onInActive")
    }
}