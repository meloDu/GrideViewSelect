package com.losileeya.selectmaster.base;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * 通用adpter
 * 
 * @param <T>
 *            泛型数据实体
 */
public abstract class CommonAdapter<T> extends BaseAdapter {
	protected Context mContext;
	protected List<T> mDatas;
	protected LayoutInflater mInflat;
	protected int layoutId;

	public CommonAdapter(Context mContext, List<T> mDatas, int layoutId) {
		this.mContext = mContext;
		this.mDatas = mDatas;
		this.layoutId = layoutId;
		mInflat = LayoutInflater.from(mContext);
	}
    
	@Override
	public int getCount() {

		return mDatas.size() == 0 ? 0 : mDatas.size();
	}

	@Override
	public T getItem(int position) {

		return mDatas == null ? null : mDatas.get(position);
	}

	@Override
	public long getItemId(int position) {

		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder = ViewHolder.getHolder(mContext, convertView,
				parent, layoutId, position);
		viewBundleEventData(viewHolder, getItem(position), position);
		return viewHolder.getmConvertView();
	}

	public abstract void viewBundleEventData(ViewHolder viewHolder, T t,
			int position);
    
   
}
