package my.toru.aacmvvm

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.util.Log
import my.toru.aacmvvm.data.model.MainLifeCycleObserver
import my.toru.aacmvvm.presenter.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var ctx: Context
    private lateinit var viewModel: MainViewModel
    private lateinit var mainLifecycleObserver: MainLifeCycleObserver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ctx = this
        mainLifecycleObserver = MainLifeCycleObserver()

        // to track lifecycle
        lifecycle.addObserver(mainLifecycleObserver)


        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.getTestData().observe(this, object: Observer<ArrayList<String>>{
            override fun onChanged(t: ArrayList<String>?) {
                Log.w("TORU", "onChanged!!, size:: " + t?.size)
            }
        })

        Handler().postDelayed({
            Log.w("TORU","PostDelayed")
            viewModel.loadTestData()
        }, 2000)
    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycle.removeObserver(mainLifecycleObserver)
    }
}