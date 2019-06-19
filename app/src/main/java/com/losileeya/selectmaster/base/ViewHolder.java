package com.losileeya.selectmaster.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolder {
	private SparseArray<View> mViews;
	private int mPostion;
	private View mConvertView;

	public int getmPostion() {
		return mPostion;
	}

	public ViewHolder(Context context, ViewGroup parent, int layoutId,
			int postion) {
		this.mViews = new SparseArray<View>();
		this.mPostion = postion;
		mConvertView = LayoutInflater.from(context).inflate(layoutId, parent,
				false);
		mConvertView.setTag(this);
	}

	public static ViewHolder getHolder(Context context, View convertView,
			ViewGroup parent, int layoutId, int postion) {
		if (convertView == null) {
			return new ViewHolder(context, parent, layoutId, postion);
		} else {
			ViewHolder viewHolder = (ViewHolder) convertView.getTag();
			viewHolder.mPostion = postion;
			return viewHolder;
		}
	}

	public View getmConvertView() {
		return mConvertView;
	}

	/**
	 * 通过viewId寻找view
	 * */
	@SuppressWarnings("unchecked")
	public <T extends View> T getView(int viewId) {
		View view = mViews.get(viewId);
		if (view == null) {
			view = mConvertView.findViewById(viewId);
			mViews.put(viewId, view);
		}
		return (T) view;
	}

	/**
	 * 设置文字
	 * */
	public ViewHolder setText(int viewId, String text) {
		TextView tv = getView(viewId);
		tv.setText(text);
		return this;
	}

	/**
	 * 设置图片
	 * */
	public ViewHolder setImageResource(int viewId, int resId) {
		ImageView img = getView(viewId);
		img.setImageResource(resId);
		return this;
	}

	/**
	 * 设置图片
	 * */
	public ViewHolder setImageBitmap(int viewId, Bitmap bitmap) {
		ImageView img = getView(viewId);
		img.setImageBitmap(bitmap);
		return this;
	}

	/**
	 * 设置图片
	 * */
	public ViewHolder setImageURL(int viewId, String url) {
		ImageView img = getView(viewId);
		// imageLoder.getInstance().loadImage(view,url);
		// img.setImageResource(resId);
	//	BitmapFactory bitmapFactory = new BitmapFactory();
		Bitmap bit=null;
		try {  
			 bit = BitmapFactory.decodeFile(url); 
			 img.setImageBitmap(bit);
		} catch (OutOfMemoryError e) {  
		    // 捕获OutOfMemoryError，避免直接崩溃  
		}  
		// 先判断是否已经回收  
		if(bit != null && !bit.isRecycled()){  
		    // 回收并且置为null  
			bit.recycle();  
			bit = null;  
		}  
		
		return this;
	}
}