package com.example.AllForOne;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText UserIdInput;
    EditText UserPasswordInput;

    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    Cursor cursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        UserIdInput = (EditText) findViewById(R.id.txt_id);
        UserPasswordInput = (EditText) findViewById(R.id.txt_password);
        Button logIn = (Button)findViewById(R.id.btnLog_in);

        openHelper = new DatabaseHelper(this);
        db=openHelper.getReadableDatabase();

        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String UserId = UserIdInput.getText().toString();
                String UserPassword = UserPasswordInput.getText().toString();
                cursor = db.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_NAME + " WHERE " +DatabaseHelper.COL_3 + "=? AND " + DatabaseHelper.COL_4+ " =? ", new String[] {UserId,UserPassword});

                if(cursor!=null) {
                    if(cursor.getCount() > 0) {
                        cursor.moveToNext();
                        Toast.makeText(getApplicationContext(),"Login Success!",Toast.LENGTH_LONG).show();

                        startActivity(new Intent(Login.this, Navigation.class));
                    } else {
                        Toast.makeText(getApplicationContext(),"Check Your ID and Password!",Toast.LENGTH_LONG).show();
                    }
                }
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