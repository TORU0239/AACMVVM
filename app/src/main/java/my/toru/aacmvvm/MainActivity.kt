package my.toru.aacmvvm

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import my.toru.aacmvvm.data.model.MainLifeCycleObserver
import my.toru.aacmvvm.ui.MainAdapter
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
        //
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.getTestData().observe(this, Observer{
            Log.w("TORU", "observable")
        })

//        viewModel.getDataList().observe(this, Observer {
//            // UI Update
//            t -> t?.let {
//            val mainAdapter = mainRecyclerview.adapter as MainAdapter
//            with(mainAdapter) {
//                    list = t
//                    notifyDataSetChanged()
//                }
//            }
//        })
//        initUI()

        Handler().postDelayed({
            Log.w("TORU","PostDelayed")
            viewModel.loadTestData()
        }, 2000)
    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycle.removeObserver(mainLifecycleObserver)
    }

//    private fun initUI(){
//        with(mainRecyclerview){
//            adapter = MainAdapter(ArrayList())
//            layoutManager = LinearLayoutManager(ctx)
//            setHasFixedSize(true)
//            addItemDecoration(DividerItemDecoration(ctx,DividerItemDecoration.VERTICAL))
//        }
//    }
}