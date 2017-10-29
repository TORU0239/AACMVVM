package my.toru.aacmvvm.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.adapter_main.view.*
import my.toru.aacmvvm.R
import my.toru.aacmvvm.data.model.DummyData

/**
 * Created by toruchoi on 29/10/2017.
 */
class MainAdapter(var list:List<DummyData>): RecyclerView.Adapter<MainViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MainViewHolder
     = MainViewHolder(LayoutInflater.from(parent?.context)?.inflate(R.layout.adapter_main, parent, false)!!)

    override fun onBindViewHolder(holder: MainViewHolder?, position: Int) {
        holder?.bindData(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}

class MainViewHolder(view: View): RecyclerView.ViewHolder(view){
    fun bindData(data:DummyData){
        itemView.txtMainAdapter.text = data.name
    }
}