package com.ks.mygenie;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.sandro.restaurant.Restaurant;

public class ConfirmationActivity extends BaseActivity {

    private Button confirmationButton;
    private EditText typedCodeET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        init();
    }

    private void init() {
        confirmationButton = (Button) findViewById(R.id.confirmationButton);
        typedCodeET = (EditText) findViewById(R.id.typedCodeET);

        confirmationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                do something
                String typedCode = typedCodeET.getText().toString();
                if (validateConfirmationCode(typedCode)) {
                    new Restaurant(ConfirmationActivity.this, "CONFIRMED!!!", Snackbar.LENGTH_LONG)
                            .setBackgroundColor(Color.GRAY)
                            .setTextColor(Color.GREEN)
                            .show();

                    startActivity(new Intent(ConfirmationActivity.this, SuccessfullActivity.class));
                } else {
                    new Restaurant(ConfirmationActivity.this, "NOT VALIDATE!!!", Snackbar.LENGTH_LONG)
                            .setBackgroundColor(Color.BLACK)
                            .setTextColor(Color.RED)
                            .show();
                }
            }
        });
    }
}
