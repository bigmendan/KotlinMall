package com.kotlin.WanAndroid.ui.adapter

import android.content.Context
import android.os.Build
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.WanAndroid.R
import com.kotlin.WanAndroid.data.module.ArticleData
import com.kotlin.base.ext.onClick
import com.kotlin.base.ui.adapter.BaseRecyclerAdapter
import com.kotlin.provider.common.afterLogin
import kotlinx.android.synthetic.main.adapter_home_article.view.*

/**
 *  首页文章列表的 Adapter
 */
@RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
class HomeArticleAdapter(mContext: Context) :
    BaseRecyclerAdapter<ArticleData, HomeArticleAdapter.ViewHolder>(mContext) {

    private lateinit var collectionClickListener: CollectionClickListener

    fun setCollectionClickListener(listener: CollectionClickListener) {
        this.collectionClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = inflater.inflate(R.layout.adapter_home_article, parent, false)

        return ViewHolder(view)

    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)

        var article = dataList[position - 1]


        holder.itemView.mAuthorTv.text = article.author
        holder.itemView.mTimeTv.text = article.niceDate
        holder.itemView.mTitleTv.text = article.title
        holder.itemView.mSChatName.text = article.superChapterName
        holder.itemView.mChatName.text = article.chapterName

        var id = article.id

        holder.itemView.mCollecIv.onClick {

            afterLogin {
                if (collectionClickListener != null) {
                    collectionClickListener.collection(id)
                }

            }
        }
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }


    interface CollectionClickListener {
        fun collection(id: Int)
    }


}