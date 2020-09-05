package com.edinsson.tarea3_4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.edinsson.tarea3_4.restApi.EndPointNode;
import com.edinsson.tarea3_4.restApi.adapter.RestApiAdapter;
import com.edinsson.tarea3_4.restApi.adapter.RestApiAdapterNode;
import com.edinsson.tarea3_4.restApi.modelo.Usuario;
import com.edinsson.tarea3_4.view.About;
import com.edinsson.tarea3_4.view.AccountSettingsActivity;
import com.edinsson.tarea3_4.view.ConctactActivity;
import com.edinsson.tarea3_4.view.fiveFavorites;
import com.edinsson.tarea3_4.view.fragment.HomeFragment;
import com.edinsson.tarea3_4.view.fragment.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.iid.FirebaseInstanceId;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.buttons_navigation);

        escucha();

        createNotificationChannel();

        bottomNavigationView.setSelectedItemId(R.id.home);

        showToolBar("", false);
    }

    private void escucha(){

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.home){
                    HomeFragment homeFragment1 = new HomeFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_for_fragments, homeFragment1)
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                            .addToBackStack(null).commit();
                }

                if(item.getItemId() == R.id.profile){
                    ProfileFragment profileFragment = new ProfileFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_for_fragments, profileFragment)
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                            .addToBackStack(null).commit();
                }

                return true;
            }
        });

    }

    @Override
    public void onBackPressed(){
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.buttons_navigation);
        if(bottomNavigationView.getId() == R.id.home){
            super.onBackPressed();
        }else{
            bottomNavigationView.setSelectedItemId(R.id.home);
        }
    }

    public void showToolBar(String tittle, boolean upButton){
        androidx.appcompat.widget.Toolbar toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.appbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
        ImageView imageView = (ImageView) findViewById(R.id.star);
        imageView.setImageResource(R.drawable.five_favorite);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_usuario, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.contact){
            Intent intent = new Intent(this, ConctactActivity.class);
            startActivity(intent);
        }

        if(item.getItemId() ==  R.id.about){
            Intent intent = new Intent(this, About.class);
            startActivity(intent);
        }

        if(item.getItemId() ==  R.id.account_setting){
            Intent intent = new Intent(this, AccountSettingsActivity.class);
            startActivity(intent);
        }

        if(item.getItemId() ==  R.id.recived){
            recibirNotificaciones();
        }

        return super.onOptionsItemSelected(item);
    }

    public void fiveFavorite(View view){
        Intent intent = new Intent(this, fiveFavorites.class);
        startActivity(intent);
    }

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel_name);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("1151901", name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    private void recibirNotificaciones(){
        SharedPreferences notificaciones = this.getSharedPreferences("notificaciones", this.MODE_PRIVATE);
        if(notificaciones.getString("validar", "0") == "0"){
            SharedPreferences.Editor editor = notificaciones.edit();
            editor.putString("validar", "1");
            editor.commit();

            String id_count = this.getSharedPreferences("usuario", this.MODE_PRIVATE).getString("nombre_usuario", "");
            String token_device = FirebaseInstanceId.getInstance().getToken();

            RestApiAdapterNode restApiAdapterNode = new RestApiAdapterNode();
            EndPointNode endPointNode = restApiAdapterNode.establecerConexionRestAPI();
            Call<Usuario> usuarioCall = endPointNode.registrarTokenID(token_device, id_count);


            usuarioCall.enqueue(new Callback<Usuario>() {
                @Override
                public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                    Usuario usuario = response.body();

                    Log.d("FIREBASE_ID", usuario.getId());
                    Log.d("ID_COUNT", usuario.getIdCount());
                    Log.d("DEVICE_TOKEN", usuario.getToken());
                }

                @Override
                public void onFailure(Call<Usuario> call, Throwable t) {
                    Toast.makeText(context, "Algo Falló", Toast.LENGTH_LONG).show();
                }
            });
        }else {
            Toast.makeText(this, "Notificaciones ya activas", Toast.LENGTH_LONG).show();
        }
    }
}