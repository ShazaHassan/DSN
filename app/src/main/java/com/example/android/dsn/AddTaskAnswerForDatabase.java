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

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setSec(String sec) {
        Sec = sec;
    }

    public void setNo(String no) {
        No = no;
    }

    public void setFile(String file) {
        File = file;
    }
}
