package com.zanelove.BaseAdapterHelper.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.zanelove.BaseAdapterHelper.ViewHolder.CommonViewHolder;

import java.util.List;

/**
 * 通用Adapter
 * Created by Zane on 2014/3/5.
 */
public abstract class CommonAdapter<T> extends BaseAdapter {
    protected LayoutInflater mInflater;
    protected Context mContext;
    protected List<T> mDatas;
    protected final int mItemLayoutId;

    public CommonAdapter(Context context, List<T> mDatas, int mItemLayoutId) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(mContext);
        this.mDatas = mDatas;
        this.mItemLayoutId = mItemLayoutId;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public T getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final CommonViewHolder viewHolder = getViewHolder(position,convertView,parent);

        //以后只需改此方法即可
        convert(viewHolder,getItem(position));

        return viewHolder.getConvertView();
    }

    protected abstract void convert(CommonViewHolder viewHolder, T item);

    private CommonViewHolder getViewHolder(int position, View convertView, ViewGroup parent) {
        return CommonViewHolder.get(mContext,convertView,parent,mItemLayoutId,position);
    }
}