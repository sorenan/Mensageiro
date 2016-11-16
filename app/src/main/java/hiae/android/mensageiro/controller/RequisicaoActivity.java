package hiae.android.mensageiro.controller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import hiae.android.mensageiro.R;
import hiae.android.mensageiro.api.ActivityApi;

/**
 * Created by Dell on 16/11/2016.
 */

public class RequisicaoActivity extends ActivityApi{
    int contador=1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requisicao_view);

    }

    public void ConcluirEtapa (View v) {
        ImageView etapa = null;

        if (contador == 1) {
            etapa = (ImageView) getViewById(R.id.etapa1_icone);
        } else if (contador == 2) {
            etapa = (ImageView) getViewById(R.id.etapa2_icone);
        } else if (contador == 3) {
            etapa = (ImageView) getViewById(R.id.etapa3_icone);
        } else if (contador == 4) {
            etapa = (ImageView) getViewById(R.id.etapa4_icone);
        } else if (contador == 5) {
            etapa = (ImageView) getViewById(R.id.etapa5_icone);
        }

        if (contador <= 5){
            etapa.setImageAlpha(300);

        }
        contador+=1;

    }

}
