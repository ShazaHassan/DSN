package com.example.android.dsn;
import  android.database.sqlite.*;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import com.google.android.gms.tasks.Task;

import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;


/**
 * Created by Mariam  on 10/05/2017.
 */

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "DSN.db";

    // Definition of STUDENT Table Variables

    public static final String DATABASE_TABLE1 = "Student";
    public static final String COL_11 = "FName";
    public static final String COL_12 = "MName";
    public static final String COL_13 = "LName";
    public static final String COL_14 = "Email";
    public static final String COL_15 = "Password";
    public static final String COL_16 = "ID";
    public static final String COL_17 = "DepName";
    public static final String COL_18 = "AcYear";
    public static final String COL_19 = "Representative";


    // Definition of TASK Table Variables

    public static final String DATABASE_TABLE2 = "TASK";
    public static final String COL_21 = "TaskNO";
    public static final String COL_22 = "Description";
    public static final String COL_23 = "Deadline";

  /*  // Definition of AnswersOfTasks Table Variables

    public static final String DATABASE_TABLE3 = "AnswersOfTasks";
    public static final String COL_31 = "PathFile";
    public static final String COL_32 = "DeadLine";
*/

    // Definition of Doctor Table Variables

    public static final String DATABASE_TABLE4 = "Doctor";
    public static final String COL_41 = "DocName";
    public static final String COL_42 = "Email";
    public static final String COL_43 = "ID";
    public static final String COL_44 = "DepName";
    public static final String COL_45 = "Password";
    public static final String COL_46 = "Degree";
    public static final String COL_47 = "HOD";



    //when this constructor is called , DB will be created


    public DataBaseHelper(Context context) {
        super(context,DATABASE_NAME, null,4); //constructor which create the database and the tables
        SQLiteDatabase db = this.getWritableDatabase(); //this line is to check that database is created
        SQLiteDatabase db1 = this.getReadableDatabase();

}

    @Override
    //Execute the Query written inside the .execSQL

    public void onCreate(SQLiteDatabase db) {
      //  SQLiteDatabase mydatabase = openOrCreateDatabase("DSN", MODE_PRIVATE,null);

        db.execSQL("create table Student" + "( FName TEXT , MName TEXT, LName TEXT, Email TEXT, Password TEXT, ID INTEGER PRIMARY KEY AUTOINCREMENT, DepName TEXT, AcYear  INTEGER NOT NULL, Representative BOOLEAN NOT NULL CHECK (Representative IN (0,1)");
        db.execSQL("create table TASK" + "(TaskNO INTEGER PRIMARY KEY AUTOINCREMENT,Description TEXT, Deadline DATETIME");

        // data type of path file attribute did not detected
       //   db.execSQL("create table" + DATABASE_TABLE3 + "(PathFile ,DeadLine DATETIME");

      db.execSQL("create table Doctor" + "(DocName TEXT,DepName TEXT,HOD BOOLEAN NOT NULL CHECK (HOD IN (0,1)) ,Degree TEXT ,ID INTEGER PRIMARY KEY AUTOINCREMENT,Email BLOB, Password BLOB");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Student");
        db.execSQL("DROP TABLE IF EXISTS TASK");
        db.execSQL("DROP TABLE IF EXISTS Doctor");
        onCreate(db);


    }
}
