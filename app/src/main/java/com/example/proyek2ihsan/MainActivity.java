package com.example.proyek2ihsan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Animation animasi;
    ImageView logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logo = findViewById(R.id.imgLogo);
        animasi();
        //handler untuk berpindah dari activity saat ini ke activity login
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // perintah intent
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);

                // Jalankan intent
                startActivity(intent);

                // selesai/tutup activity ini
                finish();
            }
            //waktu 3000ms atau 3 detik sebelum berpindah ke loginactivity
        },3000);
    }

    private void animasi(){
        animasi = AnimationUtils.loadAnimation(this,R.anim.splash_animasi);
        logo.startAnimation(animasi);

    }
}