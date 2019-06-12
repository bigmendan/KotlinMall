package com.kotlin.WanAndroid.ui.adapter

import android.content.Context
import android.os.Build
import android.text.Html
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.WanAndroid.R
import com.kotlin.WanAndroid.data.module.SearchResultData
import com.kotlin.WanAndroid.data.module.SearchResultModel
import com.kotlin.base.ext.onClick
import com.kotlin.base.ui.adapter.BaseRecyclerAdapter
import com.kotlin.base.utils.DateUtils
import kotlinx.android.synthetic.main.adapter_home_article.view.*

/**
 *  搜索结果页的 Adapter
 */
@RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
class SearchResultAdapter(mContext: Context) :
    BaseRecyclerAdapter<SearchResultData, SearchResultAdapter.ViewHolder>(mContext) {


    lateinit var mCollectListener: CollectListener
    fun setCollectListener(listener: CollectListener) {
        this.mCollectListener = listener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {


        var view = inflater.inflate(R.layout.adapter_home_article, parent, false)
        return ViewHolder(view)

    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)

        var sm = dataList[position]

        holder.itemView.mAuthorTv.text = sm.author
        holder.itemView.mTimeTv.text = DateUtils.convertTimeToString(sm.publishTime, DateUtils.FORMAT_SHORT)
        holder.itemView.mTitleTv.text = Html.fromHtml(sm.title)

        holder.itemView.mSChatName.text = sm.superChapterName
        holder.itemView.mChatName.text = sm.chapterName


        holder.itemView.mCollecIv.onClick {
            if (mCollectListener != null) {
                mCollectListener.collect(position)

            }
        }
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {}


    interface CollectListener {
        fun collect(position: Int)
    }

}