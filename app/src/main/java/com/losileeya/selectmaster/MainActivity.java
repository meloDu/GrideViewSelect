package com.losileeya.selectmaster;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.losileeya.selectmaster.adapter.TagAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.gridview)
    GridView gridview;
    private TagAdapter mAdapter;
    private List<String>mDatas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
        doEvent();
    }
    private void initData() {
        mDatas=new ArrayList<>();
        mDatas.add("东方财富•理财");
        mDatas.add("58 同 城");
        mDatas.add("搜 房 网");
        mDatas.add("携程旅行网");
        mDatas.add("百度地图");
        mDatas.add("12306•旅游");
        mDatas.add("世纪佳缘");
        mDatas.add("赶 集 网");
        mDatas.add("易 车 网");
        mDatas.add("去哪儿网");
        mDatas.add("唯 品 会");
    }
    private void doEvent() {
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Snackbar.make(gridview,mDatas.get(position), Snackbar.LENGTH_SHORT)
                        .show();

            }
        });
        gridview.setChoiceMode(GridView.CHOICE_MODE_SINGLE);// 单选模式
        mAdapter = new TagAdapter(MainActivity.this, mDatas, 0);
        gridview.setAdapter(mAdapter);

        // 默认选中第一个
        gridview.post(new Runnable() {
            @Override
            public void run() {
                gridview.setItemChecked(0, true);
                gridview.setSelected(true);
                gridview.setSelection(0);
            }
        });
    }


}
