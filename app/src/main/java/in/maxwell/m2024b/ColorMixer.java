package in.maxwell.m2024b;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ColorMixer extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    TextView tvRedValue;
    TextView tvGreenValue;
    TextView tvBlueValue;

    SeekBar sbRed;
    SeekBar sbGreen;
    SeekBar sbBlue;

    int redPart;
    int greenPart;
    int bluePart;

    TextView tvColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_color_mixer);

        tvColor = findViewById(R.id.tvColor);

        tvRedValue = findViewById(R.id.tvRedValue);
        tvGreenValue = findViewById(R.id.tvGreenValue);
        tvBlueValue = findViewById(R.id.tvBlueValue);

        sbRed = findViewById(R.id.sbRed);
        sbGreen = findViewById(R.id.sbGreen);
        sbBlue = findViewById(R.id.sbBlue);

        tvRedValue.setText(sbRed.getProgress()+"");
        tvGreenValue.setText(sbGreen.getProgress()+"");
        tvBlueValue.setText(sbBlue.getProgress()+"");

        sbRed.setOnSeekBarChangeListener(ColorMixer.this);
        sbGreen.setOnSeekBarChangeListener(ColorMixer.this);
        sbBlue.setOnSeekBarChangeListener(ColorMixer.this);

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        if (seekBar.getId() == R.id.sbRed) {
            tvRedValue.setText(progress+"");
            redPart = progress;
        }

        if (seekBar.getId() == R.id.sbGreen) {
            tvGreenValue.setText(progress+"");
            greenPart = progress;
        }

        if (seekBar.getId() == R.id.sbBlue) {
            tvBlueValue.setText(progress+"");
            bluePart = progress;
        }

        int mixedColor = Color.rgb(redPart, greenPart, bluePart);
        tvColor.setBackgroundColor(mixedColor);

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}














