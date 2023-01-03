package com.example.proyek2ihsan;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import org.w3c.dom.Text;

public class lvAdapter extends ArrayAdapter {
    //untuk menampung gambar dari array_logo_utama
    TypedArray array_logo;

    //untuk menampung string dari array_judul_utama
    String[] array_judul;

    //untuk menampung string dari array_ket_utama
    String[] array_ket;

    //membuat Constructor yang menghubungkan variabel/array dengan parameter
    public lvAdapter(Context context, String[] judul1, String[] ket1, TypedArray logo1){
        super(context, R.layout.listview_utama,R.id.idJudul,judul1);
        this.array_logo = logo1;
        this.array_judul = judul1;
        this.array_ket = ket1;
    }

    @NonNull
    @Override
    //fungsi untuk menampilkan array berdasarkan posisi array
    public View getView (int pos, View convertView, ViewGroup parent){
        //gunakan inflater yang berfungsi sebagai fragment dari activity untuk menampilkan data
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //tambahkan baris berdasarkan ListView_utama
        View row = inflater.inflate(R.layout.listview_utama,parent,false);

        //hubungkan variabel tampil_logo dengan idGambar pada listview_utama
        ImageView tampil_logo = row.findViewById(R.id.idGambar);
        //hubungkan variabel tampil_logo dengan idJudul pada listView_utama
        TextView tampil_judul = row.findViewById(R.id.idJudul);
        //hubungkan variabel tampil_logo dengan idKet pada listView_utama
        TextView tampil_ket = row.findViewById(R.id.idKet);

        //menampilkan gambar dari array_logo atau array_logo_utama
        tampil_logo.setImageResource(array_logo.getResourceId(pos,-1));
        //menampilkan judul dari array_judul
        tampil_judul.setText(array_judul[pos]);
        //menampilkan keterangan dari array_ket
        tampil_ket.setText(array_ket[pos]);
        return row;
    }
}
