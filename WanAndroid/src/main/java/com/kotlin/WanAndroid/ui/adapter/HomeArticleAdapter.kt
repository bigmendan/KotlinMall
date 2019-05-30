package com.kotlin.WanAndroid.ui.adapter

import android.content.Context
import android.os.Build
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.WanAndroid.R
import com.kotlin.WanAndroid.data.module.Data
import com.kotlin.base.ext.loge
import com.kotlin.base.ext.onClick
import com.kotlin.base.ui.adapter.BaseRecyclerAdapter
import com.kotlin.provider.common.afterLogin
import com.kotlin.provider.common.isLogined
import kotlinx.android.synthetic.main.adapter_home_article.view.*

/**
 *  首页文章列表的 Adapter
 */
@RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
class HomeArticleAdapter(mContext: Context) :
    BaseRecyclerAdapter<Data, HomeArticleAdapter.ViewHolder>(mContext) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = inflater.inflate(R.layout.adapter_home_article, parent, false)

        return ViewHolder(view)

    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)

        var article = dataList[position - 1]


        holder.itemView.mAuthor.text = article.author
        holder.itemView.mTitleTv.text = article.title
        holder.itemView.mSChatName.text = article.superChapterName
        holder.itemView.mChatName.text = article.chapterName

        holder.itemView.mCollecIv.onClick {

            afterLogin {
                loge("点击了收藏按钮")

            }
        }
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }


}