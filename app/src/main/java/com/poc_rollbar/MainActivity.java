package com.poc_rollbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.rollbar.android.Rollbar;

public class MainActivity extends AppCompatActivity {


    Button button,button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.button);
        button2 = (Button)findViewById(R.id.button2);

        Rollbar.init(this, "521ef2172fb942c5bf87c6b31b37d036", "QA"); // production


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Rollbar.reportMessage("Button 1", "info");
                int i = 0/100;


                Log.d("POC_RollBar", "onClick: i " + i);
                Rollbar.reportException(new Exception("Test exception"));

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Rollbar.reportMessage("Button 2", "debug");




                try {
                    int i = 100/0;

                    Log.d("POC_RollBar", "onClick: i " + i);



                }catch (Exception e){
                    Rollbar.reportException(e, "error", "divide by zero");

                }


            }
        });

    }
}
