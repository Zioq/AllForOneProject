package com.example.AllForOne;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignIn extends AppCompatActivity {

    EditText inputUserName,inputUserId,inputPassword,inputRePassword;
    String UserName,UserId,UserPassword,UserRePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        // Get the EditText Field input
        inputUserName = findViewById(R.id.Input_User_Name);
        inputUserId = findViewById(R.id.Input_User_Id);
        inputPassword = findViewById(R.id.input_password);
        inputRePassword = findViewById(R.id.input_re_password);

        Button signIn = (Button)findViewById(R.id.btnJoin);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Get the data as String Value
                UserName = inputUserName.getText().toString();
                UserId = inputUserId.getText().toString();
                UserPassword = inputPassword.getText().toString();
                UserRePassword = inputRePassword.getText().toString();

                if(UserName.length()>1 && UserId.length()>5 && UserPassword.length()>5) {
                    if (UserPassword.equals(UserRePassword) ) {
                        startActivity(new Intent(SignIn.this, Login.class));

                    } else {
                        Toast.makeText(getApplicationContext(),"your password does not correct. Please Enter Again",Toast.LENGTH_LONG).show();
                    }

                } else {
                    Toast.makeText(getApplicationContext(),"Please check Id Password Again!",Toast.LENGTH_SHORT).show();

                }

            }
        });
    }
}