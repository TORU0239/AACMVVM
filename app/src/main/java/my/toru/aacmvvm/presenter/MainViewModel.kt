package my.toru.aacmvvm.presenter

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import my.toru.aacmvvm.data.model.DummyData
import my.toru.aacmvvm.data.remote.RemoteRepository

/**
 * Created by wonyoung on 2017. 10. 27..
 */
class MainViewModel: ViewModel() {
    private var dataList:LiveData<List<DummyData>>
    private var testData:MutableLiveData<ArrayList<String>>

    init {
        Log.w("TORU", " init!!")
        dataList = MutableLiveData<List<DummyData>>()
        testData = MutableLiveData<ArrayList<String>>()
        testData.value = ArrayList<String>()
    }

    fun loadData(){
        dataList = MutableLiveData<List<DummyData>>()
    }

    fun getDataList() = dataList

    fun loadTestData(){
        val dataList = ArrayList<String>()
        dataList.add("1")
        dataList.add("2")
        dataList.add("3")
        dataList.add("4")
        dataList.add("5")
        testData.value = dataList

        Log.w("TORU","Load Success, testData:: " + testData.value?.size)

        RemoteRepository.testDataUpdate2(testData)

        Log.w("TORU","Load Success2 , testData:: " + testData.value?.size)
    }

    fun getTestData() = testData

}