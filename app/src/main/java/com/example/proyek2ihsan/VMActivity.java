package com.example.proyek2ihsan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class VMActivity extends AppCompatActivity {
    //deklarasikan TextView untuk menampung visi, misi, dan sasaran
    TextView tVisi, tMisi, tSasaran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vm);

        tVisi = findViewById(R.id.tVisi);

        tMisi = findViewById(R.id.tMisi);

        tSasaran = findViewById(R.id.tSasaran);

        //tampilan isi dari file visi, misi, dan sasaran
        //apabila menggunakan folder asset maka perlu disertai extensinya
        //contoh
        //tVisi.setText(tampilanFile(visi.txt));
        tVisi.setText(tampilFile("visi"));
        tMisi.setText(tampilFile("misi"));
        tSasaran.setText(tampilFile("sasaran"));
    }
    public String tampilFile(String fileName){
        String text = "";
        try {
            InputStream is = getResources().openRawResource().
                    getIndentifier(fileName,"raw",getPackageName()));

            int size = is.available();
            byte[] buffer = new byte[size];

            is.read(buffer);
            is.close();
            text = new String(buffer);
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return text;
    }
}