package com.kotlin.mall.ui.adapter

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.mall.R
import kotlinx.android.synthetic.main.adapter_home_test.view.*

/**
 * @author : ${Zhang}
 * @Date   : 2019/5/17 14:56:03
 * @Des    :
 */
@RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
class HomeTestAdapter(mContext: Context) : BaseRecyclerAdapter<String, HomeTestAdapter.HomeViewHolder>(mContext) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {

        var view = inflater.inflate(R.layout.adapter_home_test, parent, false)

        return HomeViewHolder(view)
    }


    class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }


    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.itemView.mTitleTv.text = dataList[position]

    }
}





