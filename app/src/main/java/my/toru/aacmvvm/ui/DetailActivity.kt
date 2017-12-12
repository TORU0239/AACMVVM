package my.toru.aacmvvm.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_detail.*
import my.toru.aacmvvm.R
import my.toru.aacmvvm.data.model.StackOverFlowItemModel

class DetailActivity : AppCompatActivity() {
    companion object {
        private val TAG = DetailActivity::class.java.simpleName
    }

    private lateinit var data:StackOverFlowItemModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(toolbar)

        data = intent.getParcelableExtra("DATA")
        Log.w(TAG, "data:: " + data.body + data.link)
    }
}