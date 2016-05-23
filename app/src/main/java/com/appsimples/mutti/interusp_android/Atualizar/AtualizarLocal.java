package com.appsimples.mutti.interusp_android.Atualizar;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.appsimples.mutti.interusp_android.Manager.EditLocal;
import com.appsimples.mutti.interusp_android.Model.Locais;
import com.appsimples.mutti.interusp_android.R;
import com.appsimples.mutti.interusp_android.Utils.Constants;
import com.appsimples.mutti.interusp_android.Utils.StatusBarColor;

import java.util.ArrayList;
import java.util.Arrays;

public class AtualizarLocal extends AppCompatActivity {

    Context context = this;
    Activity activity = this;

    String _id;

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            activity.finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atualizar_local);


        boolean novo_lugar = getIntent().getBooleanExtra("novo_lugar", false);

        final ImageView icon = (ImageView) findViewById(R.id.icon_lugar);
        final EditText nome = (EditText) findViewById(R.id.lugar_nome_edt);
        final EditText descricao = (EditText) findViewById(R.id.lugar_descricao_edt);
        final EditText url = (EditText) findViewById(R.id.lugar_foto_edt);
        final EditText latitude = (EditText) findViewById(R.id.lugar_latitude_edt);
        final EditText longitude = (EditText) findViewById(R.id.lugar_longitude_edt);

        Button atualizar = (Button) findViewById(R.id.lugar_atualizar);

        ArrayList list = new ArrayList();
        list.addAll(Arrays.asList(getResources().getStringArray(R.array.tipo_locais1)));
        final Spinner tipo_lugar = (Spinner) findViewById(R.id.lugar_spinner);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, list);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tipo_lugar.setAdapter(adapter3);

        if (!novo_lugar) {
            final Locais local = getIntent().getParcelableExtra("locais");
            _id = local.getId();
            double[] coordenadas = local.getCoordenadas();
            setIcon(local.getTipo(), icon);
            nome.setText(local.getNome());
            descricao.setText(local.getDescricao());
            url.setText(local.getFoto());
            latitude.setText(String.valueOf(coordenadas[1]));
            longitude.setText(String.valueOf(coordenadas[0]));
            tipo_lugar.setSelection(local.getTipo() - 1);
        }

        atualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int tipo = tipo_lugar.getSelectedItemPosition() + 1;

                double[] coordenadas = new double[2];
                if(latitude.getText().length()>0&&longitude.getText().length()>0) {
                    coordenadas[0] = Double.parseDouble(latitude.getText().toString());
                    coordenadas[1] = Double.parseDouble(longitude.getText().toString());
                    Locais local = new Locais(nome.getText().toString(), descricao.getText().toString(), url.getText().toString(), coordenadas, tipo);
                    local.setId(_id);
                    EditLocal editLocal = new EditLocal(context);
                    editLocal.EditLocal(local);
                }
            }
        });

        //ACTION BAR
        StatusBarColor.setColorStatusBar(activity, "#000033");
        TextView action_title = (TextView) findViewById(R.id.txtActionBar);
        if (novo_lugar) {
            action_title.setText("Atualiza Local");
        } else {
            action_title.setText("Adicionar Local");
        }
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
        activity.registerReceiver(receiver, new IntentFilter(Constants.kGetLocaisDone));
    }

    @Override
    public void onStop() {
        super.onStop();
        activity.unregisterReceiver(receiver);
    }

    public void setIcon(int id, ImageView icon) {

        switch (id) {

            case 1:
                icon.setImageResource(R.drawable.info_ginasios);
                break;
            case 2:
                icon.setImageResource(R.drawable.info_tenda);
                break;
            case 3:
                icon.setImageResource(R.drawable.info_baladas);
                break;
            case 4:
                icon.setImageResource(R.drawable.info_onibus);
                break;
            case 5:
                icon.setImageResource(R.drawable.info_alojamento);
                break;
            case 6:
                icon.setImageResource(R.drawable.info_hospital);
                break;
            case 7:
                icon.setImageResource(R.drawable.info_delegacia);
                break;
            case 8:
                icon.setImageResource(R.drawable.info_restaurantes);
                break;
            default:
                icon.setImageResource(R.drawable.tabicon_azul_mapa);
                break;

        }
    }
}
