package in.maxwell.m2024b.notification_emo;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import in.maxwell.m2024b.R;
import in.maxwell.m2024b.ShowDateTime;

public class NotificationDemo extends AppCompatActivity {

    private static final String MY_NOTIFICATION_CHANNEL_1 = "MY_NOTIFICATION_CHANNEL_1";
    Button btnShowNotification;
    private NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_notification_demo);

        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        btnShowNotification = findViewById(R.id.btnShowNotification);

        btnShowNotification.setOnClickListener(v -> {
            showNotification();
        });

    }

    private void showNotification() {

        Intent nextIntent = new Intent(NotificationDemo.this, ShowDateTime.class);
        nextIntent.putExtra("notification_title", "My notification");
        nextIntent.putExtra("notification_text", "Hello World!");

        PendingIntent pendingIntent = PendingIntent.getActivity(NotificationDemo.this, 1, nextIntent, PendingIntent.FLAG_IMMUTABLE);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, MY_NOTIFICATION_CHANNEL_1);

        builder.setContentTitle("My notification");
        builder.setContentText("Hello World!");
        builder.setSmallIcon(R.drawable.ic_launcher_background);
        builder.setAutoCancel(true);
        builder.setContentIntent(pendingIntent);

        NotificationChannel notificationChannel = new NotificationChannel(MY_NOTIFICATION_CHANNEL_1, "My notification", NotificationManager.IMPORTANCE_DEFAULT);
        notificationManager.createNotificationChannel(notificationChannel);

        notificationManager.notify(1, builder.build());


    }
}