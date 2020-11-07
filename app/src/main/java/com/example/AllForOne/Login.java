package com.example.AllForOne;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText userNameInput;
    EditText passwordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        userNameInput = (EditText) findViewById(R.id.txt_id);
        passwordInput = (EditText) findViewById(R.id.txt_password);
        Button logIn = (Button)findViewById(R.id.btnLog_in);
        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = userNameInput.getText().toString().trim();
                String passsword = passwordInput.getText().toString().trim();


                    startActivity(new Intent(Login.this, Navigation.class));

                    //Toast.makeText(getApplicationContext(),"Check your Id and Password",Toast.LENGTH_LONG).show();




            }
        });

        Button register = (Button)findViewById(R.id.btnRegister);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, SignIn.class));
            }
        });

        Button btn = (Button)findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, LifeGuard.class));
            }
        });
    }
}