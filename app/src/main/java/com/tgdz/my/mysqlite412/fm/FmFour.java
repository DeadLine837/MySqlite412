package com.tgdz.my.mysqlite412.fm;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.baoyz.widget.PullRefreshLayout;
import com.melnykov.fab.FloatingActionButton;
import com.tgdz.my.mysqlite412.GlideImageLoader;
import com.tgdz.my.mysqlite412.R;
import com.tgdz.my.mysqlite412.TabDb;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

public class FmFour extends Fragment implements SwipeRefreshLayout.OnRefreshListener, OnBannerListener {
    Banner banner;
    View view;
    PullRefreshLayout layout;
    boolean btn = true;
    static final int REFRESH_COMPLETE = 0X1112;
    SwipeRefreshLayout mSwipeLayout;

    private Handler mHandler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case REFRESH_COMPLETE:
                    mSwipeLayout.setRefreshing(false);
                    Toast.makeText(getContext(), "你点击了：", Toast.LENGTH_SHORT).show();

                    break;
            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_four, container, false);

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

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        String[] array = new String[50];
        for (int i = 0; i < array.length; i++) {
            array[i] = "string " + i;
        }
        recyclerView.setAdapter(new OneFm12.ArrayAdapter(getContext(), array));

        layout = (PullRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);
        layout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                layout.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        layout.setRefreshing(false);
                    }
                }, 2000);

            }
        });
        layout.setRefreshStyle(PullRefreshLayout.STYLE_RING);
//        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.multiple_actions);
//        fab.attachToRecyclerView(recyclerView);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if (btn) {
//                    layout.setRefreshing(true);
//                    btn = false;
//                } else {
//                    layout.setRefreshing(false);
//                    btn = true;
//                }
//            }
//        });

        init();
        return view;
    }

    @Override
    public void onRefresh() {
        Toast.makeText(getContext(), "你点击了：", Toast.LENGTH_SHORT).show();

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

    static class ArrayAdapter extends RecyclerView.Adapter<OneFm12.ViewHolder> {

        private String[] mArray;
        private Context mContext;

        public ArrayAdapter(Context context, String[] array) {
            mContext = context;
            mArray = array;
        }

        @Override
        public OneFm12.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_12, viewGroup, false);
            OneFm12.ViewHolder holder = new OneFm12.ViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(OneFm12.ViewHolder viewHolder, int position) {

            viewHolder.mTextView.setText(mArray[position] + "阳光春城");
        }

        @Override
        public int getItemCount() {
            return mArray.length;
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.text_name);
        }
    }


    private void init() {

        final View actionA = view.findViewById(R.id.action_a);
        final View actionB = view.findViewById(R.id.action_b);
        final View actionC = view.findViewById(R.id.action_c);
        actionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "actionAAA", Toast.LENGTH_SHORT).show();
            }
        });
        actionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "actionBBB", Toast.LENGTH_SHORT).show();
            }
        });
        actionC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "actionCCC", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
