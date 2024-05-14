package in.maxwell.m2024b;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class IntentExample extends AppCompatActivity {

    TextView tvContactNumber;

    Button btnDial;
    Button btnCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_intent_example);

        tvContactNumber = findViewById(R.id.tvContactNumber);

        btnDial = findViewById(R.id.btnDial);
        btnCall = findViewById(R.id.btnCall);

        btnDial.setOnClickListener(v -> {
            String number = tvContactNumber.getText().toString();

            // Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + number));

            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + number));

            startActivity(intent);
        });

        btnCall.setOnClickListener(v -> {

            // check for the call phone permission
            String permission = Manifest.permission.CALL_PHONE;
            int grantResult = checkCallingOrSelfPermission(permission);

            if( grantResult == PackageManager.PERMISSION_GRANTED ){
                Intent intent = new Intent(
                        Intent.ACTION_CALL,
                        Uri.parse("tel:" + tvContactNumber.getText().toString()));

                startActivity(intent);
            } else {
                requestPermissions(new String[] { permission }, 12345);
            }


        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if( requestCode == 12345 && grantResults[0] == PackageManager.PERMISSION_GRANTED ){
            Intent intent = new Intent(
                    Intent.ACTION_CALL,
                    Uri.parse("tel:" + tvContactNumber.getText().toString()));
        }
        else {
            Toast.makeText(this, "Permission required to make a call", Toast.LENGTH_SHORT).show();
        }


    }
}
















