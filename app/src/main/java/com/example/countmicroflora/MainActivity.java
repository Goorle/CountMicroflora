package com.example.countmicroflora;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView textResult;
    private Button buttonAdd;
    private int count = 0;
    private int preCount = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textResult = findViewById(R.id.textResult);
        buttonAdd = findViewById(R.id.buttonAdd);

        buttonAdd.setOnClickListener(v -> {
            textResult.setText(String.valueOf(countMicroflora()));
        });
    }

    private int countMicroflora(){
        if(count == 0){
            return ++count;
        } else if (preCount == 0) {
            return ++preCount;
        }
        int subCount = count;
        count += preCount;
        preCount = subCount;
        return count;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle savedInstanceState) {
        savedInstanceState.putInt("count", count);
        savedInstanceState.putInt("preCount", preCount);

        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        count = savedInstanceState.getInt("count");
        preCount = savedInstanceState.getInt("preCount");

        textResult.setText(String.valueOf(count));
    }
}