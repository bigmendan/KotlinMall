package com.kotlin.WanAndroid.ui.adapter

import android.content.Context
import android.os.Build
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.annotations.Until
import com.kotlin.WanAndroid.R
import com.kotlin.WanAndroid.data.module.Children
import com.kotlin.WanAndroid.data.module.SystemTreeModel
import com.kotlin.base.ext.loge
import com.kotlin.base.ui.adapter.BaseRecyclerAdapter
import kotlinx.android.synthetic.main.adapter_system.view.*
import java.lang.StringBuilder

@RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
class SystemAdapter(mContext: Context) : BaseRecyclerAdapter<SystemTreeModel, SystemAdapter.ViewHolder>(mContext) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = inflater.inflate(R.layout.adapter_system, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)

        var system = dataList[position]
        holder.itemView.mSysTitleTv.text = system.name

        var children = system.children
        var sb = StringBuilder()
        for (idx in 0 until children.size) {
            var childrenSub = children[idx]
            sb.append(childrenSub.name)
                .append("  ")

        }


        holder.itemView.mSysDescTv.text = sb.toString()
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }


}