package com.losileeya.selectmaster.adapter;

import android.content.Context;

import com.losileeya.selectmaster.R;
import com.losileeya.selectmaster.base.CommonAdapter;
import com.losileeya.selectmaster.base.ViewHolder;

import java.util.List;


public class TagAdapter extends CommonAdapter<String> {

	public TagAdapter(Context mContext, List<String> mDatas,
			int layoutId) {
		super(mContext, mDatas, R.layout.gride_item);
		
	}

	@Override
	public void viewBundleEventData(ViewHolder viewHolder, final String t,
									int position) {
               viewHolder.setText(R.id.tv_desc,t);
	}
	
}
