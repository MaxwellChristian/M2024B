package in.maxwell.m2024b;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class VideoDemo extends AppCompatActivity {

    Button btnPlayVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_video_demo);

        btnPlayVideo = findViewById(R.id.btnPlayVideo);
        btnPlayVideo.setOnClickListener(v -> {

            // let us select the appropriate way to play the video

            // let us try to play an online video (YouTube)'
            String videoURL = "https://youtu.be/paw_ITMrf-E?feature=shared";

            Intent intent = new Intent(Intent.ACTION_VIEW);
//            intent.setData(Uri.parse(videoURL));
//            startActivity(intent);

            String url = "https://www.google.com/maps/place/Saskatchewan+Polytechnic,+Regina+Campus/@50.4077084,-104.5819046,17z/data=!3m1!4b1!4m6!3m5!1s0x531ea0f2ce2cf2fb:0xde9358ab42a882b0!8m2!3d50.4077084!4d-104.5819046!16s%2Fg%2F1jlk05yx3?entry=ttu";
            intent.setData(Uri.parse(url));
            startActivity(intent);

        });


    }
}