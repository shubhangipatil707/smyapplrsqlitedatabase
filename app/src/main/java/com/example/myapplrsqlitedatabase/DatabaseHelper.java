package com.example.myapplrsqlitedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
        public static final String DatabaseName="bankdb1";
        public static final String TableName1="login";
        public static final String tb1_col1="username";
        public static final String tb1_col2="password";
        public static final String tb1_col3="gender";
        public static final String tb1_col4="account_type";


        public DatabaseHelper(@Nullable Context context) {
            super(context, DatabaseName, null, 1);
            SQLiteDatabase dbobj=this.getWritableDatabase();
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("Create table "+TableName1+"("+tb1_col1+" text,"+tb1_col2+" text,"+tb1_col3+" text,"+tb1_col4+" text)");
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("Drop table if exists "+TableName1);
            onCreate(db);
        }
        public boolean insertData1(String username,String password,String gender,String account_type){
            SQLiteDatabase db=this.getWritableDatabase();
            ContentValues contentValues=new ContentValues();
            contentValues.put(tb1_col1,username);
            contentValues.put(tb1_col2,password);
            contentValues.put(tb1_col3,gender);
            contentValues.put(tb1_col4,account_type);

            long result=db.insert(TableName1,null,contentValues);
            if(result==1)
                return  false;
            else
                return  true;
        }

        public Cursor GetAllData1(){
            SQLiteDatabase db=this.getWritableDatabase();
            Cursor result=db.rawQuery("select * from "+TableName1,null);
            return result;
        }
        public Cursor findOne(String id) {
            SQLiteDatabase db=this.getWritableDatabase();
            Cursor result=db.rawQuery("select * from "+TableName1+" WHERE id=?",new String[]{id});
            return  result;
        }
        public Integer deleteOne(String id){
            SQLiteDatabase db=this.getWritableDatabase();
            return db.delete(TableName1,"id=?",new String[]{id});
        }

    }



