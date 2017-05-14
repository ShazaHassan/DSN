package com.example.android.dsn;

/**
 * Created by ShazaHassan on 13-May-17.
 */

public class RegistrationForDatabase {
    String UserID,userName,email,password;

    public RegistrationForDatabase(String userID, String userName, String email, String password) {
        this.UserID = userID;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public RegistrationForDatabase() {
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getUserID() {
        return UserID;
    }

    public String getPassword() {
        return password;
    }
}
