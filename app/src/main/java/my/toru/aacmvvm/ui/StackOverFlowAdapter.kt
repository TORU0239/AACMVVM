package my.toru.aacmvvm.ui

import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import my.toru.aacmvvm.R
import my.toru.aacmvvm.data.model.StackOverFlowItemModel
import my.toru.aacmvvm.databinding.AdapterMainBinding

/**
 * Created by toruchoi on 11/12/2017.
 */
class StackOverFlowAdapter(var itemList:ArrayList<StackOverFlowItemModel>):RecyclerView.Adapter<QuestionVH>(){

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): QuestionVH {
        val binding:AdapterMainBinding = DataBindingUtil.inflate(LayoutInflater.from(parent?.context), R.layout.adapter_main, parent, false)
        return QuestionVH(binding)
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: QuestionVH?, position: Int){
        holder?.bindData(itemList[position])
    }
}

class QuestionVH(private val itemViewBinding:AdapterMainBinding):RecyclerView.ViewHolder(itemViewBinding.root){
    fun bindData(questionData: StackOverFlowItemModel){
        itemViewBinding.stackoverflowModel = questionData
        itemViewBinding.executePendingBindings()
        itemViewBinding.root.setOnClickListener {
            it.context?.let {
                it.startActivity(Intent(it, DetailActivity::class.java).putExtra("DATA", questionData))
            }
        }
    }
}