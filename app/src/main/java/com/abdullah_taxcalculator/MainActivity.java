package com.abdullah_taxcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etTaxAmount;
    TextView tvResult;
    Button btnTaxAmount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTaxAmount = findViewById(R.id.etTaxAmnt);
        tvResult = findViewById(R.id.tvResult);
        btnTaxAmount = findViewById(R.id.btnTaxAmnt);

        btnTaxAmount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(etTaxAmount.getText().toString())) {
                    etTaxAmount.setError("Please Enter your Monthly income");
                    return;
                }
                double etTaxamount1;
                etTaxamount1 = Double.parseDouble(etTaxAmount.getText().toString());
                Abdullah_TaxCalc Result = new Abdullah_TaxCalc(etTaxamount1);
                double myTax = Result.finalResult();
                tvResult.setText("Your Tax Amount is:"+Double.toString(myTax));
            }
        });

    }
}
