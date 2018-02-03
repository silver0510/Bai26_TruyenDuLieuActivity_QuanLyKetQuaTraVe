package com.example.sinki.bai26_truyendulieuactivity_quanlyketquatrave;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtKetQua;
    EditText txtA,txtB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
    }

    private void addControls() {
        txtA = (EditText) findViewById(R.id.txtA);
        txtB = (EditText) findViewById(R.id.txtB);
        txtKetQua = (TextView) findViewById(R.id.txtKetQua);
    }

    public void xuLyMoVaTruyenDuLieu(View view) {
        Intent intent = new Intent(MainActivity.this,ManHinh2Activity.class);
        intent.putExtra("a",Integer.parseInt(txtA.getText().toString()));
        intent.putExtra("b",Integer.parseInt(txtB.getText().toString()));
        //Bước 1: gởi dữ liệu sang màn hình 2(99 là mã dữ liệu chuyển thích nhiu cũng đc
        startActivityForResult(intent,99);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 99 && resultCode == 33)
        {
            txtKetQua.setText("USCLN = " + data.getIntExtra("USCLS",0));
        }
    }
}
