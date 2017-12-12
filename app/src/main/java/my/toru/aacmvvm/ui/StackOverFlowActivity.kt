package my.toru.aacmvvm.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomSheetDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView.VERTICAL
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

        viewModel = ViewModelProviders.of(StackOverFlowActivity@this).get(StackOverFlowViewModel::class.java)
        viewModel.questionModel.observe(StackOverFlowActivity@this, Observer {
            with(rcv_recycler_view.adapter as StackOverFlowAdapter){
                itemList.addAll(it!!)
                notifyItemInserted(itemList.size)
            }
        })

        with(toolbar){
            title = getString(R.string.title_activity_github)
            setSupportActionBar(this)
        }

        initRecyclerView()
        initBottomSheet()

        fab.setOnClickListener { viewModel.getQuestion()}
    }

    private fun initRecyclerView(){
        with(rcv_recycler_view){
            layoutManager = LinearLayoutManager(this@StackOverFlowActivity)
            adapter = StackOverFlowAdapter(viewModel.questionModel.value!!)
            addItemDecoration(DividerItemDecoration(applicationContext, VERTICAL))
        }
    }

    private fun initBottomSheet(){
        bottomSheet = BottomSheetDialog(StackOverFlowActivity@this)
        val bottomSheetView = layoutInflater.inflate(R.layout.github_bottom_sheet, null)
        bottomSheet.setContentView(bottomSheetView)
    }
}