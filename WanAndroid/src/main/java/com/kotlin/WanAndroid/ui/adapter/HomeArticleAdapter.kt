package com.kotlin.WanAndroid.ui.adapter

import android.content.Context
import android.os.Build
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.WanAndroid.R
import com.kotlin.WanAndroid.data.module.ArticleData
import com.kotlin.WanAndroid.utils.GlideImageLoader
import com.kotlin.base.ui.adapter.BaseRecyclerAdapter
import com.kotlin.base.utils.GlideUtils
import kotlinx.android.synthetic.main.adapter_home_article.view.*

/**
 *  首页文章列表的 Adapter
 */
@RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
class HomeArticleAdapter(mContext: Context) :
    BaseRecyclerAdapter<ArticleData, HomeArticleAdapter.ViewHolder>(mContext) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = inflater.inflate(R.layout.adapter_home_article, parent, false)

        return ViewHolder(view)

    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)


        var articleData = dataList[position]
        holder.itemView.mTitleTv.text = articleData.title
        holder.itemView.mDecTv.text = articleData.desc
        GlideUtils.loadImage(mContext,articleData.envelopePic,holder.itemView.mRightIv)


    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

}