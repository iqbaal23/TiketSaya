package com.example.tiketsaya;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class RegisterOneAct extends AppCompatActivity implements View.OnClickListener {
    LinearLayout btn_back;
    Button btn_continue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_one);

        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(this);
        btn_continue = findViewById(R.id.btn_continue);
        btn_continue.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btn_back:
                onBackPressed();
                break;
            case R.id.btn_continue:
                Intent gotoregistertwo = new Intent(RegisterOneAct.this, RegisterTwoAct.class);
                startActivity(gotoregistertwo);
                break;
        }
    }
}
