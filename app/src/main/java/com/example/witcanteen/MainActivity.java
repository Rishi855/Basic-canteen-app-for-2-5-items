package com.example.witcanteen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox cmilk,ccoffee,cpepsi,ctea;
    EditText qmilk,qcoffee,qpepsi,qtea;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cmilk = findViewById(R.id.cmilk);
        ccoffee = findViewById(R.id.ccofffee);
        cpepsi = findViewById(R.id.cpepsi);
        ctea = findViewById(R.id.ctea);

        qmilk = findViewById(R.id.qmilk);
        qcoffee = findViewById(R.id.qcoffee);
        qpepsi = findViewById(R.id.qpepsi);
        qtea = findViewById(R.id.qtea);

        Button b = findViewById(R.id.order);
        TextView t = findViewById(R.id.answer);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int cost = 0;

                    if (cmilk.isChecked()) {
                        int m = Integer.parseInt(qmilk.getText().toString().trim());
                        cost = cost + m * 25;
                    }
                    if (cpepsi.isChecked())
                    {
                        int p = Integer.parseInt(qpepsi.getText().toString().trim());
                        cost = cost + p * 30;
                    }

                    if (ccoffee.isChecked())
                    {
                        int c = Integer.parseInt(qcoffee.getText().toString().trim());
                        cost = cost + c * 20;
                    }

                    if (ctea.isChecked())
                    {
                        int t = Integer.parseInt(qtea.getText().toString().trim());
                        cost = cost + t * 10;
                    }
                    t.setText("Total cost "+cost);
                    Toast.makeText(MainActivity.this, "Total cost is: "+cost, Toast.LENGTH_SHORT).show();
                }
                catch (Exception e)
                {
                    Toast.makeText(MainActivity.this, "Enter valid data", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}