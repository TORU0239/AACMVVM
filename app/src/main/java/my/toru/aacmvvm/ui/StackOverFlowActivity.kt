package my.toru.aacmvvm.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.design.widget.BottomSheetDialog
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.stackoverflow_activity.*
import my.toru.aacmvvm.R
import my.toru.aacmvvm.viewmodel.StackOverFlowViewModel

class StackOverFlowActivity : AppCompatActivity() {
    companion object {
        private val TAG = StackOverFlowActivity::class.java.simpleName
    }

    private lateinit var bottomSheet:BottomSheetDialog
    private lateinit var viewModel:StackOverFlowViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.stackoverflow_activity)
        setSupportActionBar(toolbar)
        initBottomSheet()

        viewModel = ViewModelProviders.of(StackOverFlowActivity@this).get(StackOverFlowViewModel::class.java)
        viewModel.questionModel.observe(StackOverFlowActivity@this, Observer {
            it?.forEach {
                Log.w(TAG, "link: ${it.link}")
            }
        })

        fab.setOnClickListener { viewModel.getQuestion()}
    }

    private fun initBottomSheet(){
        bottomSheet = BottomSheetDialog(GithubActivity@this)
        val bottomSheetView = layoutInflater.inflate(R.layout.github_bottom_sheet, null)
        bottomSheet.setContentView(bottomSheetView)
    }
}