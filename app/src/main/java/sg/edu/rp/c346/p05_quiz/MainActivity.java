package sg.edu.rp.c346.p05_quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView numPax;
    Button btnMinus, btnPlus, btnSubmit;
    CheckBox oneWay, roundTrip;
    int paxNum = Integer.parseInt(numPax.getText().toString());
    double cost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        oneWay = findViewById(R.id.checkBoxOne);
        roundTrip = findViewById(R.id.checkBoxRound);
        numPax = findViewById(R.id.textViewPax);
        btnMinus = findViewById(R.id.buttonMinus);
        btnPlus = findViewById(R.id.buttonPlus);
        btnSubmit = findViewById(R.id.buttonSubmit);

        Toast toast = Toast.makeText(MainActivity.this, "Both checkboxes selected", Toast.LENGTH_LONG);
        if(oneWay.isChecked() && roundTrip.isChecked()) {
            toast.show();
        }

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(paxNum > 0) {
                    paxNum--;
                    numPax.setText(paxNum);
                } else {
                    Toast toastPax = Toast.makeText(MainActivity.this, "No. of pax should not be negative", Toast.LENGTH_LONG);
                    toastPax.show();
                }
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paxNum++;
                numPax.setText(paxNum);
            }
        });

        if(oneWay.isChecked()) {
            cost = 100 * paxNum;
        } else if(roundTrip.isChecked()) {
            cost = 100 * paxNum * 2;
        }

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), SecondActivity.class);
                intent.putExtra("cost", cost);
                if(oneWay.isChecked()) {
                    intent.putExtra("trip", "One Way Trip");
                } else {
                    intent.putExtra("trip", "Round Trip");
                }
            }
        });

    }
}
