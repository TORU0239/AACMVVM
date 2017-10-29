package my.toru.aacmvvm.presenter

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import my.toru.aacmvvm.data.model.DummyData
import my.toru.aacmvvm.data.remote.RemoteRepository

/**
 * Created by wonyoung on 2017. 10. 27..
 */
class MainViewModel(val remoteRepository: RemoteRepository): ViewModel() {
    private lateinit var dataList:LiveData<List<DummyData>>
    fun getDataList() = dataList

    fun fetchData(){
        RemoteRepository.initRetrofit("base")
    }

    fun loadData(){
        dataList = MutableLiveData<List<DummyData>>()
    }
}