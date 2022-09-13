package com.example.tugaspppd_3;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText inputMenu;
    Button btnMakanan, btnMinuman;
    TextView txtJumlah;
    public static final String MESSAGE_MENU = "MENU_KEY";
    public static final String MESSAGE_KET = "KET_KEY";

    ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
        if (result.getResultCode() == RESULT_OK){
            String replyText = result.getData().getStringExtra(secondActivity.REPLY_EXTRA);
            txtJumlah.setText(replyText);
        }
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputMenu = findViewById(R.id.edtMenu);
        btnMakanan = findViewById(R.id.btnMakanan);
        btnMinuman = findViewById(R.id.btnMinuman);
        txtJumlah = findViewById(R.id.txtJumlah);

        btnMakanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), secondActivity.class);
                String message = inputMenu.getText().toString();
                String ket = "Makanan";
                intent.putExtra(MESSAGE_MENU, message);
                intent.putExtra(MESSAGE_KET,ket);

                launcher.launch(intent);
            }
        });

        btnMinuman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), secondActivity.class);
                String message = inputMenu.getText().toString();
                String ket = "Minuman";
                intent.putExtra(MESSAGE_MENU, message);
                intent.putExtra(MESSAGE_KET,ket);

                launcher.launch(intent);
            }
        });
    }
}