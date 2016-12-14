package com.example.kristinaneel.unitypoint;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MessageActivity extends AppCompatActivity {
    private Button sendButton;
    private EditText messageText;
    private TextView messageTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        messageTextView = (TextView) findViewById(R.id.messageTextView);
        messageText = (EditText) findViewById(R.id.messageText);
        sendButton = (Button) findViewById(R.id.sendButton);

        sendButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String input = messageText.getText().toString();
                Intent intent = new Intent(MessageActivity.this, MainActivity.class);
                intent.putExtra("value", input);
                startActivity(intent);
            }
        });
    }
}
