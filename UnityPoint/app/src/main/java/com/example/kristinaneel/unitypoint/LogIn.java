package com.example.kristinaneel.unitypoint;

/**
 * Created by Zach on 12/5/16.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LogIn extends AppCompatActivity {
    private TextView error;
    private TextView user;
    private TextView pass;
    private String userStuff;
    private String passStuff;

    private Button sign;
    private Button create;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);


        error = (TextView) findViewById(R.id.errorText);
        error.setAlpha(0.0f);

        sign = (Button) findViewById(R.id.signButton);
        create = (Button) findViewById(R.id.createButton);

        sign.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                user = (TextView) findViewById(R.id.userNameText);
                userStuff = user.getText().toString();
                if(userStuff.matches("")) {
                    Toast.makeText(LogIn.this, "You did not enter a username", Toast.LENGTH_SHORT).show();
                    return;
                }

                pass = (TextView) findViewById(R.id.passwordText2);
                passStuff = pass.getText().toString();
                if(passStuff.matches("")) {
                    Toast.makeText(LogIn.this, "You did not enter a password", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent = new Intent(LogIn.this,MainActivity.class);
                startActivity(intent);
            }
        });


        create.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

            }


        });





    }
}
