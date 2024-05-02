package in.maxwell.m2024b;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TipCalculator extends AppCompatActivity {

    // create the references to the controls to be used
    EditText etPrice;
    EditText etTax;
    EditText etTip;

    Button btnCalculate;
    TextView tvTotal;

    Button btnReceipt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tip_calculator);

//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

        // bind the controls to the references
        etPrice = findViewById(R.id.etPrice);
        etTax = findViewById(R.id.etTax);
        etTip = findViewById(R.id.etTip);

        btnCalculate = findViewById(R.id.btnCalculate);

        tvTotal = findViewById(R.id.tvTotalPayable);

        // attach a listener and respond to the events
        btnCalculate.setOnClickListener(v -> {

            double price = Double.parseDouble(etPrice.getText().toString());
            double tax = Double.parseDouble(etTax.getText().toString());
            double tip = Double.parseDouble(etTip.getText().toString());

            double total = price + tax + tip;
            tvTotal.setText("" + total);

        });

        btnReceipt = findViewById(R.id.btnShowReceipt);
        btnReceipt.setOnClickListener(v -> {

            Intent receiptIntent = new Intent(TipCalculator.this, ShowReceipt.class) ;

            // receiptIntent.putExtra("key_total_payable", tvTotal.getText().toString());
            receiptIntent.putExtra(
                    getResources().getString(R.string.key_total_payable),
                    tvTotal.getText().toString());

            startActivity(receiptIntent);

            TipCalculator.this.finish();

        });

    }
}













