package com.kotlin.base.widgets;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/**
 * time   :  2018/12/21
 * author :  Z
 * des    :  自定义 一个 RecyclerView 的分割线
 */
public class RecyclerItemDecoration extends RecyclerView.ItemDecoration {

    private int itemSpace;
    private int itemNum;

    /**
     * @param itemSpace item间隔
     * @param itemNum   每行item的个数
     */
    public RecyclerItemDecoration(int itemSpace, int itemNum) {
        this.itemSpace = itemSpace;
        this.itemNum = itemNum;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.bottom = itemSpace;
        if (parent.getChildLayoutPosition(view) % itemNum == 0) {  //parent.getChildLayoutPosition(view) 获取view的下标
            outRect.left = 0;
        } else {
            outRect.left = itemSpace;
        }

    }


}
