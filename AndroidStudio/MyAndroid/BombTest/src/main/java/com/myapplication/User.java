package com.myapplication;

import cn.bmob.v3.BmobObject;

/**
 * Created by YR on 2015/5/2.
 */
public class User extends BmobObject{
    private String user;
    private String text;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
