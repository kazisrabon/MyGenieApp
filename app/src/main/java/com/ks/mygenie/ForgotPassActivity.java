package com.ks.mygenie;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ForgotPassActivity extends FragmentActivity {

    Button btnResetPass;
    Button btnSignIn;
    Button btnSignUp;
    Button btnGuest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pass);

        init();
    }

    private void init() {
        btnResetPass = (Button) findViewById(R.id.reset_pass_btn);

        btnSignIn = (Button) findViewById(R.id.back_to_signin_btn);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoFP  = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(gotoFP);
            }
        });

        btnSignUp = (Button) findViewById(R.id.goto_reg_btn);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent generegistration  = new Intent(getApplicationContext(), GeneRegActivity.class);
                startActivity(generegistration);
            }
        });


        btnGuest = (Button) findViewById(R.id.guest_sign_in_btn);
    }
}
