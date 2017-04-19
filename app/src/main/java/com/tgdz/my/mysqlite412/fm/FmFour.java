package com.tgdz.my.mysqlite412.fm;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.tgdz.my.mysqlite412.GlideImageLoader;
import com.tgdz.my.mysqlite412.R;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

public class FmFour extends Fragment implements SwipeRefreshLayout.OnRefreshListener, OnBannerListener {
    Banner banner;
    static final int REFRESH_COMPLETE = 0X1112;
    SwipeRefreshLayout mSwipeLayout;

    private Handler mHandler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case REFRESH_COMPLETE:
                    mSwipeLayout.setRefreshing(false);
                    Toast.makeText(getContext(), "你点击了：" , Toast.LENGTH_SHORT).show();

                    break;
            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_four, container, false);

        mSwipeLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe);
        mSwipeLayout.setOnRefreshListener(this);
        banner = (Banner) view.findViewById(R.id.banner);
        //本地图片数据（资源文件）
        List<Integer> list = new ArrayList<>();
        list.add(R.mipmap.q1);
        list.add(R.mipmap.q2);
        list.add(R.mipmap.q3);
        list.add(R.mipmap.q4);


        banner.setImages(list)
                .setImageLoader(new GlideImageLoader())
                .start();
        return view;
    }

    @Override
    public void onRefresh() {
        Toast.makeText(getContext(), "你点击了：" , Toast.LENGTH_SHORT).show();

        mHandler.sendEmptyMessageDelayed(REFRESH_COMPLETE, 2000);
    }

    @Override
    public void OnBannerClick(int position) {
        Toast.makeText(getContext(), "你点击了：ddddd" + position, Toast.LENGTH_SHORT).show();
    }

    //如果你需要考虑更好的体验，可以这么操作
    @Override
    public void onStart() {
        super.onStart();
        //开始轮播
        banner.startAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
        //结束轮播
        banner.stopAutoPlay();
    }
}
