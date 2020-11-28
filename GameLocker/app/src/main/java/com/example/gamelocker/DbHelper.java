package com.example.gamelocker;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DbHelper  extends SQLiteOpenHelper {
//    SQLiteDatabase database;
    private String table_name = "Users";
    private String col_Uname = "username";
    private String col_Pass = "password";

    DbHelper(Context context){
        super(context,"User.db",null,1);
//
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+table_name+"("+col_Uname+" text primary key, "+col_Pass+" text not null ); ");
       // System.out.println("creatning db objet = "+sqLiteDatabase);
       // System.out.println("Created table..");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }

    public long saveCreds(String uname,String pass) {
        Intent i = new Intent();
        i.putExtra("pass",pass);
        SQLiteDatabase database = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("username", uname);
        cv.put("password",pass);
        long ret = database.insert("Users",null,cv);
        System.out.println("Data Inserted..");
        return ret;
    }

    public String[] getCreds(String username) {
        String[] creds = new String[2];
        SQLiteDatabase db = getReadableDatabase();
        Cursor resultset = db.rawQuery("SELECT * FROM Users where username = "+"'"+username+"';",null);
        resultset.moveToFirst();
        String uname = resultset.getString(0);
        String pass = resultset.getString(1);
        System.out.println(uname+","+pass);
        creds[0] = uname;
        creds[1] = pass;
        return creds;
    }

    public boolean checkTable(){
        boolean bool;
        SQLiteDatabase db = getReadableDatabase();
        Cursor resultset = db.rawQuery("SELECT * FROM Users ",null);
        bool = resultset.moveToFirst();
        return bool;
    }
}