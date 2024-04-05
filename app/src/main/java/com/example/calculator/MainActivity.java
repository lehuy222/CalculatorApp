package com.example.calculator;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button minusButton, sumButton, divideButton, multiplyButton;
    EditText input1, input2, output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);
        output = findViewById(R.id.output);

        minusButton = findViewById(R.id.minusButton);
        sumButton = findViewById(R.id.sumButton);
        divideButton = findViewById(R.id.devideButton);
        multiplyButton = findViewById(R.id.multiplyButton);

        sumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double result = sum();
                output.setText(String.format("The result is %.2f", result));
            }
        });
        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double result = minus();
                output.setText(String.format("The result is %.2f", result));
            }
        });
        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double result = multiply();
                output.setText(String.format("The result is %.2f", result));
            }
        });
        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double result = divide();
                output.setText(String.format("The result is %.2f", result));
            }
        });
    }

    private double sum(){
        double value1 = Double.parseDouble(input1.getText().toString());
        double value2 = Double.parseDouble(input2.getText().toString());
        return value1 + value2;
    }

    private double minus(){
        double value1 = Double.parseDouble(input1.getText().toString());
        double value2 = Double.parseDouble(input2.getText().toString());
        return value1 - value2;
    }

    private double multiply(){
        double value1 = Double.parseDouble(input1.getText().toString());
        double value2 = Double.parseDouble(input2.getText().toString());
        return value1 * value2;
    }

    private double divide(){
        double value1 = Double.parseDouble(input1.getText().toString());
        double value2 = Double.parseDouble(input2.getText().toString());
        return value1 / value2;
    }

}