package com.example.proyek2ihsan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class PrestasiActivity extends AppCompatActivity {
    String[] judulPrestasi;
    String[] isiPrestasi;
    TypedArray gambarPrestasi;
    ImageButton bNext,bPrev;
    ImageSwitcher logoSwitcher;
    TextSwitcher judulSwitcher, isiSwitcher;
    int posisi = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestasi);

        bNext = findViewById(R.id.bNext);
        bPrev = findViewById(R.id.bPrev);

        logoSwitcher = findViewById(R.id.imgPrestasi);
        judulSwitcher = findViewById(R.id.tJudulPrestasi);
        isiSwitcher = findViewById(R.id.tIsiPrestasi);

        judulPrestasi = getResources().getStringArray(R.array.array_prestasi_judul);
        isiPrestasi = getResources().getStringArray(R.array.array_prestasi_isi);
        gambarPrestasi = getResources().obtainTypedArray(R.array.array_prestasi_logo);


        judulSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView judulText = new TextView(getApplicationContext());
                return judulText;
            }
        });

        isiSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView isiText = new TextView(getApplicationContext());
                return isiText;
            }
        });
        logoSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView logoImage = new ImageView(getApplicationContext());
                logoImage.setScaleType(ImageView.ScaleType.FIT_CENTER);
                return logoImage;
            }
        });
        bNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(posisi<judulPrestasi.length-1){
                    posisi = posisi+1;
                    isiSwitcher.setText(judulPrestasi[posisi]);
                    logoSwitcher.setImageResource(gambarPrestasi.getResourceId(posisi,-1));
                }
            }
        });

        bPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(posisi>0){
                    posisi = posisi -1;
                    judulSwitcher.setText(judulPrestasi[posisi]);
                    isiSwitcher.setText(isiPrestasi[posisi]);
                    logoSwitcher.setImageResource(gambarPrestasi.getResourceId(posisi,-1));
                }
            }
        });

        judulSwitcher.setText(judulPrestasi[posisi]);
        isiSwitcher.setText(isiPrestasi[posisi]);
        logoSwitcher.setImageResource(gambarPrestasi.getResourceId(posisi,-1));
    }
}