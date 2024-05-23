package in.maxwell.m2024b.activity_for_result;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import in.maxwell.m2024b.R;

public class ActivityForResultDemo extends AppCompatActivity {

    Button btnSelectImage;
    ImageView imgSelectedImage;

    ActivityResultLauncher<String> getContentLauncher = registerForActivityResult(
            new ActivityResultContracts.GetContent(), uri -> {

                Log.d("TAG", "onActivityResult (launcher): " + uri);
                imgSelectedImage.setImageURI(uri);

            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_for_result_demo);

        imgSelectedImage = findViewById(R.id.imgSelectedImage);
        btnSelectImage = findViewById(R.id.btnSelectImage);

        btnSelectImage.setOnClickListener(v -> {


            // Using deprecated API
//            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
//            intent.setType("image/*");
//            startActivityForResult(intent, 1);

            // using the current API
            getContentLauncher.launch("image/*");
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.d("TAG", "onActivityResult: " + data.getData());
        imgSelectedImage.setImageURI(data.getData());
    }
}