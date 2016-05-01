package com.example.mutti.interusp_android;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mutti.interusp_android.Manager.Login;

public class LoginAdm extends AppCompatActivity {

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
}
