package com.example.tiketsaya;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.github.florent37.shapeofview.shapes.CircleView;

public class HomeAct extends AppCompatActivity {

    LinearLayout btn_ticket_pisa;
    CircleView btn_to_pofile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btn_ticket_pisa = findViewById(R.id.btn_ticket_pisa);
        btn_ticket_pisa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotopisaticket = new Intent(HomeAct.this, TicketDetailAct.class);
                startActivity(gotopisaticket);
            }
        });

        btn_to_pofile = findViewById(R.id.btn_to_profile);
        btn_to_pofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoprofile = new Intent(HomeAct.this, MyProfileAct.class);
                startActivity(gotoprofile);
            }
        });
    }
}
