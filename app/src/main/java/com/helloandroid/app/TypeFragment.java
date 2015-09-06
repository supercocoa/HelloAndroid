package com.helloandroid.app;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by scott on 15/9/5.
 */
public class TypeFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    @Bind(R.id.swip_refresh_layout) SwipeRefreshLayout swipeRefreshLayout;

    @Bind(R.id.typeList) RecyclerView recyclerView;

    int position;
    TypeAdapter typeAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();
        this.position = bundle.getInt("position");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_type, container, false);
        ButterKnife.bind(this, v);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        swipeRefreshLayout.setColorSchemeColors(R.color.primary_dark_material_dark);
        swipeRefreshLayout.setOnRefreshListener(this);

        typeAdapter = new TypeAdapter(getActivity(), Config.TYPE_LIST[position].TYPE_ITEMS);
        recyclerView.setAdapter(typeAdapter);

        return v;
    }

    @Override
    public void onRefresh() {
        swipeRefreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(false);
            }
        }, 3000);
    }
}
