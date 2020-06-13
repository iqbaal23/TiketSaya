package com.example.tiketsaya;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class TicketCheckoutAct extends AppCompatActivity {

    Button btn_buy_ticket, btnminus, btnplus;
    TextView textjumlahTiket, texttotalharga, textmybalance;
    Integer valueJumlahTiket = 1;
    Integer myBalance = 200;
    Integer valuetotalHarga = 0;
    Integer valuehargaTiket = 75;
    ImageView notice_uang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_checkout);

        btnminus = findViewById(R.id.btnminus);
        btnplus = findViewById(R.id.btnplus);
        btn_buy_ticket = findViewById(R.id.btn_buy_ticket);
        textjumlahTiket = findViewById(R.id.jumlahtiket);
        texttotalharga = findViewById(R.id.texttotalharga);
        textmybalance = findViewById(R.id.textmybalance);
        notice_uang = findViewById(R.id.notice_uang);

        textjumlahTiket.setText(valueJumlahTiket.toString());
        texttotalharga.setText("US$ "+valuetotalHarga.toString());
        textmybalance.setText("US$ "+myBalance.toString());

        valuetotalHarga = valuehargaTiket * valueJumlahTiket;
        texttotalharga.setText("US$ "+valuetotalHarga);

        btnminus.animate().alpha(0).setDuration(0).start();
        btnminus.setEnabled(false);
        notice_uang.setVisibility(View.GONE);

        btnminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valueJumlahTiket -= 1;
                textjumlahTiket.setText(valueJumlahTiket.toString());
                if (valueJumlahTiket < 2){
                    btnminus.animate().alpha(0).setDuration(300).start();
                    btnminus.setEnabled(false);
                }
                valuetotalHarga = valuehargaTiket * valueJumlahTiket;
                texttotalharga.setText("US$ "+valuetotalHarga);
                if (valuetotalHarga < myBalance){
                    btn_buy_ticket.animate().translationY(0).alpha(1).setDuration(350).start();
                    btn_buy_ticket.setEnabled(true);
                    textmybalance.setTextColor(Color.parseColor("#203DD1"));
                    notice_uang.setVisibility(View.GONE);
                }
            }
        });

        btnplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valueJumlahTiket += 1;
                textjumlahTiket.setText(valueJumlahTiket.toString());
                if (valueJumlahTiket > 1){
                    btnminus.animate().alpha(1).setDuration(300).start();
                    btnminus.setEnabled(true);
                }
                valuetotalHarga = valuehargaTiket * valueJumlahTiket;
                texttotalharga.setText("US$ "+valuetotalHarga);
                if (valuetotalHarga > myBalance){
                    btn_buy_ticket.animate().translationY(250).alpha(0).setDuration(350).start();
                    btn_buy_ticket.setEnabled(false);
                    textmybalance.setTextColor(Color.parseColor("#d12068"));
                    notice_uang.setVisibility(View.VISIBLE);
                }
            }
        });


        btn_buy_ticket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotosuccessticket = new Intent(TicketCheckoutAct.this, SuccessBuyTicketAct.class);
                startActivity(gotosuccessticket);
            }
        });
    }
}
