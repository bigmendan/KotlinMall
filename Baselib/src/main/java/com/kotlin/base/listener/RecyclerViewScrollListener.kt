package com.kotlin.base.listener

import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.base.ext.loge

/*
   监听 RecyclerView 的滑动状态 ;
 */
abstract class RecyclerViewScrollListener : RecyclerView.OnScrollListener() {

    /*
      用来标记 RecyclerView 是否正在向上滑动 ;
     */
    private var isSlidingUpWard = false;

    override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
        super.onScrollStateChanged(recyclerView, newState)
        var manager: LinearLayoutManager = recyclerView.layoutManager as LinearLayoutManager
        if (newState == RecyclerView.SCROLL_STATE_IDLE) {

            // 最后一个完全出现的  itemPosition
            var lastItemPosition = manager!!.findLastCompletelyVisibleItemPosition()
            var itemCount = manager!!.itemCount


//            loge(" 滑动到最后一个  itemPosition = $lastItemPosition  , itemCount = $itemCount,此时 滑动状态  = $isSlidingUpWard")
            /*
                判断这个条件 ,滑动到最底部 并且还要上滑 ，执行 加载更多

             */
            if (lastItemPosition == itemCount - 1 && isSlidingUpWard) {

                loadMore()
            }


        }
    }


    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        /**
         *   大于 0 表示正在向上滑动， 小于 0 表示停止 或者向下滑动 ；
         */
        isSlidingUpWard = dy > 0

    }


    /*
       加载更多的回调 ；
     */
    abstract fun loadMore()
}