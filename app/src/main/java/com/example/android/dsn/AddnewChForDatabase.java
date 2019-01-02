package com.example.android.dsn;

/**
 * Created by ShazaHassan on 16-May-17.
 */

public class AddnewChForDatabase {
    private String ID, ChNO;

    public AddnewChForDatabase(String ID, String chNO) {
        this.ID = ID;
        ChNO = chNO;
    }

    public AddnewChForDatabase() {
    }

    public String getID() {
        return ID;
    }

    public String getChNO() {
        return ChNO;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setChNO(String chNO) {
        ChNO = chNO;
    }
}
