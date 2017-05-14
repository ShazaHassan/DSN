package com.example.android.dsn;

/**
 * Created by ShazaHassan on 14-May-17.
 */

public class PutPostInDatabase {
    private String post, ID;

    public PutPostInDatabase() {
    }

    public PutPostInDatabase(String post,String ID) {
        this.post = post;
        this.ID=ID;
    }
    public void setID(String ID) {
        this.ID = ID;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getPost() {
        return post;
    }

    public String getID() {
        return ID;
    }
}
