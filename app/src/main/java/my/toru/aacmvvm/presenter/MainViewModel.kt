package my.toru.aacmvvm.presenter

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import android.util.Log
import my.toru.aacmvvm.data.model.DummyData
import my.toru.aacmvvm.data.remote.RemoteRepository

/**
 * Created by wonyoung on 2017. 10. 27..
 */
class MainViewModel: ViewModel() {
    private var dataList:LiveData<List<DummyData>>
    private var testData:LiveData<List<String>>

    init {
        Log.w("TORU", " init!!")
        dataList = MutableLiveData<List<DummyData>>()
        testData = MutableLiveData<List<String>>()
    }

    fun loadData(){
        dataList = MutableLiveData<List<DummyData>>()
    }

    fun getDataList() = dataList

    fun loadTestData(){
        testData = RemoteRepository.testDataUpdate()
        Log.w("TORU","Load Success, testData:: " + testData.value?.size)
    }

    fun getTestData() = testData

}