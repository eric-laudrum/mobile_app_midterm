package com.example.mobile_app_midterm;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText enterNumber;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                    Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                    v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                    return insets;
        enterNumber = findViewById(R.id.enterNumber);
        listView = findViewById(R.id.listView);
        }
    }

// Create table
public void createTable(View view){
    // Get the entered number
    String input = enterNumber.getText().toString();

    // Validate input
    if(input.isEmpty()){
        Toast.makeText(this, "Error, please enter a valid number", Toast.LENGTH_SHORT).show();
        return;
    }

    // Process input
    int number = Integer.parseInt(input);
    Toast.makeText(this, "Number entered: " + number, Toast.LENGTH_SHORT).show();

    String[] multiplicationTable = new String[number -1];
    for(int i = 0; i < number; i++) {
        // Create string value for table
        multiplicationTable[i] = "x" + i + " = " + (number * i);

    }

    // Show in table:
    ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            android.R.layout.simple_list_item_1,
            multiplicationTable
    );
    listView.setAdapter(adapter);
}
}