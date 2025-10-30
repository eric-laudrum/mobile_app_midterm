package com.example.mobile_app_midterm;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {

    private ListView historyListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_history); // set view to history

        // Connect with xml
        historyListView = findViewById(R.id.historyListView);

        ArrayList<Integer> history = MainActivity.numberHistory;

        // Convert to string
        ArrayList<String> historyString = new ArrayList<>(); // hold values

        for (int i = 0; i < history.size(); i++) {
            int number = history.get(i);
            historyString.add(String.valueOf(number));
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                historyString
        );
        historyListView.setAdapter(adapter);


        // Set button to redirect to Main
        Button historyButton = findViewById(R.id.goToMain);
        historyButton.setOnClickListener(v->{
            Intent intent = new Intent(
                    HistoryActivity.this,
                    MainActivity.class);
            startActivity(intent);
        });
    }
}
