package com.edinsson.tarea3_4.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import com.edinsson.tarea3_4.R;

public class AccountSettingsActivity extends AppCompatActivity {

    private Button button;
    private Spinner usuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_settings);

        rellenarSpinner();
        validarBoton();

        showToolBar("", true);
    }

    public void guardarCuenta(View view){
        SharedPreferences cuenta = this.getSharedPreferences("usuario", this.MODE_PRIVATE);
        SharedPreferences.Editor editor = cuenta.edit();
        editor.putString("nombre_usuario", usuarios.getSelectedItem().toString());
        editor.commit();
        validarBoton();
    }

    public void showToolBar(String tittle, boolean upButton){
        androidx.appcompat.widget.Toolbar toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.appbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

    public void rellenarSpinner(){
        usuarios = (Spinner) findViewById(R.id.usuario_selected);
        ArrayAdapter<CharSequence> usuariosOpciones = ArrayAdapter
                .createFromResource(this, R.array.usuarios, android.R.layout.simple_spinner_item);
        usuarios.setAdapter(usuariosOpciones);
    }

    public void validarBoton(){
        SharedPreferences validar = this.getSharedPreferences("usuario", this.MODE_PRIVATE);
        button = (Button) findViewById(R.id.guardar_cuenta);
        if(validar.getString("nombre_usuario", "") != "")
            button.setClickable(false);
    }
}