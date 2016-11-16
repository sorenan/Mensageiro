package hiae.android.mensageiro.controller;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import hiae.android.mensageiro.R;
import hiae.android.mensageiro.api.PagerAdapter;
import hiae.android.mensageiro.util.RecyclerView_Adapter;
import hiae.android.mensageiro.util.RecyclerView_DataObject;
import hiae.android.mensageiro.util.RecyclerView_DividerItemDecoration;
import hiae.android.mensageiro.util.RecyclerView_VerticalSpaceItemDecoration;


public class Tab1_Fragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static String LOG_TAG = "RecyclerViewActivity";



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_main_tab1_fragment, container, false);

        RecyclerView mRecyclerView= (RecyclerView) view.findViewById(R.id.my_recycler_view1);

        mRecyclerView.setHasFixedSize(false);
        //mLayoutManager = new LinearLayoutManager(this);
        //mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new RecyclerView_Adapter(getDataSet());
        mRecyclerView.setAdapter(mAdapter);

        //RecyclerView.ItemDecoration itemDecorationD = new RecyclerView_DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
        //RecyclerView.ItemDecoration itemDecorationV = new RecyclerView_VerticalSpaceItemDecoration(R.dimen.recycler_vertical_item_space);
        //mRecyclerView.addItemDecoration(itemDecorationV);
        //mRecyclerView.addItemDecoration(itemDecorationD);





        return view;
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        ((RecyclerView_Adapter) mAdapter).setOnItemClickListener(new
//                                                                         RecyclerView_Adapter.MyClickListener() {
//                                                                             @Override
//                                                                             public void onItemClick(int position, View v) {
//                                                                                 Log.i(LOG_TAG, " Clicked on Item " + position);
//                                                                             }
//                                                                         });
//    }

    private ArrayList<RecyclerView_DataObject> getDataSet() {
        ArrayList results = new ArrayList<RecyclerView_DataObject>();
        for (int index = 0; index < 20; index++) {
            RecyclerView_DataObject obj = new RecyclerView_DataObject("Some Primary Text " + index,
                    "Secondary " + index,R.drawable.airplane_mode);
            results.add(index, obj);
        }
        return results;
    }
}