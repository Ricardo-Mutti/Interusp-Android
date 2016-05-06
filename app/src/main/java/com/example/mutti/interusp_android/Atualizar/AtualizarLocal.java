package com.example.mutti.interusp_android.Atualizar;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.mutti.interusp_android.Manager.EditLocal;
import com.example.mutti.interusp_android.Model.Locais;
import com.example.mutti.interusp_android.R;

import java.util.ArrayList;
import java.util.Arrays;

public class AtualizarLocal extends AppCompatActivity {

    Context context = this;
    Activity activity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atualizar_local);

        final EditText nome = (EditText) findViewById(R.id.lugar_nome_edt);
        final EditText descricao = (EditText) findViewById(R.id.lugar_descricao_edt);
        final EditText url = (EditText) findViewById(R.id.lugar_foto_edt);
        final EditText latitude = (EditText) findViewById(R.id.lugar_latitude_edt);
        final EditText longitude = (EditText) findViewById(R.id.lugar_longitude_edt);

        Button atualizar = (Button) findViewById(R.id.lugar_atualizar);

        ArrayList list = new ArrayList();
        list.addAll(Arrays.asList(getResources().getStringArray(R.array.tipo_locais)));
        final Spinner tipo_lugar = (Spinner) findViewById(R.id.lugar_spinner);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, list);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tipo_lugar.setAdapter(adapter3);

        atualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                 int tipo = tipo_lugar.getSelectedItemPosition();

                double[] coordenadas = new double[2];
                coordenadas[0]= Double.parseDouble(latitude.getText().toString());
                coordenadas[1]= Double.parseDouble(longitude.getText().toString());
                Locais local = new Locais(nome.getText().toString(),descricao.getText().toString(),url.getText().toString(), coordenadas, tipo);

                EditLocal editLocal = new EditLocal(context);
                editLocal.EditLocal(local);
                activity.finish();
            }
        });


    }
}
