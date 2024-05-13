package in.maxwell.m2024b;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

        showSavedColor();

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_color_mixer);

        tvColor = findViewById(R.id.tvColor);

        tvRedValue = findViewById(R.id.tvRedValue);
        tvGreenValue = findViewById(R.id.tvGreenValue);
        tvBlueValue = findViewById(R.id.tvBlueValue);

        sbRed = findViewById(R.id.sbRed);
        sbGreen = findViewById(R.id.sbGreen);
        sbBlue = findViewById(R.id.sbBlue);

//        redPart = sbRed.getProgress();
//        greenPart = sbGreen.getProgress();
//        bluePart = sbBlue.getProgress();

        sbRed.setProgress(redPart);
        sbGreen.setProgress(greenPart);
        sbBlue.setProgress(bluePart);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_color_mixer, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.miSaveColor) {
            Log.i("ColorMixer", "Save color clicked");
            saveColor();
        }

        if (item.getItemId() == R.id.miShowColors) {
            Log.d("ColorMixer", "Show color clicked");
            showSavedColor();
        }

        if (item.getItemId() == R.id.miRemoveColor) {
            Log.w("ColorMixer", "Remove color clicked");

            Toast toast = Toast.makeText(ColorMixer.this, "Color removed", Toast.LENGTH_SHORT);
            toast.show();

        }

        return super.onOptionsItemSelected(item);
    }

    private void showSavedColor() {

        SharedPreferences spColorPreferences =
                getSharedPreferences("color_preferences", MODE_PRIVATE);
        Log.i("ColorMixer", "Preferences loaded (color preferences)");

        redPart = spColorPreferences.getInt("red", 0);
        greenPart = spColorPreferences.getInt("green", 0);
        bluePart = spColorPreferences.getInt("blue", 0);

        Log.i("ColorMixer", "Color fetched (from preferences)"
                + " R: " + redPart
                + " G: " + greenPart
                + " B: " + bluePart );

    }

    private void saveColor() {

        SharedPreferences spColorPreferences =
                getSharedPreferences("color_preferences", MODE_PRIVATE);
        Log.i("ColorMixer", "Preferences loaded (color preferences)");

        spColorPreferences
                .edit()
                    .putInt("red", redPart)
                    .putInt("green", greenPart)
                    .putInt("blue", bluePart)
                .apply();

        Log.i("ColorMixer", "Color saved (in preferences)");

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














