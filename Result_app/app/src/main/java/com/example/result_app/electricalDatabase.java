package com.example.result_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class electricalDatabase extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="electrical";
    public static final int DATABASE_VERSION=1;
    public static final String TABLE_NAME="electrical_data";
    public static final String COLUMN_ID="ID";
    public static final String COLUMN_PROGRAM="Program";
    public static final String COLUMN_REG="RegNo";
    public static final String COLUMN_ROLL="RollNo";
    public static final String COLUMN_NAME="Name";
    public static final String COLUMN_GENDER="Gen";
    public static final String COLUMN_CGPA="CGPA";
    public static final String COLUMN_SGPA="SGPA";
    public static final String COLUMN_REMARK="Remarks";
    public static final String COLUMN_SUPPLY="Supply";

    SQLiteDatabase db;

    public electricalDatabase(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        SQLiteDatabase db =this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql= " CREATE TABLE "+ TABLE_NAME +"(\n"+
                " "+COLUMN_ID+" INTEGER NOT NULL CONSTRAINT employees_pk PRIMARY KEY AUTOINCREMENT,\n"+
                " "+COLUMN_PROGRAM+" varchar(200) NOT NULL,\n"+
                " "+COLUMN_REG+" varchar(200) NOT NULL,\n"+
                " "+COLUMN_ROLL+" varchar(200) NOT NULL,\n"+
                " "+COLUMN_NAME+" varchar(200) NOT NULL,\n"+
                " "+COLUMN_GENDER+" varchar(200) NOT NULL,\n"+
                " "+COLUMN_CGPA+" varchar(200) NOT NULL,\n"+
                " "+COLUMN_SGPA+" varchar(200) NOT NULL,\n"+
                " "+COLUMN_REMARK+" varchar(200) NOT NULL,\n"+
                " "+COLUMN_SUPPLY+" varchar(200) NOT NULL "+
                ");";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String sql=" DROP TABLE IF EXISTS "+ TABLE_NAME + ";";
        db.execSQL(sql);
        onCreate(db);
    }
    Cursor getData(){
        SQLiteDatabase db=getReadableDatabase();
        return db.rawQuery(" SELECT * FROM "+TABLE_NAME,null);
    }
    boolean addData(String Name,String RollNo,String CGPA,String SGPA,String Gender,String Remarks,String Supply)
    {
        ContentValues cv=new ContentValues();
        cv.put(COLUMN_REG,"0000");
        cv.put(COLUMN_PROGRAM,"B.Tech");
        cv.put(COLUMN_NAME,Name);
        cv.put(COLUMN_ROLL,RollNo);
        cv.put(COLUMN_CGPA,CGPA);
        cv.put(COLUMN_SGPA,SGPA);
        cv.put(COLUMN_GENDER,Gender);
        cv.put(COLUMN_REMARK,Remarks);
        cv.put(COLUMN_SUPPLY,Supply);
        SQLiteDatabase db=getWritableDatabase();
        return db.insert(TABLE_NAME,null,cv)!=-1;
    }
}