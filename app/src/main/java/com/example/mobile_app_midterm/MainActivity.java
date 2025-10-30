package com.example.mobile_app_midterm;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {

    private EditText enterNumber;
    private LinearLayout multiplicationTable;


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

        // Initialize values from xml
        enterNumber = findViewById(R.id.enterNumber);
        multiplicationTable = findViewById(R.id.multiplicationTable);

        // Set enter button to create table
        Button enterButton = findViewById(R.id.enterNumberButton);
        enterButton.setOnClickListener(v->createTable());
        }

    // Create table
    public void createTable(){

        // Clear table of all values / views
        multiplicationTable.removeAllViews();

        // Get the entered number
        String input = enterNumber.getText().toString();

        // Validate input
        if(input.isEmpty()){
            Toast.makeText(this, "Error, please enter a valid number", Toast.LENGTH_SHORT).show();
            return;
        }

        // Process input
        int number = Integer.parseInt(input);
       // Toast.makeText(this, "Number entered: " + number, Toast.LENGTH_SHORT).show();

        for(int i = 0; i <= 10; i++) {
            // Create string equation for table
            String rowText = number + " x " + i + " = " + (number * i);

            // Create new row
            LinearLayout row = new LinearLayout(this);

            TextView textView = new TextView(this);
            textView.setText(rowText);

            // Add delete button
            Button deleteButton = new Button(this);
            deleteButton.setText("x");

            // Delete row if clicked
            deleteButton.setOnClickListener(v-> {
                multiplicationTable.removeView(row);
                Toast.makeText(this, "Deleted " + rowText, Toast.LENGTH_SHORT).show();
            });

            // Adjust layout
            row.setOrientation(LinearLayout.HORIZONTAL);
            row.addView(textView);
            row.addView(deleteButton);

            multiplicationTable.addView(row);
        }
    }
}