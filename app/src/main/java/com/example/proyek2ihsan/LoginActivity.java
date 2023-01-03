package com.example.proyek2ihsan;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    //deklarasikan EditText untuk menghubungkan dengan eNim dan ePass
    EditText eNim, ePass;

    //deklarasi Button untuk menghubungkan dengan bLogin
    Button bLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //hubungkan variabel eNim dengan EditText eNim
        eNim = findViewById(R.id.eLoginNim);

        //hubungkan variabel ePass dengan EditText ePass
        ePass = findViewById(R.id.eLoginPass);

        //hubungkan variabel bLogin dengan Button bLogin
        bLogin = findViewById(R.id.bLogin);

        //perintah pada saat menekan tombol login
        //jalankan fungsi btnLogin()
        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnLogin();
            }
        });
    }

    public void btnLogin(){
        //fungsi btnlogin untuk menampilkan pesan selamat datang
        //memvalidasi password
        //memberikan peringatan apabila password tidak sesuai

        //Deklarasi string nim untuk menampung data dari variabel eNim
        //Deklarasi string pass untuk menampung data dari variabel ePass
        String nim,pass;

        //ubah tipe data pass eNim menjadi string dan simpan variabel nim
        nim = eNim.getText().toString();
        pass = ePass.getText().toString();

        if (pass.equals("admin")){
            //tampilkan pesan selamat datang
            Toast.makeText(this,"Selamat Datang"+nim,Toast.LENGTH_LONG).show();
            //deklarasikan intent untuk berpindah LoginActivity ke UtamaActivity
            Intent intent = new Intent(LoginActivity.this,UtamaActivity.class);

            //simpan data nim ke nim
            intent.putExtra("nim",nim);

            //jalankan intent
            startActivity(intent);
        } else {
            //tampilan fungsi showdialog
            showDialog();
        }
    }
    public void showDialog(){
        //membuat alertdialog/pesan kesalahan dengan nama pesanSalah
        AlertDialog.Builder pesanSalah = new AlertDialog.Builder(this);
        //atur judul pesanSalah
        pesanSalah.setTitle("Error!!!");
        //Atur pesanSalah
        pesanSalah
                //pesan Kesalahan
                .setMessage("Maaf, Email atau Password Salah")
                //icon
                .setIcon(R.drawable.error)
                //tombol ok
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
        AlertDialog alertDialog = pesanSalah.create();
        //menampilkan pesan kesalahan
        alertDialog.show();
    }
}