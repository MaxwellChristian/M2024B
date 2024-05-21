package in.maxwell.m2024b;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class WebViewDemo extends AppCompatActivity {

    WebView webView1;
    Button btnShowHTMLData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_web_view_demo);

        webView1 = findViewById(R.id.webView1);
        btnShowHTMLData = findViewById(R.id.btnShowHTMLData);

        btnShowHTMLData.setOnClickListener(v -> {

            String data = "";
            data = "<HTML><BODY><H1>Hello World</H1></BODY></HTML>";

//            webView1.loadData(data, "text/html", "UTF-8");
            webView1.getSettings().setJavaScriptEnabled(false);

            webView1.loadUrl("https://www.saskpolytech.ca");

        });


    }
}