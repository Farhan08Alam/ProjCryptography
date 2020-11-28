package com.example.gamelocker;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class LoginActivity extends AppCompatActivity {

    GridView gridView;
    int [] images;
    String[] codes;
    private String pass = "";
    private int count =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        gridView = findViewById(R.id.gridV);
        populateImages();
        genCode();
        MyAdapter adapter = new MyAdapter(LoginActivity.this,images);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new MyItemlickListener());

    }
    private void populateImages(){
        images = new int[]{R.drawable.f1,R.drawable.f2,R.drawable.f3,R.drawable.f4,R.drawable.f5,R.drawable.f6,
                R.drawable.f7,R.drawable.f8,R.drawable.f9,R.drawable.f10,R.drawable.f11,R.drawable.f12,R.drawable.f13,
                R.drawable.f14,R.drawable.f15,R.drawable.f16,R.drawable.f17,R.drawable.f18,R.drawable.f19,R.drawable.f20,
                R.drawable.f21,R.drawable.f22,R.drawable.f23,R.drawable.f24,R.drawable.f25,R.drawable.f26,R.drawable.f27,
                R.drawable.f28,R.drawable.f29,R.drawable.f30,R.drawable.f31,R.drawable.f32,R.drawable.f33,R.drawable.f34,
                R.drawable.f35,R.drawable.f36,R.drawable.f37,R.drawable.f38,R.drawable.f39,R.drawable.f40,R.drawable.f41,
                R.drawable.f42,R.drawable.f43,R.drawable.f44,R.drawable.f45,R.drawable.f46,R.drawable.f47,R.drawable.f48,
                R.drawable.f49,R.drawable.f50,R.drawable.f51,R.drawable.f52,R.drawable.f53,R.drawable.f54,R.drawable.f55,
                R.drawable.f56,R.drawable.f57,R.drawable.f58,R.drawable.f59,R.drawable.f60,R.drawable.f61,R.drawable.f62,
                R.drawable.f63,R.drawable.f64};
    }

    public void Login(View view) {
        String uname = getIntent().getStringExtra("uname");
        DbHelper helper = new DbHelper(this);
        String[] credsInfo = helper.getCreds(uname);
        if(credsInfo[0].equals(uname) && credsInfo[1].equals(pass)){
            Intent i = new Intent(this,HomeActivity.class);
            startActivity(i);
        }else {
            Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
        }

    }

    class MyItemlickListener implements AdapterView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            pass += codes[i];
            System.out.println(i);
            System.out.println(pass);
            count++;
        }
    }

    private void genCode(){

        codes = new String[]{
                "chAgs9","8hsaIP","4VsIga","oxZ43h","di48yJ","h57Bsj","alwp8C","lmX29n","qe4Nda","sW04tr",
                "cepk8H","XKe2wk","Hel3lo","lInJ3k","B1asp0","29LCwj","0dpJds","sjP4Nf","Cdj31a","qW63vx",
                "xcMi3M","yTi6rw","39Nriw","mCe5ih","Abcde5","alr3n9","tb8Grx","cvd46P","hNk7mw","lMzp0s",
                "trE38M","h2JlXi","iP32vn","hAdEs8","ne6Kb3","t0Qpgr","dXl9jY","ew91Nv","1lVc1t","cU2KsA",
                "bZ8Lod","xQp71d","scI1G0","pdYbd7","asl39J","bsS14p","pAL2f9","be0enL","m8Q3ka","yFtm63",
                "nrL1c5","8hsaIP","dTeN6r","nzXn3r","99Nedi","e5MRtq","qrPg5v","PO4bxe","0Fle9c","g6xi5W",
                "dPns2n","poLs4n","xzRmn3","LfN3d2"
        };

    }

}