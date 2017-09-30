package com.example.disni.quizy;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class LoginScreen extends AppCompatActivity {
    Button btnLogin, btnNewUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        btnLogin = (Button)findViewById(R.id.btnLogin);
        btnNewUser = (Button)findViewById(R.id.btnAddUser);

        btnNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddUser();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Login();
            }
        });

    }

    private void AddUser() {
        Intent intent = new Intent(LoginScreen.this, AddNewUser.class);
        startActivity(intent);
    }

    private void Login() {
    }
}
