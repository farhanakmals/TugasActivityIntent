package com.example.tugaspppd_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class secondActivity extends AppCompatActivity {

    Button btnOK;
    EditText edtJumlah;
    TextView viewMenu, viewKet;
    public static final String REPLY_EXTRA = "REPLY_KEY";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        viewMenu = findViewById(R.id.viewMenu);
        viewKet =  findViewById(R.id.viewKet);
        edtJumlah = findViewById(R.id.edtJumlah);
        btnOK = findViewById(R.id.btnOK);

        final Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.MESSAGE_MENU);
        String ket = intent.getStringExtra(MainActivity.MESSAGE_KET);
        viewMenu.setText(message);
        viewKet.setText(ket);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                String ok = edtJumlah.getText().toString();
                intent.putExtra(REPLY_EXTRA,ok);

                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}