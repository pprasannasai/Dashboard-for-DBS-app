package com.example.puvvadaprasannasai.dashboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class Log1 extends AppCompatActivity {

   /* TableLayout x;

    TableRow rowa;
    TableRow rowb;*/
    Button but1;
    Button but2;
    public void call()
    {
        but1=(Button) findViewById(R.id.button1);
        but2=(Button) findViewById(R.id.button2);

        but1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {



                // Start NewActivity.class
                Intent intent1 = new Intent(Log1.this,
                        Profile2.class);

                startActivity(intent1);
            }

        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log1);

       call();
    }
}
