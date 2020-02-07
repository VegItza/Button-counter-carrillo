package com.example.button_counter_carrillo;

import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView counterValue;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counterValue = (TextView) findViewById(R.id.counterValue);

        Button increase = findViewById(R.id.buttoninc);
        increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                if (counter > 0) {
                    counterValue.setTextColor(getResources().getColor(R.color.test));
                }
                counterValue.setText(Integer.toString(counter));

            }
        });

        Button decrease = findViewById(R.id.buttondec);
        decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter--;
                if (counter < 0) {
                    counterValue.setTextColor(getResources().getColor(R.color.dec));
                }
                counterValue.setText(Integer.toString(counter));
            }
        });
        Button reset = findViewById(R.id.buttonres);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter=0;
                counterValue.setText(Integer.toString(counter));
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);

        String value = counterValue.getText().toString();
        outState.putString("key", value);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedState){
        super.onRestoreInstanceState(savedState);

        String value = savedState.getString( "key");
        counter = Integer.parseInt(value);
        counterValue.setText(value);
    }

}
