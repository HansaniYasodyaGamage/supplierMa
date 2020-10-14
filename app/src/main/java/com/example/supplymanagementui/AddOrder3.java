package com.example.supplymanagementui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddOrder3 extends AppCompatActivity {


    EditText edtTxtQuantity;
    EditText edtTxtUnitPrice;
    EditText edtTxtTotal;

    Button btnSave;


    String quantity;
    String unitPrice;
    String total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_order3);

        Intent intent= getIntent();
        Bundle b = intent.getExtras();

        edtTxtQuantity = findViewById(R.id.edtTxtQuantity);
        edtTxtUnitPrice = findViewById(R.id.edtTxtUnitPrice);
        edtTxtTotal = findViewById(R.id.edtTxtTotal);

        btnSave = findViewById(R.id.btnSave);




        String address;
        String date;
        String req;
        String material;
        String supplier;

        address = intent.getStringExtra("address");
        date = intent.getStringExtra("date");
        req = intent.getStringExtra("req");
        material = intent.getStringExtra("material");
        supplier = intent.getStringExtra("supplier");


        Log.d("data","address"+address);
        Log.d("data","date"+date);
        Log.d("data","req"+req);
        Log.d("data","material"+material);
        Log.d("data","supplier"+supplier);




        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //validate data start

                    quantity = edtTxtQuantity.getText().toString();
                    unitPrice = edtTxtUnitPrice.getText().toString();
                    total = edtTxtTotal.getText().toString();
                    if(quantity.isEmpty()){
                        edtTxtQuantity.setError("Please provide Quantity");
                        edtTxtQuantity.requestFocus();
                    }else if(unitPrice.isEmpty()){
                        edtTxtUnitPrice.setError("Please provide Unit Price");
                        edtTxtUnitPrice.requestFocus();
                    }else if(total.isEmpty()){
                        edtTxtTotal.setError("Please provide Total");
                        edtTxtTotal.requestFocus();
                    }else{
                        Toast.makeText(AddOrder3.this, "Saved", Toast.LENGTH_SHORT).show();
                    }
                //validate data end
            }
        });





        if(b!=null)
        {
            String j =(String) b.get("supplier");
            Toast.makeText(AddOrder3.this, j + "was selected", Toast.LENGTH_SHORT).show();
        }

    }
}