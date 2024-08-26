package com.archonia.myfirsttest;

import android.graphics.Color;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            ConstraintLayout cl = findViewById(R.id.main);
            TextView tv = findViewById(R.id.HelloWorld);
            tv.setText("jag heter alrik");
            final int[] clicker = {new Integer(0)};
            Button b = findViewById(R.id.button);
            b.setText("click me!");
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.i("alrik", "click!");
                   tv.setText("dine with flesh");
                    if (clicker[0] == 1){
                        b.setBackgroundColor(Color.rgb(0,0,40));
                        clicker[0]++;
                    } else if (clicker[0] == 3) {
                        clicker[0] = 0;
                        b.setBackgroundColor(Color.rgb(25,95,0));
                    } else if (clicker[0] == 0) {
                        b.setBackgroundColor(Color.rgb(125,0,0));
                        clicker[0]++;
                    }
                }
            }); // Button b3 = new Button(MainActivity.this);
            Button b2 = findViewById(R.id.button2);
            b2.setText("click me for color!");
            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    b2.setBackgroundColor(Color.rgb(150,0,0));


                    if (clicker[0] >= 1){
                        b2.setBackgroundColor(Color.rgb(0,0,40));
                    } else if (clicker[0] >= 3) {
                        clicker[0] = 0;
                        b2.setBackgroundColor(Color.rgb(0,55,45));
                    } else {
                        clicker[0]++;
                    }
                }
            });


            String text = "Hello World";
            Log.println(Log.DEBUG, "alrik", "Hello World");
            Toast t= Toast.makeText(MainActivity.this, "Hello World", Toast.LENGTH_LONG);
            t.show();
            return insets;
        });
    }
}