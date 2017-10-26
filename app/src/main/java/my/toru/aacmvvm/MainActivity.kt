package my.toru.aacmvvm

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import my.toru.aacmvvm.data.model.DummyData
import my.toru.aacmvvm.ui.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel:MainViewModel
    private var count:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(MainActivity@this).get(MainViewModel::class.java)

        button.setOnClickListener {
            count++
            viewModel.data = DummyData("test" + count)
            Log.w("TORU", "data change::" + viewModel.data)
        }
    }
}