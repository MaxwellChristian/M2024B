package in.maxwell.m2024b;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

public class FileStorage extends AppCompatActivity {

    Button btnSavePublic;
    Button btnSavePrivate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_file_storage);

        btnSavePublic = findViewById(R.id.btnSavePublic);
        btnSavePrivate = findViewById(R.id.btnSavePrivate);

        btnSavePublic.setOnClickListener(v -> {
            savePublic();
        });

        btnSavePrivate.setOnClickListener(v -> {
            savePrivate();
        });


    }

    private void savePrivate() {

        // Get the files directory (private to the app)
        File filesDir = FileStorage.this.getFilesDir();

        try {
            // Create a file in the files directory (have to use openFileOutput() )
            FileOutputStream file = openFileOutput("testPrivate.txt", MODE_PRIVATE);

            DataOutputStream out = new DataOutputStream(file);
            out.writeBytes("Hello World!");
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void savePublic() {

        // Get the external storage directory
        // File externalDir = Environment.getExternalStorageDirectory();
        File externalDir = FileStorage.this.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);

        File file = new File(externalDir, "test.txt");
        try {
            DataOutputStream out = new DataOutputStream(Files.newOutputStream(file.toPath()));
            out.writeBytes("Hello World!");
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}