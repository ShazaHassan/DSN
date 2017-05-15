package com.example.android.dsn;

/**
 * Created by ShazaHassan on 15-May-17.
 */

public class AddTaskAnswerForDatabase {
    private String ID,Name,Sec,No,File;

    public AddTaskAnswerForDatabase(String ID, String name, String sec, String no, String file) {
        this.ID = ID;
        Name = name;
        Sec = sec;
        No = no;
        File = file;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public String getSec() {
        return Sec;
    }

    public String getNo() {
        return No;
    }

    public String getFile() {
        return File;
    }

    public AddTaskAnswerForDatabase() {

    }
}
