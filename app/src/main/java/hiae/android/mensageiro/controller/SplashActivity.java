package hiae.android.mensageiro.controller;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.widget.Toast;


import hiae.android.mensageiro.R;
import hiae.android.mensageiro.api.ActivityApi;

public class SplashActivity extends ActivityApi {

    private Handler h;
    private Resources r;
    public boolean isFirstStart;
    Context mcontext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash_view);
        h = new Handler();
        r = getResources();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Runnable task;
        Integer timeInMillis;

        {
            boolean checked = getBooleanOrFalse("modo_viagem");
            if (checked) {
                Toast.makeText(this, "Oi", Toast.LENGTH_SHORT).show();
            }
        }

        { // escopo
            {
                {
                    {

                    }
                }
            }
        }

        task = new Runnable() {
            @Override
            public void run() {

                //  carregandoText = (TextView) findViewById(R.id.carregandoText);



                  startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                  overridePendingTransition(R.anim.res_anim_fadein, R.anim.res_anim_fadeout);


            /*
                // Em fragments (provavelmente já possúi um código parecido com este)
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setCustomAnimations(R.anim.res_anim_fadein, R.anim.res_anim_fadeout); //animação aqui
                transaction.commit();
               */
            }
        };
        timeInMillis = r.getInteger(R.integer.tempo_splash);

        h.postDelayed(task, timeInMillis);
    }
}
