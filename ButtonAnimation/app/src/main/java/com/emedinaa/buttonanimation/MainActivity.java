package com.emedinaa.buttonanimation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private Button butMe;
    private Button butAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        butMe= (Button)findViewById(R.id.butMe);
        butAnimation= (Button)findViewById(R.id.butAnimation);

        butMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               showMessage("Click Me");
                //gotoSecondActivity();
            }
        });

        butAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //showMessage("Animation");
                Log.v(TAG, "animation click ");
                //gotoSecondActivity();
            }
        });
    }

    private void showMessage(String message) {
        Toast.makeText(this, message,Toast.LENGTH_SHORT).show();
    }
    private void gotoSecondActivity()
    {
        startActivity(new Intent(this,SecondActivity.class));
    }

}
