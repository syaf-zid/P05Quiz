package sg.edu.rp.c346.p05_quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView displayTrip, displayCost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        displayTrip = findViewById(R.id.textViewTrip);
        displayCost = findViewById(R.id.textViewCost);

        Intent intentTrip = getIntent();
        String trip = intentTrip.getStringExtra("trip");
        displayTrip.setText("You have selected " + trip);

        Intent intentCost = getIntent();
        double cost = intentCost.getDoubleExtra("cost", 0.0);
        displayCost.setText("Your air ticket costs $" + cost);
    }
}
