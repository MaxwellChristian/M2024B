package in.maxwell.m2024b;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Switch;
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

    Switch swShowColorCode;
    TextView tvColorCode;

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

        redPart = sbRed.getProgress();
        greenPart = sbGreen.getProgress();
        bluePart = sbBlue.getProgress();

        int mixedColor = Color.rgb(redPart, greenPart, bluePart);
        tvColor.setBackgroundColor(mixedColor);

        tvRedValue.setText(sbRed.getProgress()+"");
        tvGreenValue.setText(sbGreen.getProgress()+"");
        tvBlueValue.setText(sbBlue.getProgress()+"");

        sbRed.setOnSeekBarChangeListener(ColorMixer.this);
        sbGreen.setOnSeekBarChangeListener(ColorMixer.this);
        sbBlue.setOnSeekBarChangeListener(ColorMixer.this);

        tvColorCode = findViewById(R.id.tvColorCode);
        swShowColorCode = findViewById(R.id.swShowColorCode);
        swShowColorCode.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                showCodeHexCode();
                tvColorCode.setVisibility(View.VISIBLE);
            }
            else {
                tvColorCode.setVisibility(View.GONE);
            }
        });

    }

    private void showCodeHexCode() {
        tvColorCode.setText("#"
                + String.format("%02x", redPart)
                + String.format("%02x", greenPart)
                + String.format("%02x", bluePart)
        );
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

        showCodeHexCode();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}














