package com.appsimples.mutti.interusp_android.Atualizar;

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
import android.widget.ImageView;
import android.widget.TextView;

import com.appsimples.mutti.interusp_android.Manager.Login;
import com.appsimples.mutti.interusp_android.R;
import com.appsimples.mutti.interusp_android.Utils.Constants;
import com.appsimples.mutti.interusp_android.Utils.StatusBarColor;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AtualizarLogin extends AppCompatActivity {

    Activity activity = this;
    Context context = this;

    TextView action_title;
    Button login;


    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getBooleanExtra("sucess", false)) {
                activity.finish();
                Intent intent1 = new Intent(activity, AtualizarMenu.class);
                startActivity(intent1);
            }
            login.setEnabled(true);

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_adm);

        final EditText username = (EditText) findViewById(R.id.edtLogin);
        final EditText senha = (EditText) findViewById(R.id.edtSenha);

       login = (Button) findViewById(R.id.btnEntrar);

        if(login!=null){
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!username.getText().toString().isEmpty() && !senha.getText().toString().isEmpty()) {
                        String username_txt = username.getText().toString();
                        String password = MD5(senha.getText().toString());
                        Login login1 = new Login(context);
                        login1.user(username_txt, password);
                        view.setEnabled(false);
                    }
                }
            });
        }


        //ACTION BAR
        StatusBarColor.setColorStatusBar(activity,"#000033");
        action_title = (TextView) findViewById(R.id.txtActionBar);
        action_title.setText("Login");
        final ImageView back_button = (ImageView) findViewById(R.id.btnVoltar);
        back_button.setVisibility(View.VISIBLE);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.finish();
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

    public static final String MD5(final String s) {
        final String MD5 = "MD5";
        try {
            // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest
                    .getInstance(MD5);
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuilder hexString = new StringBuilder();
            for (byte aMessageDigest : messageDigest) {
                String h = Integer.toHexString(0xFF & aMessageDigest);
                while (h.length() < 2)
                    h = "0" + h;
                hexString.append(h);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }


}
