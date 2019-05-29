package com.kotlin.base.ui.adapter;

import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.kotlin.base.R;
import com.kotlin.base.utils.RxBus;
import com.kotlin.base.utils.RxBusKt;

import java.text.BreakIterator;
import java.util.zip.Inflater;

/**
 * time   :  2018/10/16
 * author :  Z
 * des    :  使用装饰模式  使用修饰模式封装Adapter 时 要在 Content数据 的 onBindViewHolder() 中 dataList[position-1]
 */
public class LoadMoreWrapper extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static String TAG = "Wrapper";

    private final static int HEADER = 500;
    private SparseArray<View> headerArr = new SparseArray();
    private final int TYPE_ITEM = 501;
    private final int TYPE_FOOTER = 502;


    public final int LOADING = 1111;
    public final int LOADING_COMPLETE = 2222;
    public final int LOADING_END = 3333;

    private int loadState = 2222;      // 先给个默认加载状态


    private RecyclerView.Adapter innerAdapter;


    /**
     * 装饰模式 会将被装饰者 通过构造函数的方法引用过来;
     *
     * @param innerAdapter
     */
    public LoadMoreWrapper(RecyclerView.Adapter innerAdapter) {
        this.innerAdapter = innerAdapter;
    }


    @Override
    public int getItemViewType(int position) {
        if (isHeader(position)) {
            return headerArr.keyAt(position);

        } else if (position + 1 == getItemCount()) {

            return TYPE_FOOTER;

        } else
//            return innerAdapter.getItemViewType(position - getHeaderCount());
            return TYPE_ITEM;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (headerArr.get(viewType) != null) {

            View view = headerArr.get(viewType);
            return new HeaderViewHolder(view);

        } else if (viewType == TYPE_FOOTER) {

            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.adapter_item_loading, parent, false);
            return new LoadingHolder(view);

        } else

            return innerAdapter.onCreateViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof LoadingHolder) {
            LoadingHolder loadingHolder = (LoadingHolder) holder;

            Log.e(TAG, "");
            switch (loadState) {
                case LOADING:                   // 加载中

                    Log.e(TAG, "加载中 为啥 不显示 ... ");
                    loadingHolder.mProgressBar.setVisibility(View.VISIBLE);
                    loadingHolder.mLoadingTv.setVisibility(View.VISIBLE);
                    loadingHolder.mEndTv.setVisibility(View.GONE);

                    break;
                case LOADING_COMPLETE:          // 加载完成
                    loadingHolder.mProgressBar.setVisibility(View.INVISIBLE);
                    loadingHolder.mLoadingTv.setVisibility(View.INVISIBLE);
                    loadingHolder.mEndTv.setVisibility(View.GONE);

                    break;
                case LOADING_END:               // 加载到底
                    loadingHolder.mProgressBar.setVisibility(View.GONE);
                    loadingHolder.mLoadingTv.setVisibility(View.GONE);
                    loadingHolder.mEndTv.setVisibility(View.VISIBLE);

                    break;
                default:
                    break;
            }
        } else if (isHeader(position)) {

            return;

        } else {

            innerAdapter.onBindViewHolder(holder, position);
        }
    }


    public void addHeader(View view) {
        headerArr.put((headerArr.size() + HEADER), view);
    }


    @Override
    public int getItemCount() {
        return getContentCount() + 1 + getHeaderCount();
    }


    private int getHeaderCount() {
        return headerArr.size();
    }

    // 正文内容的数量
    private int getContentCount() {
        return innerAdapter.getItemCount();
    }


    private boolean isHeader(int position) {
        if (position < getHeaderCount()) {
            return true;
        } else
            return false;
    }

    /**
     * 解决 Manager 是 GridViewLayoutManager 的情况 ;
     *
     * @param recyclerView
     */
    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            final GridLayoutManager manager = (GridLayoutManager) layoutManager;
            manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    return getItemViewType(position) == TYPE_FOOTER ? manager.getSpanCount() : 1;
                }
            });

        }
    }


    /**
     * 设置状态
     *
     * @param loadState 1： 正在加载  2 ：加载完成   3： 加载到底
     */
    public void setLoadState(int loadState) {
        this.loadState = loadState;
        notifyDataSetChanged();
    }

    /**
     * 头布局 Holder
     */
    class HeaderViewHolder extends RecyclerView.ViewHolder {

        public HeaderViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    class LoadingHolder extends RecyclerView.ViewHolder {

        ProgressBar mProgressBar;
        TextView mLoadingTv;
        TextView mEndTv;

        public LoadingHolder(View itemView) {
            super(itemView);

            mProgressBar = itemView.findViewById(R.id.mProgressBar);
            mLoadingTv = itemView.findViewById(R.id.mLoadingTv);
            mEndTv = itemView.findViewById(R.id.mEndTv);
        }
    }


}
