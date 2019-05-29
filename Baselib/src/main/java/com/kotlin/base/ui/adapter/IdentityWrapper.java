package com.kotlin.base.ui.adapter;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * time   :  2018/10/16
 * author :  Z
 * des    :  使用装饰模式  使用修饰模式封装Adapter 时 要在 Content数据 的 onBindViewHolder() 中 dataList[position-1]
 */
public class IdentityWrapper extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static String TAG = "Wrapper";

    private final static int HEADER = 500;
    private final static int FOOTER = 1000;

    private SparseArray<View> footerArr = new SparseArray();
    private SparseArray<View> headerArr = new SparseArray();


    private RecyclerView.Adapter innerAdapter;

    /**
     * 装饰模式 会将被装饰者 通过构造函数的方法引用过来;
     *
     * @param innerAdapter
     */
    public IdentityWrapper(RecyclerView.Adapter innerAdapter) {
        this.innerAdapter = innerAdapter;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (headerArr.get(viewType) != null) {
            View view = headerArr.get(viewType);
            return new HeaderViewHolder(view);
        } else if (footerArr.get(viewType) != null) {
            View view = footerArr.get(viewType);
            return new FooterViewHolder(view);
        }
        return innerAdapter.onCreateViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (isFooter(position)) return;
        if (isHeader(position)) return;

        innerAdapter.onBindViewHolder(holder, position);
    }


    public void addHeader(View view) {
        headerArr.put((headerArr.size() + HEADER), view);
    }

    public void addFooter(View view) {
        footerArr.put((footerArr.size() + FOOTER), view);
    }

    public void removeFooter() {
        footerArr.remove(footerArr.size() + FOOTER);
    }

    @Override
    public int getItemCount() {
        return getContentCount() + getFooterCount() + getHeaderCount();
    }


    @Override
    public int getItemViewType(int position) {
        if (isHeader(position)) {
            return headerArr.keyAt(position);
        } else if (isFooter(position)) {
            // 这里以Footer 的键 作为 ViewType;
            return footerArr.keyAt(position - getContentCount() - getHeaderCount());
        } else
            return innerAdapter.getItemViewType(position - getHeaderCount());
    }


    private int getHeaderCount() {

        return headerArr.size();
    }

    // 正文内容的数量
    private int getContentCount() {
        return innerAdapter.getItemCount();
    }

    // 脚布局的数量
    private int getFooterCount() {
        return footerArr.size();
    }


    private boolean isHeader(int position) {
        if (position < getHeaderCount()) {
            return true;
        } else
            return false;
    }

    private boolean isFooter(int position) {
        if (position >= getHeaderCount() + getContentCount())
            return true;
        else
            return false;

    }

    class HeaderViewHolder extends RecyclerView.ViewHolder {

        public HeaderViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    class FooterViewHolder extends RecyclerView.ViewHolder {

        public FooterViewHolder(View itemView) {
            super(itemView);
        }
    }
}
