package com.example.kristinaneel.unitypoint;

/**
 * Created by Zach on 12/5/16.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

public class LogIn extends AppCompatActivity {
    private TextView error;
    private TextView user;
    private TextView pass;
    private Integer userStuff = 0;
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
                try {
                    List<User> userList= new JsonReader(LogIn.this).getPersonList();
                    Log.v("userList", userList.toString());

                user = (TextView) findViewById(R.id.userNameText);



                    Log.v("lookhere", user.getText().toString());

                    if (user.getText().toString().equals("")){
                        userStuff = null;
                    }
                    else {
                        userStuff = Integer.parseInt(user.getText().toString());
//                    }
                        pass = (TextView) findViewById(R.id.passwordText2);
                        passStuff = pass.getText().toString();
                        Boolean isLoggedIn = false;
                        Boolean isPassword = false;

                        for (int i = 0; i < userList.size(); i++) {
                            if (userStuff == (userList.get(i).getUserId())) {
                                isLoggedIn = true;
                                if (passStuff.matches(userList.get(i).getPassword())) {
                                    isPassword = true;
                                    Intent intent = new Intent(LogIn.this, MainActivity.class);
                                    startActivity(intent);
                                }
                            }
                        }
                        if (!isLoggedIn | userStuff == null) {
                            Toast.makeText(LogIn.this, "You did not enter a correct userID", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        if (!isPassword | passStuff == "") {
                            Toast.makeText(LogIn.this, "You did not enter a correct password", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
        create.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

            }
        });
    }
}