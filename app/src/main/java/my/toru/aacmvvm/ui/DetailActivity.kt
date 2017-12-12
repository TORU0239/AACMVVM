package my.toru.aacmvvm.ui

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import my.toru.aacmvvm.BR
import my.toru.aacmvvm.R
import my.toru.aacmvvm.data.model.StackOverFlowItemModel
import my.toru.aacmvvm.databinding.ActivityDetailBinding
import my.toru.aacmvvm.viewmodel.DetailDatabindingModel

class DetailActivity : AppCompatActivity() {
    companion object {
        private val TAG = DetailActivity::class.java.simpleName
    }

    private lateinit var data:StackOverFlowItemModel
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@DetailActivity, R.layout.activity_detail)
        data = intent.getParcelableExtra("DATA")
        Log.w(TAG, "data:: " + data.body + data.link)

        val viewModel = DetailDatabindingModel()
        viewModel.itemModel = data

        binding.detailVM = viewModel
        binding.executePendingBindings()
    }
}