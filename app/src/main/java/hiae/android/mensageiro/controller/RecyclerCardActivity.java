package hiae.android.mensageiro.controller;


import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


import hiae.android.mensageiro.R;
import hiae.android.mensageiro.util.RecyclerView_Adapter;
import hiae.android.mensageiro.util.RecyclerView_DataObject;
import hiae.android.mensageiro.util.RecyclerView_DividerItemDecoration;
import hiae.android.mensageiro.util.RecyclerView_VerticalSpaceItemDecoration;



public class RecyclerCardActivity extends ActionBarActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static String LOG_TAG = "RecyclerViewActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(false);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new RecyclerView_Adapter(getDataSet());
        mRecyclerView.setAdapter(mAdapter);

        RecyclerView.ItemDecoration itemDecorationD = new RecyclerView_DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
        RecyclerView.ItemDecoration itemDecorationV = new RecyclerView_VerticalSpaceItemDecoration(R.dimen.recycler_vertical_item_space);
        mRecyclerView.addItemDecoration(itemDecorationV);
        mRecyclerView.addItemDecoration(itemDecorationD);

        //mRecyclerView2 = (View) findViewById(R.id.recycleractivity_view_item);




        // Code to Add an item with default animation
        //((MyRecyclerViewAdapter) mAdapter).addItem(obj, index);

        // Code to remove an item with default animation
        //((MyRecyclerViewAdapter) mAdapter).deleteItem(index);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ((RecyclerView_Adapter) mAdapter).setOnItemClickListener(new
                                                                         RecyclerView_Adapter.MyClickListener() {
                                                                              @Override
                                                                              public void onItemClick(int position, View v) {
                                                                                  Log.i(LOG_TAG, " Clicked on Item " + position);
                                                                              }
                                                                          });
    }

    private ArrayList<RecyclerView_DataObject> getDataSet() {
        ArrayList results = new ArrayList<RecyclerView_DataObject>();
        for (int index = 0; index < 20; index++) {
            RecyclerView_DataObject obj = new RecyclerView_DataObject("Some Primary Text " + index,
                    "Secondary " + index,R.drawable.wheelchair);
            results.add(index, obj);
        }
        return results;
    }

    public View Requisicao;

    public void AssumirRequisicao (View view) {
        this.Requisicao = view;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("Confirma atribuição da demanda?")
                .setCancelable(false)
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ChamaTela();
                    }
                })
                .setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert = builder.create();

        alert.show();


    }





public void ChamaTela(){

        RelativeLayout relativeLayout = (RelativeLayout) this.Requisicao.getParent().getParent();

        TextView textView = (TextView) relativeLayout.findViewById(R.id.passagem_paciente);
        Toast.makeText(getApplicationContext(), textView.getText(), Toast.LENGTH_SHORT).show();


        Intent i = new Intent(this,RequisicaoActivity.class);

        startActivity(i);



    }



}