package in.maxwell.m2024b;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ShowDateTime extends AppCompatActivity {

    Button btnShowDate;
    Button btnShowTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_show_date_time);

        btnShowDate = findViewById(R.id.btnShowDate);
        btnShowTime = findViewById(R.id.btnShowTime);

        btnShowDate.setOnClickListener(v -> {

            DatePickerDialog datePickerDialog = new DatePickerDialog(this);

            datePickerDialog.setOnDateSetListener((view, year, month, dayOfMonth) -> {
                Log.d("DATE", dayOfMonth + "-" + (month+1) + "-" + year);
            });

            datePickerDialog.show();

        });

        btnShowTime.setOnClickListener(v -> {
            TimePickerDialog timePickerDialog = new TimePickerDialog(
                    this,
                    (view, hourOfDay, minute) -> {
                        Log.d("TIME", hourOfDay + ":" + minute);
                    },
                    11,
                    50,
                    false);
            timePickerDialog.show();
        });
    }
}