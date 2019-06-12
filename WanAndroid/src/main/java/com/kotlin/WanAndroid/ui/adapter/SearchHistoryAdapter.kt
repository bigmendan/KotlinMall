package com.kotlin.WanAndroid.ui.adapter

import android.content.Context
import android.os.Build
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.WanAndroid.R
import com.kotlin.base.ext.onClick
import com.kotlin.base.ui.adapter.BaseRecyclerAdapter
import kotlinx.android.synthetic.main.adapter_search_history.view.*

/**
 *
 */
@RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
class SearchHistoryAdapter(mContext: Context) : BaseRecyclerAdapter<String, SearchHistoryAdapter.ViewHolder>(mContext) {

    lateinit var mCloseListener: CloseListener
    fun setCloseListener(listener: CloseListener) {
        this.mCloseListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = inflater.inflate(R.layout.adapter_search_history, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var s = dataList[position]
        holder.itemView.mHistoryTv.text = s
        holder.itemView.mCloseIv.onClick {
            if (mCloseListener != null) {
                mCloseListener.close(position)
            }
        }
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {}


    interface CloseListener {
        fun close(position: Int)
    }
}