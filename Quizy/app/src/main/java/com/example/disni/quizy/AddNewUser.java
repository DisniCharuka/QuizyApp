package com.example.disni.quizy;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.disni.quizy.Database.DBHandler;

public class AddNewUser extends AppCompatActivity {
    protected DBHandler mDbHandler;
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Users.db";


    Button btnSaveUser, btnUpdate, btnDelete;
    EditText txtNewUserName;
    EditText txtNewPwd;
    AlertDialog.Builder logingMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_user);

        btnSaveUser = (Button)findViewById(R.id.btnSave);
        btnUpdate = (Button)findViewById(R.id.btnUpdate);
        btnDelete = (Button)findViewById(R.id.btnDelete);
        txtNewUserName = (EditText)findViewById(R.id.txtNewUserName);
        txtNewPwd = (EditText)findViewById(R.id.txtNewPwd);
        logingMessage = new AlertDialog.Builder(this);
        mDbHandler = new DBHandler(this, DATABASE_NAME, null, DATABASE_VERSION);

        btnSaveUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //String t1 = txtNewUserName.getText().toString();
                //String t2 = txtNewPwd.getText().toString();


                if (!(txtNewUserName.getText().toString().equals("") || txtNewPwd.getText().toString().equals(""))) {
                    mDbHandler.addInfo(txtNewUserName.getText().toString(), txtNewPwd.getText().toString());

                   logingMessage.setTitle("Login Success");
                    logingMessage.setMessage("Sucessfully inserted a new user!");
                    logingMessage.show();
                    startActivity(new Intent(getApplicationContext(), LoginScreen.class));

                }
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!(txtNewUserName.getText().toString().equals("") || txtNewPwd.getText().toString().equals(""))) {
                    mDbHandler.updateInfo(txtNewUserName.getText().toString(), txtNewPwd.getText().toString());

                    logingMessage.setTitle("Update Success");
                    logingMessage.setMessage("Sucessfully updated a user!");
                    logingMessage.show();
                    startActivity(new Intent(getApplicationContext(), LoginScreen.class));
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!(txtNewUserName.getText().toString().equals(""))) {
                    mDbHandler.deleteInfo(txtNewUserName.getText().toString());

                    logingMessage.setTitle("Delete Success");
                    logingMessage.setMessage("Sucessfully deleted a user!");
                    logingMessage.show();
                }
            }
        });
    }

}
