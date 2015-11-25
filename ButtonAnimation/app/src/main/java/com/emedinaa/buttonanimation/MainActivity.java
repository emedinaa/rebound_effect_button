package com.emedinaa.buttonanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button butMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        butMe= (Button)findViewById(R.id.butMe);

        butMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               showMessage();
            }
        });
    }

    private void showMessage() {
        Toast.makeText(this, "Click Me ",Toast.LENGTH_SHORT).show();
    }
}
