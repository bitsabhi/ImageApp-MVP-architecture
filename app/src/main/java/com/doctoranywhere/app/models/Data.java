package com.doctoranywhere.app.models;

import java.util.ArrayList;

public class Data {
    private ArrayList<UserResult> users;

    public ArrayList<UserResult> getUsers() {
        return this.users;
    }

    public void setUsers(ArrayList<UserResult> users) {
        this.users = users;
    }

    private boolean has_more;

    public boolean getHasMore() {
        return this.has_more;
    }

    public void setHasMore(boolean has_more) {
        this.has_more = has_more;
    }
}