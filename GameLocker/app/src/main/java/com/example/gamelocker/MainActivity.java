package com.example.gamelocker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText uname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uname = findViewById(R.id.uname);
    }

    public void registerUser(View view) {
        String name = uname.getText().toString();
        if(name.isEmpty()){
            Toast.makeText(this, "Please enter the username", Toast.LENGTH_SHORT).show();
//        }else{
//            Intent i = new Intent(this,LoginActivity.class);
//            i.putExtra("uname",name);
//            startActivity(i);
        }

    }

}