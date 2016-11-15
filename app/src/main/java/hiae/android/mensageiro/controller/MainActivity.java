package hiae.android.mensageiro.controller;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import hiae.android.mensageiro.R;
import hiae.android.mensageiro.api.ActivityApi;
import hiae.android.mensageiro.api.AndroidFragment;
import hiae.android.mensageiro.api.PagerAdapter;
import hiae.android.mensageiro.api.CustomAndroidGridViewAdapter;
import it.neokree.materialtabs.MaterialTab;
import it.neokree.materialtabs.MaterialTabHost;
import it.neokree.materialtabs.MaterialTabListener;


import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends ActionBarActivity implements MaterialTabListener {

    public boolean isFirstStart;
    Context mcontext;

    //---------------------parte do menu
    Toolbar toolbar;
    CollapsingToolbarLayout collapsingToolbarLayoutAndroid;
    CoordinatorLayout rootLayoutAndroid;
    GridView gridView;
    Context context;
    ArrayList arrayList;

    public static String[] gridViewStrings = {
            "Requisições",
            "Gerenciamento",
            "Alerta",
            "Configuração"
    };
    public static int[] gridViewImages = {
            R.drawable.flag,
            R.drawable.shopping,
            R.drawable.plus,
            R.drawable.star

    };

    public static int[] gridViewActions = {
          //  RecyclerCardActivity.class"",
            R.drawable.shopping,
            R.drawable.plus,
            R.drawable.star

    };


    //---------------------fim - parte do menu

    MaterialTabHost tabHost;
    ViewPager viewPager;
    ViewPagerAdapter androidAdapter;
    Toolbar toolBar;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_view);

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                //  Intro App Initialize SharedPreferences
                SharedPreferences getSharedPreferences = PreferenceManager
                        .getDefaultSharedPreferences(getBaseContext());

                //  Create a new boolean and preference and set it to true
                isFirstStart = getSharedPreferences.getBoolean("firstStart", true);

                //  Check either activity or app is open very first time or not and do action
                if (isFirstStart) {

                    //  Launch application introduction screen
                    Intent i = new Intent(MainActivity.this, hiae.android.mensageiro.controller.InformativoActivity.MyIntro.class);
                    startActivity(i);
                    // SharedPreferences.Editor e = getSharedPreferences.edit();
                    // e.putBoolean("firstStart", false);
                    // e.apply();
                }
            }
        });

        t.start();


        //toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
//        gridView = (GridView) findViewById(R.id.grid);
//        gridView.setAdapter(new CustomAndroidGridViewAdapter(this, gridViewStrings, gridViewImages));


//        ImageView imageView = (ImageView) findViewById(R.id.gridview_image);
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(MainActivity.this,RecyclerCardActivity.class);
//                startActivity(intent);
//            }
//        });


        initInstances();






        //-------------------------- comeca parte do tabmenu

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Tab 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 2"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 3"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount(),this);
        viewPager.setAdapter(adapter);



        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
//
//        //android toolbar
//        toolBar = (android.support.v7.widget.Toolbar) this.findViewById(R.id.toolBar);
//        this.setSupportActionBar(toolBar);
//
//        //tab host
//        tabHost = (MaterialTabHost) this.findViewById(R.id.tabHost);
//        viewPager = (ViewPager) this.findViewById(R.id.viewPager);
//
//        //adapter view
//        androidAdapter = new ViewPagerAdapter(getSupportFragmentManager());
//        viewPager.setAdapter(androidAdapter);
//        viewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
//            @Override
//            public void onPageSelected(int tabposition) {
//                tabHost.setSelectedNavigationItem(tabposition);
//            }
//        });
//
//        //for tab position
//        for (int i = 1; i < androidAdapter.getCount(); i++) {
//            tabHost.addTab(
//                    tabHost.newTab()
//                            .setText(androidAdapter.getPageTitle(i))
//                            .setTabListener(this)
//            );
//        }
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("Confirma sair do sistema?")
                .setCancelable(false)
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.this.finish();
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

    private void initInstances() {
        //rootLayoutAndroid = (CoordinatorLayout) findViewById(R.id.android_coordinator_layout);
        //collapsingToolbarLayoutAndroid = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_android_layout);

        //collapsingToolbarLayoutAndroid.setTitle("Material Grid");

    }

    //-------------------------- comeca parte do tabmenu


    //tab on selected
    @Override
    public void onTabSelected(MaterialTab materialTab) {

        viewPager.setCurrentItem(materialTab.getPosition());
    }

    //tab on reselected
    @Override
    public void onTabReselected(MaterialTab materialTab) {

    }

    //tab on unselected
    @Override
    public void onTabUnselected(MaterialTab materialTab) {

    }

    // view pager adapter
    private class ViewPagerAdapter extends FragmentStatePagerAdapter {

        public ViewPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        public Fragment getItem(int num) {
            return new AndroidFragment();
        }

        @Override
        public int getCount() {
            return 8;
        }

        @Override
        public CharSequence getPageTitle(int tabposition) {
            return "Tab " + tabposition;
        }

    }

}
