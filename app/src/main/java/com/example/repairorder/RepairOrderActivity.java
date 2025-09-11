package com.example.repairorder;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class RepairOrderActivity extends AppCompatActivity {
    TextView subtotalTV;
    TextView taxTV;
    TextView totalTV;
    EditText orderET;
    EditText technicianET;
    EditText inspectionET;
    EditText paintET;
    EditText partsET;
    EditText laborET;

    Button submitB;
    Spinner orderS;
    OnClickListener buttonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Random gen = new Random();

            double inspectionValue = Double.parseDouble(inspectionET.getText().toString());
            double paintValue = Double.parseDouble(paintET.getText().toString());
            double partsValue = Double.parseDouble(partsET.getText().toString());
            double laborValue = Double.parseDouble(laborET.getText().toString());

            double subTotal = inspectionValue + paintValue + partsValue + laborValue;
            double tax = subTotal * 0.09;
            double total = tax + subTotal;

            subtotalTV.setText("$" + subTotal);
            taxTV.setText("$" + tax);
            totalTV.setText("$" + total);
        }
    };
    AdapterView.OnItemSelectedListener spinnerListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };
//    View.OnClickListener spinnerListener2 = new OnClickListener() {
//        @Override
//        public void onClick(View v) {
//
//        }
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_repair_order);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        subtotalTV = findViewById(R.id.subtotalField);
        taxTV = findViewById(R.id.taxField);
        totalTV = findViewById(R.id.totalField);

        submitB = findViewById(R.id.submitButton);
        submitB.setOnClickListener(buttonListener);

        orderS = findViewById(R.id.orderTypeField);
        String[] options = new String[]{"option 1", "option 2", "option 3"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, options);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        orderS.setAdapter(adapter);
        orderS.setOnItemSelectedListener(spinnerListener);
//        orderS.setOnClickListener(spinnerListener2);

        technicianET = findViewById(R.id.technicianField);
        inspectionET = findViewById(R.id.inspectionField);
        paintET = findViewById(R.id.paintField);
        partsET = findViewById(R.id.partsField);
        laborET = findViewById(R.id.laborField);


    }
}