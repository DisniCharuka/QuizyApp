package com.example.disni.quizy;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.disni.quizy.Database.DBHandler;

public class LoginScreen extends AppCompatActivity {
    Button btnLogin, btnNewUser;
    EditText txtUserName, txtPwd;
    protected DBHandler mDbHandler;
    AlertDialog.Builder errorMessage;
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Users.db";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        btnLogin = (Button)findViewById(R.id.btnLogin);
        btnNewUser = (Button)findViewById(R.id.btnAddUser);
        txtUserName = (EditText)findViewById(R.id.txtUserName);
        txtPwd = (EditText) findViewById(R.id.txtPwd);
        mDbHandler = new DBHandler(this, DATABASE_NAME, null, DATABASE_VERSION);

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
        errorMessage = new AlertDialog.Builder(this);
        boolean isUser;
        isUser =  mDbHandler.readInfo(txtUserName.getText().toString(), txtPwd.getText().toString());

        if(isUser)
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        else {
            errorMessage.setTitle("Error");
            errorMessage.setMessage("User is not existed. Pls register!");
            errorMessage.show();
        }
    }
}
