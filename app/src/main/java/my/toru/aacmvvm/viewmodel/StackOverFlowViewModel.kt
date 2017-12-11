package my.toru.aacmvvm.viewmodel

import android.arch.lifecycle.*
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import my.toru.aacmvvm.data.model.StackOverFlowItemModel
import my.toru.aacmvvm.data.remote.RemoteRepository
import my.toru.aacmvvm.data.remote.StackOverFlowService

/**
 * Created by toruchoi on 11/12/2017.
 */
class StackOverFlowViewModel: ViewModel(), LifecycleObserver {
    companion object {
        private val TAG = StackOverFlowViewModel::class.java.simpleName
        private val BASE_URL = "https://api.stackexchange.com/"
    }

    private val disposable:CompositeDisposable = CompositeDisposable()

    val questionModel = MutableLiveData<List<StackOverFlowItemModel>>()

    fun getQuestion(){
        disposable.add(RemoteRepository.initRetrofit(BASE_URL)
                        .create(StackOverFlowService::class.java)
                        .getQuestion()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .map { it.items }
                        .subscribe(
                                { result -> Log.w(TAG, "onNext, " + result.size)
                                    questionModel.postValue(result)},
                                { e -> e.printStackTrace()},
                                { Log.w(TAG, "onComplete")}))
    }

    override fun onCleared() {
        super.onCleared()
        Log.w(TAG, "onCleared")
        if(!disposable.isDisposed){
            disposable.dispose()
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun start(){
        Log.w(TAG, "start by lifecycleEvent onStart")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun pause(){
        Log.w(TAG, "start by lifecycleEvent onPause")
        if(!disposable.isDisposed){
            disposable.dispose()
        }
    }
}