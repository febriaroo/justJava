package com.example.froositadwi.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Integer ordervalue = 0;
    Integer pricevalueCalc = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        final TextView orderValue = (TextView) findViewById(R.id.qtyValue);
        final TextView priceValue = (TextView) findViewById(R.id.priceValue);

        final Button orderButton = (Button) findViewById(R.id.orderButton);
        final Button plusButton = (Button) findViewById(R.id.plusButton);
        final Button minusButton = (Button) findViewById(R.id.minusButton);
        final CheckBox cherryTopping = (CheckBox) findViewById(R.id.cherryTopping);
        final CheckBox creamTopping = (CheckBox) findViewById(R.id.creamTopping);
        final CheckBox chocoSyrupTopping = (CheckBox) findViewById(R.id.chocoSyrupTopping);
        final TextView orderSummary = (TextView) findViewById(R.id.orderSummary);
        final EditText nameEditText = (EditText) findViewById(R.id.nameEditText);

        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Code here executes on main thread after user presses button


                if(Integer.parseInt(orderValue.getText().toString())>=0)
                {

                    ordervalue++;

                }
                orderValue.setText(ordervalue.toString());
            }
        });
        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Code here executes on main thread after user presses button
                if(Integer.parseInt(orderValue.getText().toString())>0)
                {
                    ordervalue--;
                }

                orderValue.setText(ordervalue.toString());
            }
        });

        orderButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                ordervalue = Integer.parseInt(orderValue.getText().toString());
                pricevalueCalc = ordervalue * 5;
                if (cherryTopping.isChecked()) {
                    pricevalueCalc = pricevalueCalc + (1*ordervalue);
                }
                if (creamTopping.isChecked()) {
                    pricevalueCalc = pricevalueCalc + (2*ordervalue);
                }
                if (chocoSyrupTopping.isChecked()) {
                    pricevalueCalc = pricevalueCalc + (3*ordervalue);
                }
                String toDisplay = NumberFormat.getCurrencyInstance(Locale.getDefault()).format(pricevalueCalc);
                priceValue.setText(toDisplay);

                toDisplay="You submit yout order!";
                Toast.makeText(getApplicationContext(),toDisplay,Toast.LENGTH_SHORT).show();

                String summaryOrderValue = "Name: " + nameEditText.getText().toString() +
                        "\nAdd whipped cream? " + creamTopping.isChecked() +
                        "\nQuantity: "+ ordervalue+
                        "\nTotal: "+ pricevalueCalc+
                        "\nThank you!"
                        ;
                orderSummary.setText(summaryOrderValue);
            }
        });

    }
}
