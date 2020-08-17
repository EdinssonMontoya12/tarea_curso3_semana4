package com.edinsson.tarea3_4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.edinsson.tarea3_4.view.About;
import com.edinsson.tarea3_4.view.ConctactActivity;
import com.edinsson.tarea3_4.view.fiveFavorites;
import com.edinsson.tarea3_4.view.fragment.HomeFragment;
import com.edinsson.tarea3_4.view.fragment.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Esto es una prueba

        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.buttons_navigation);

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

        bottomNavigationView.setSelectedItemId(R.id.home);

        showToolBar("", false);
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

        return super.onOptionsItemSelected(item);
    }

    public void fiveFavorite(View view){
        Intent intent = new Intent(this, fiveFavorites.class);
        startActivity(intent);
    }
}