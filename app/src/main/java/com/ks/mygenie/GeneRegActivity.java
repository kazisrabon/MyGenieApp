package com.ks.mygenie;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.OnClick;

public class GeneRegActivity extends FragmentActivity implements View.OnClickListener{

    Button btnGeneReg;
    Button btnSignIn;
    Button btnForgotP;
    Button btnGuest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gene_reg);

        init();
    }

    private void init() {
        btnGeneReg = (Button) findViewById(R.id.gene_register_btn);

        btnSignIn = (Button) findViewById(R.id.back_to_signin_btn);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoFP  = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(gotoFP);
            }
        });

        btnForgotP = (Button) findViewById(R.id.forgotP_btn);
        btnForgotP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoFP  = new Intent(getApplicationContext(), ForgotPassActivity.class);
                startActivity(gotoFP);
            }
        });

        btnGuest = (Button) findViewById(R.id.guest_sign_in_btn);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.reset_pass_btn:
                break;

            case R.id.back_to_signin_btn:
                Intent gotoSignIn  = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(gotoSignIn);
                break;

            case R.id.forgotP_btn:
                Intent gotoFP  = new Intent(getApplicationContext(), ForgotPassActivity.class);
                startActivity(gotoFP);
                break;

            case R.id.guest_sign_in_btn:
                break;
        }
    }
}
