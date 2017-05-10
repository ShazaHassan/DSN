package com.example.android.dsn;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Mariam  on 10/05/2017.
 */

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "DSN.DB";

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

    // Definition of AnswersOfTasks Table Variables

    public static final String DATABASE_TABLE3 = "AnswersOfTasks";
    public static final String COL_31 = "PathFile";
    public static final String COL_32 = "DeadLine";


    // Definition of Doctor Table Variables

    public static final String DATABASE_TABLE4 = "Doctor";
    public static final String COL_41 = "DocName";
    public static final String COL_42 = "Email";
    public static final String COL_43 = "ID";
    public static final String COL_44 = "DepName";
    public static final String COL_45 = "Password";
    public static final String COL_46 = "Degree";
    public static final String COL_47 = "HOD";



    // Definition of STUDENT Table Variables

  /*  public static final String DATABASE_TABLE5 = "Student";
    public static final String COL_51 = "FName";
    public static final String COL_52 = "MName";
    public static final String COL_53 = "LName";
    public static final String COL_54 = "Email";
    public static final String COL_55 = "Password";
    public static final String COL_56 = "ID";
    public static final String COL_57 = "DepName";
    public static final String COL_58 = "AcYear"; */


    //when this constructor is called , DB will be created


    public DataBaseHelper(Context context) {
        super(context,DATABASE_NAME, null, 1); //constructor which create the database and the tables
        SQLiteDatabase db = this.getWritableDatabase(); //this line is to check that database is created
    }

    public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //Execute the Query written inside the .execSQL

        //yarab
       // db.execSQL("create table" + DATABASE_TABLE1 + "("+ COL_11+ ")" );
        db.execSQL("create table" + DATABASE_TABLE1 + "( FName TEXT , MName TEXT, LName TEXT, Email BLOB, Password BLOB, ID INTEGER PRIMARY KEY AUTOINCREMENT, DepName TEXT, AcYear  INTEGER NOT NULL, Representative BOOLEAN NOT NULL CHECK (Representative IN (0,1)");
        db.execSQL("create table" + DATABASE_TABLE2 + "(TaskNO INTEGER PRIMARY KEY AUTOINCREMENT,Description TEXT, Deadline DATETIME");
        // data type of pathfile attribute didnot detected
       //   db.execSQL("create table" + DATABASE_TABLE3 + "(PathFile ,DeadLine DATETIME");
        db.execSQL("create table" + DATABASE_TABLE4 + "(DocName TEXT,DepName TEXT,HOD BOOLEAN NOT NULL CHECK (HOD IN (0,1) ,Degree TEXT ,ID INTEGER PRIMARY KEY AUTOINCREMENT,Email BLOB, Password BLOB");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + DATABASE_TABLE1);
        db.execSQL("DROP TABLE IF EXISTS" + DATABASE_TABLE2);
        db.execSQL("DROP TABLE IF EXISTS" + DATABASE_TABLE4);
        onCreate(db);


    }
}
