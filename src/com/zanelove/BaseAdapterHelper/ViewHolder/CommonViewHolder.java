package com.zanelove.BaseAdapterHelper.ViewHolder;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zanelove.BaseAdapterHelper.Utils.ImageLoader;
import com.zanelove.BaseAdapterHelper.Utils.ImageLoader.Type;

/**
 * 通用ViewHolder
 * Created by Zane on 2014/3/5.
 */
public class CommonViewHolder {
    private final SparseArray<View> mViews;
    private int mPosition;
    private View mConvertView;

    private CommonViewHolder(Context context, ViewGroup parent, int layoutId, int position) {
    	this.mPosition = position;
        this.mViews = new SparseArray<View>();
        mConvertView = LayoutInflater.from(context).inflate(layoutId,parent,false);
        //setIag
        mConvertView.setTag(this);
    }

    /**
     * 获得一个ViewHolder对象
     * @param context
     * @param convertView
     * @param parent
     * @param layoutId
     * @param position
     * @return
     */
    public static CommonViewHolder get(Context context, View convertView, ViewGroup parent, int layoutId, int position) {
        if(convertView == null) {
            return new CommonViewHolder(context,parent,layoutId,position);
        }
        return (CommonViewHolder) convertView.getTag();
    }

    /**
     * 通过控件的Id获取对应的控件，如果没有则加入views容器中
     * @param viewId
     * @param <T>
     * @return
     */
    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if(view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId,view);
        }
        return (T) view;
    }

    /**
     * 为TextView设置字符串
     * @param viewId
     * @param text
     * @return
     */
    public CommonViewHolder setText(int viewId,String text) {
    	TextView view = getView(viewId);
    	view.setText(text);
    	return this;
    }
    
    /**
     * 为ImageView设置图片
     * @param viewId
     * @param drawableId
     * @return
     */
    public CommonViewHolder setImageResourece(int viewId,int drawableId) {
    	ImageView view = getView(viewId);
    	view.setImageResource(drawableId);
    	return this;
    }
    
    /** 
     * 为ImageView设置图片 
     * @param viewId 
     * @param drawableId 
     * @return 
     */  
    public CommonViewHolder setImageBitmap(int viewId, Bitmap bm) {  
        ImageView view = getView(viewId);  
        view.setImageBitmap(bm);  
        return this;  
    }  
  
    /** 
     * 为ImageView设置图片 
     * @param viewId 
     * @param drawableId 
     * @return 
     */  
    public CommonViewHolder setImageByUrl(int viewId, String url) {  
    	ImageLoader.getInstance(3, Type.LIFO).loadImage(url, (ImageView) getView(viewId),true);  
        return this;  
    }
    
    public int getPosition() {  
        return mPosition;  
    }  
    
    public View getConvertView(){
        return mConvertView;
    }
}