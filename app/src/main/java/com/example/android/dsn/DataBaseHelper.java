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
    public static final String COL_1 = "FName";
    public static final String COL_2 = "MName";
    public static final String COL_3 = "LName";
    public static final String COL_4 = "Email";
    public static final String COL_5 = "Password";
    public static final String COL_6 = "ID";
    public static final String COL_7 = "DepName";
    public static final String COL_8 = "AcYear";

    // Definition of STUDENT Table Variables

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


    //when this constructor is called , DB will be created

    public DataBaseHelper(Context context) {
        super(context,DATABASE_NAME, null, 1);
    }

    public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //Execute the Query written inside the .execSQL

        db.execSQL("");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
