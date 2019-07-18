package com.example.tokomedia;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int quantity = 1;
    int total_quantitiy = 1;
    int total_harga = 5500000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    //perintah untuk menambah nilai
    public void increment(View view) {
        if (quantity == 10) {
            Toast.makeText(this, "pesanan maximal 10", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity + 1;
        total_quantitiy = quantity * total_harga;

        display(quantity);
        displayHarga(total_quantitiy);
    }

    //perintah untuk menampilkan nilai
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.text);
        quantityTextView.setText("" + number);
    }

    //untuk menampilkan harga
    private void displayHarga(int number) {
        TextView quantityTextView = findViewById(R.id.total);
        quantityTextView.setText("Rp." + number);
    }

    //perintah untuk mengurangi nilai
    public void decrement(View view) {
        if (quantity <= 1) {
            Toast.makeText(this, "pesanan minimal 1", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity - 1;
        total_quantitiy = quantity * total_harga;

        display(quantity);
        displayHarga(total_quantitiy);
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Apkah anda yakin ingin keluar?")
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finishAffinity();
                    }
                })
                .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .show();
    }
}
