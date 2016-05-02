package com.example.mutti.interusp_android;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mutti.interusp_android.Manager.Login;
import com.example.mutti.interusp_android.Utils.Constants;

public class LoginAdm extends AppCompatActivity {

    Activity activity = this;
    Context context = this;


    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            activity.finish();
            Intent intent1 = new Intent(activity, AtualizarMenu.class);
            startActivity(intent1);

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_adm);

        Activity activity = this;
        final Context context = this;

        final EditText username = (EditText) findViewById(R.id.edtLogin);
        final EditText senha = (EditText) findViewById(R.id.edtSenha);

        Button login = (Button) findViewById(R.id.btnEntrar);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!username.getText().toString().isEmpty() && !senha.getText().toString().isEmpty()) {
                    String username_txt = username.getText().toString();
                    String senha_txt = senha.getText().toString();
                    Login login1 = new Login(context);
                    login1.user(username_txt, senha_txt);
                }
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        activity.registerReceiver(receiver, new IntentFilter(Constants.kLoginDone));
    }

    @Override
    public void onStop() {
        super.onStop();
        activity.unregisterReceiver(receiver);
    }


}
