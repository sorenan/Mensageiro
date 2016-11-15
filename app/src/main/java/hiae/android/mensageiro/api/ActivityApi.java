package hiae.android.mensageiro.api;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public abstract class ActivityApi extends AppCompatActivity {

    protected void setOnClickActivity(int id, Class<?> cl) {
        Button btnView = (Button) findViewById(id);
        btnView.setOnClickListener(new OnClickActivity(this, cl));
    }

    protected void setOnClickService(int id, Class<?> cl) {
        Button btnView = (Button) findViewById(id);
        btnView.setOnClickListener(new OnClickService(this, cl));
    }

    protected void setOnClick(int id, View.OnClickListener a) {
        Button btnView = getViewById(id);
        btnView.setOnClickListener(a);
    }

    protected <T extends View> T getViewById(int id) {
        return (T) findViewById(id);
    }

    private class OnClickService implements View.OnClickListener {

        private Context c;
        private Class<?> cl;

        OnClickService(Context c, Class<?> cl) {
            super();

            this.c = c;
            this.cl = cl;
        }

        @Override
        public void onClick(View v) {
            Intent i = new Intent(c, cl);

            startService(i);
        }
    }


    private class OnClickActivity implements View.OnClickListener {

        private Context c;
        private Class<?> cl;

        OnClickActivity(Context c, Class<?> cl) {
            super();

            this.c = c;
            this.cl = cl;
        }

        @Override
        public void onClick(View v) {
            Intent i = new Intent(c, cl);

            startActivity(i);
        }
    }

    protected SharedPreferences getSharedPreferences() {
        return getSharedPreferences("hiae.android.mensageiro.preferences", MODE_PRIVATE);
    }

    protected boolean getBooleanOrFalse(String key) {
        return getSharedPreferences().getBoolean(key, false);
    }
}
