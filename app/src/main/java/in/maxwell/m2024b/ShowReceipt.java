package in.maxwell.m2024b;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ShowReceipt extends AppCompatActivity {

    TextView tvPayable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
//        setContentView(R.layout.receipt_paid);
        setContentView(R.layout.test_layout);

//        tvPayable = findViewById(R.id.tvReceiptPayable);
//
//        Bundle bundle = getIntent().getExtras();
//
//        // String receivedPayable = bundle.getString("key_total_payable");
//        String receivedPayable = bundle.getString(getResources().getString(R.string.key_total_payable));
//
//        tvPayable.setText(receivedPayable);


    }
}