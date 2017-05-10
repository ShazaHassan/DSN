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
/*
    public static final String DATABASE_TABLE2 = "Student";
    public static final String COL_1 = "FName";
    public static final String COL_2 = "MName";
    public static final String COL_3 = "LName";
    public static final String COL_4 = "Email";
    public static final String COL_5 = "Password";
    public static final String COL_6 = "ID";
    public static final String COL_7 = "DepName";
    public static final String COL_8 = "AcYear";

    // Definition of STUDENT Table Variables

    public static final String DATABASE_TABLE3 = "Student";
    public static final String COL_1 = "FName";
    public static final String COL_2 = "MName";
    public static final String COL_3 = "LName";
    public static final String COL_4 = "Email";
    public static final String COL_5 = "Password";
    public static final String COL_6 = "ID";
    public static final String COL_7 = "DepName";
    public static final String COL_8 = "AcYear";

    // Definition of STUDENT Table Variables

    public static final String DATABASE_TABLE4 = "Student";
    public static final String COL_1 = "FName";
    public static final String COL_2 = "MName";
    public static final String COL_3 = "LName";
    public static final String COL_4 = "Email";
    public static final String COL_5 = "Password";
    public static final String COL_6 = "ID";
    public static final String COL_7 = "DepName";
    public static final String COL_8 = "AcYear";

    // Definition of STUDENT Table Variables

    public static final String DATABASE_TABLE5 = "Student";
    public static final String COL_1 = "FName";
    public static final String COL_2 = "MName";
    public static final String COL_3 = "LName";
    public static final String COL_4 = "Email";
    public static final String COL_5 = "Password";
    public static final String COL_6 = "ID";
    public static final String COL_7 = "DepName";
    public static final String COL_8 = "AcYear";
*/
    //Definition of Subject table
    public static final String DATABASE_TABLE6 = "Subject";
    public static final String COL_61 = "SubjectName";
    public static final String COL_62 = "Code";
    public static final String COL_63 = "DepName";
    public static final String COL_64 = "DocID";
    public static final String COL_65 = "Semester";
    public static final String COL_66 = "Year";

  /*  public static final String DATABASE_TABLE5 = "Student";
    public static final String COL_51 = "FName";
    public static final String COL_52 = "MName";
    public static final String COL_53 = "LName";
    public static final String COL_54 = "Email";
    public static final String COL_55 = "Password";
    public static final String COL_56 = "ID";
    public static final String COL_57 = "DepName";
    public static final String COL_58 = "AcYear"; */

    //Definition of Subject of Student
    public static final String DATABASE_TABLE7 = "SubjectOfStudent";
    public static final String COL_71 = "IDStudent";
    public static final String COL_72 = "Sub1";
    public static final String COL_73 = "Sub2";
    public static final String COL_74 = "Sub3";
    public static final String COL_75 = "Sub4";
    public static final String COL_76 = "Sub5";
    public static final String COL_77 = "Sub6";
    public static final String COL_78 = "Sub7";
    public static final String COL_79 = "Sub8";
    public static final String COL_710 = "Sub9";
    public static final String COL_711 = "Sub10";
    public static final String COL_712= "Sub11";
    public static final String COL_713 = "Sub12";


    //Definition of Question
    public static final String DATABASE_TABLE8 = "Question";
    public static final String COL_81 = "IDDr";
    public static final String COL_82 = "IDStudent";
    public static final String COL_83 = "Question";
    public static final String COL_84 = "Answer";
    public static final String COL_85 = "Important";


    //Definition of ...
    public static final String DATABASE_TABLE9 = "Student";
    public static final String COL_91 = "FName";
    public static final String COL_92 = "MName";
    public static final String COL_93 = "LName";
    public static final String COL_94 = "Email";
    public static final String COL_95 = "Password";
    public static final String COL_96 = "ID";
    public static final String COL_97 = "DepName";
    public static final String COL_98 = "AcYear";

    //Definition of ....
    public static final String DATABASE_TABLE10 = "Student";
    public static final String COL_101 = "FName";
    public static final String COL_102 = "MName";
    public static final String COL_103 = "LName";
    public static final String COL_104 = "Email";
    public static final String COL_105 = "Password";
    public static final String COL_106 = "ID";
    public static final String COL_107 = "DepName";
    public static final String COL_108 = "AcYear";
    //when this constructor is called , DB will be created


    public DataBaseHelper(Context context) {
        super(context,DATABASE_NAME, null, 1); //constructor which create the database and the tables
        SQLiteDatabase db = this.getWritableDatabase(); //this line is to check that database is created
    }

    public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, DATABASE_NAME,null,1);
        SQLiteDatabase db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //Execute the Query written inside the .execSQL
//create table for subject
      db.execSQL("create table SUBJECT"+
                "(SubjectName TEXT,Code INTEGER PRIMARY KEY ,DepName TEXT,DocID INTEGER,Semester TEXT,Year TEXT)" +
                "DocID IS NULL OR EXISTS(SELECT 1 FROM Doctor WHERE ID=DocID)");
//create table for subject of student
     db.execSQL("create table SUBJECTOFSTUDENT"+
                "(IDStudent INTEGER PRIMARY KEY ,Sub1 INTEGER,Sub2 INTEGER,Sub3 INTEGER,Sub4 INTEGER," +
                "Sub5 INTEGER, sub6 INTEGER, sub7 INTEGER,sub8 INTEGER,sub9 INTEGER, sub10 INTEGER, sub11 INTEGER, sub12 INTEGER)");
// create table for quetion

        //yarab
       // db.execSQL("create table" + DATABASE_TABLE1 + "("+ COL_11+ ")" );
        db.execSQL("create table" + DATABASE_TABLE1 + "( FName TEXT , MName TEXT, LName TEXT, Email BLOB, Password BLOB, ID INTEGER PRIMARY KEY AUTOINCREMENT, DepName TEXT, AcYear  INTEGER NOT NULL, Representative BOOLEAN NOT NULL CHECK (Representative IN (0,1)");
        db.execSQL("create table" + DATABASE_TABLE2 + "(TaskNO INTEGER PRIMARY KEY AUTOINCREMENT,Description TEXT, Deadline DATETIME");
        // data type of pathfile attribute didnot detected
       //   db.execSQL("create table" + DATABASE_TABLE3 + "(PathFile ,DeadLine DATETIME");
        db.execSQL("create table" + DATABASE_TABLE4 + "(DocName TEXT,DepName TEXT,HOD BOOLEAN NOT NULL CHECK (HOD IN (0,1) ,Degree TEXT ,ID INTEGER PRIMARY KEY AUTOINCREMENT,Email BLOB, Password BLOB");
        db.execSQL("create table QUESTION"+
                "(IDDr INTEGER,IDStudent INTEGER,Question Text, Answer TEXT, Important BOOLEAN NOT NULL CHECK (Important IN (1,0)))");
       db.execSQL("create table STUDENT ( FName TEXT , MName TEXT, LName TEXT, Email BLOB, Password BLOB, ID INTEGER PRIMARY KEY AUTOINCREMENT, DepName TEXT, AcYear  INTEGER NOT NULL, Representative BOOLEAN NOT NULL CHECK (Representative IN (0,1)");
        db.execSQL("create table TASK(TaskNO INTEGER PRIMARY KEY AUTOINCREMENT,Description TEXT, Deadline DATETIME");
        //db.execSQL("create table" + DATABASE_TABLE4 + "(DocName TEXT,DepName TEXT,HOD BOOLEAN NOT NULL CHECK (HOD IN (0,1) ,Degree TEXT ,ID INTEGER PRIMARY KEY AUTOINCREMENT,Email BLOB, Password BLOB");



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + DATABASE_TABLE1);
        db.execSQL("DROP TABLE IF EXISTS" + DATABASE_TABLE2);
        db.execSQL("DROP TABLE IF EXISTS" + DATABASE_TABLE4);
        db.execSQL("DROP TABLE IF EXIST STUDENT");
        db.execSQL("DROP TABLE IF EXIST SUBJECT");
        db.execSQL("DROP TABLE IF EXIST SUBJECTOFSTUDENT");
        db.execSQL("DROP TABLE IF EXISTS TASK");
        db.execSQL("DROP TABLE IF EXISTS QUESTION");
     //   db.execSQL("DROP TABLE IF EXISTS" + DATABASE_TABLE4);
        onCreate(db);


    }
}
