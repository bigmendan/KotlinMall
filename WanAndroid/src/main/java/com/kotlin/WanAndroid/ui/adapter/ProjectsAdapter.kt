package com.kotlin.WanAndroid.ui.adapter

import android.content.Context
import android.os.Build
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.WanAndroid.R
import com.kotlin.WanAndroid.data.module.ListData
import com.kotlin.WanAndroid.data.module.ProjectListModel
import com.kotlin.base.ext.loge
import com.kotlin.base.ext.onClick
import com.kotlin.base.ui.adapter.BaseRecyclerAdapter
import com.kotlin.base.utils.GlideUtils
import com.kotlin.provider.common.afterLogin
import kotlinx.android.synthetic.main.adapter_project_list.view.*

@RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
class ProjectsAdapter(mContext: Context) : BaseRecyclerAdapter<ListData, ProjectsAdapter.ViewHolder>(mContext) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = inflater.inflate(R.layout.adapter_project_list, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        var listData = dataList[position]

        GlideUtils.loadUrlImage(mContext, listData.envelopePic, holder.itemView.mProIv)

        holder.itemView.mTitleTv.text = listData.title
        holder.itemView.mDescTv.text = listData.desc
        holder.itemView.mAuthor.text = listData.author
        holder.itemView.mTimeTv.text = listData.niceDate


        // 做个接口 暴露吧
        holder.itemView.mCollectIv.onClick {
            afterLogin {
                loge("执行收藏的操作")
            }
        }

    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }




}