package com.example.sinki.bai26_truyendulieuactivity_quanlyketquatrave;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ManHinh2Activity extends AppCompatActivity {
    TextView txtNhan;
    Button btnTinh;
    Intent intent;
    int a,b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh2);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnTinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyTinh();
            }
        });
    }

    private void xuLyTinh() {
        int min = Math.min(a,b);
        int uscln = 1;
        for(int i = min;i >= 1;i--)
        {
            if(a%i==0 && b%i ==0)
            {
                uscln = i;
                break;
            }
        }
        //Bước 3: Thay đổi thông tin và gán vào lại cho intent
        //xử dụng lại intent cũ k cần tạo lại mới
        intent.putExtra("USCLS",uscln);
        //Bước 4: đánh dấu kết quả trả về(33 là mã kết quả ưng số nhiu cũng đc)
        setResult(33,intent);
        //Bước 5: phải đóng màn hình này lại để màn hình MainActivity trở thành Foreground lifetime
        //vì bên kia chỉ nhận đc kết quả khi ở foreground lifetime
        finish();
    }

    private void addControls() {
        txtNhan = (TextView) findViewById(R.id.txtNhan);
        btnTinh = (Button) findViewById(R.id.btnTinh);
        //Bước 2:  Lấy dữ liệu ra
        intent = getIntent();
        a = intent.getIntExtra("a",-1);
        b = intent.getIntExtra("b",-1);
        txtNhan.setText("a = " + a + "; b = "+b);

    }
}
