package com.example.supplymanagementui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    CardView cardView;

    public static boolean loggedIn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Check shared preferences
        if(!loggedIn){
            loggedIn = true;
            Intent intent = new Intent(MainActivity.this, Login.class);
            startActivity(intent);
        }else {
            cardView = findViewById(R.id.addOrder);

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, Login.class);
                    startActivity(intent);

                }
            });
        }

    }
}