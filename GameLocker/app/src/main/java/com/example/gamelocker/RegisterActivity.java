package com.example.gamelocker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText et;
    String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        et = findViewById(R.id.uname);
    }

    public void createPassword() {
        userName = et.getText().toString();
        Intent intent = new Intent(this,EnterPassword.class);
        intent.putExtra("uname",userName);
        startActivity(intent);

    }

    public void check(View view){
        DbHelper helper = new DbHelper(this);
        boolean b = helper.checkTable();
        if(b==false && userName!= "null"){
            createPassword();
        }else {
            Toast.makeText(this, "Can't register...\n Already a user", Toast.LENGTH_SHORT).show();
        }

    }

    public void Redirect(View view) {
        if(userName!="null"){
            userName = et.getText().toString();
            Intent i = new Intent(RegisterActivity.this,LoginActivity.class);
            i.putExtra("uname",userName);
            startActivity(i);
        }else{
            Toast.makeText(this, "Please enter the username", Toast.LENGTH_SHORT).show();
        }
    }
}